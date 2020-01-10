<template>
  <v-app id="inspire" :style="{ backgroundImage: 'url(' + require('@/assets/c.jpeg') + ')' }">
  <v-app-bar app color="blue darken-2">
      <v-toolbar-title class="headline text-uppercase">
        <span>Health</span>
        <span class="font-weight-light"> Insurance</span>
      </v-toolbar-title>
      <v-spacer></v-spacer>
      <v-btn color="grey lighten-5">
        <router-link class="mr-1" to="/claim">New Claim</router-link>
      </v-btn>&nbsp;
      <v-btn color="grey lighten-5">
        <router-link class="mr-1" to="/viewClaim">Claim information</router-link>
      </v-btn>&nbsp;
      <v-btn color="grey lighten-5">
        <router-link class="mr-1" to="/menu">Home</router-link>
      </v-btn>&nbsp;
      <v-btn color="grey lighten-5">
        <router-link class="mr-1" to="/">Logout</router-link>
      </v-btn>&nbsp;
    </v-app-bar>
    <div class="bgn">
     br/>
      <div class="text-center">
        <v-avatar>
          <img src="https://image.flaticon.com/icons/svg/1576/1576489.svg" alt="avatar">
        </v-avatar>
        <br/>
      </div>
      <h1 align='center' class="display-1 font-weight-bold mb-2">รายละเอียดการรักษาพยาบาล</h1> 
    <v-container nowrap  class="justify-center">
      <v-form v-model="valid" ref="form">
      <v-layout  row nowrap class="justify-center">
        
        <v-flex md12 xs12 lg12 xl3>
              <v-col>
              <h3 class="text-center">
                <br /><br />
                      
              </h3>
              </v-col>
        </v-flex>  
            <div class="justify-center">
              <v-flex md12 xs12 lg12 xl3>
                  <v-text-field
                      class="justify-center"
                      label="ค้นหาIDลูกค้า"
                      style="width:300px"
                      v-model="claim.customerIdent"
                  ></v-text-field>
              </v-flex>
            </div>

             <v-flex md12 xs12 lg12 xl3>
              <p  class="text-center" lg12 xs3 v-if="customerCheck != ''" >Customer Name : {{customerName}}</p>
              </v-flex>
            
             <div class="btncenter">
              <v-flex md12 xs12 lg12 xl3>
                  <v-btn class="justify-center" @click="findCustomer" depressed large color="primary">ค้นหา</v-btn>
              </v-flex>

           
               <v-flex md6 xs12 lg12 xl3>
                  <v-select
                    style="width: 300px"
                    label="ให้สั่งจ่ายเช็คในนามของ"
                    v-model="claim.paychecksId"
                    :items="paychecks"
                    item-text="payto"
                    item-value="id"
                    :rules="[(v) => !!v || 'Item is required']"
                  ></v-select>
               </v-flex>
       
               <v-flex md6 xs12 lg12 xl3>
                 <v-select
                  label="ได้รับการตรวจโดยวิธี"
                  style="width: 300px"
                  v-model="claim.treatmethodId"
                  :items="treatmethod"
                  item-text="treatby"
                  item-value="id"
                  :rules="[(v) => !!v || 'Item is required']"
                  required
                ></v-select>
               </v-flex>
          
                <v-flex md6 xs12 lg12 xl3>
                 <v-select
                  label="วิธีการรับการรักษา"
                  style="width: 300px"
                  v-model="claim.curebyId"
                  :items="cureby"
                  item-text="curemeth"
                  item-value="id"
                  :rules="[(v) => !!v || 'Item is required']"
                  required
                ></v-select>
                </v-flex>

                <v-flex md6 xs12 lg12 xl3>
                  <v-select
                  style="width: 300px"
                  label="แพ็คเก็จที่สมัครกับเรา"
                  v-model="claim.insurancepackageId"
                  :items="insurancepackages"
                  item-text="pack"
                  item-value="id"
                  :rules="[(v) => !!v || 'Item is required']"
                  required
                ></v-select>
                </v-flex>
                <v-flex md6 xs12 lg12 xl3 >
                  <v-select
                  label="โรงพยาบาลที่เข้ารับการรักษา"
                  style="width: 300px"
                  v-model="claim.hospitalId"
                  :items="hospital"
                  item-text="hname"
                  item-value="id"
                  :rules="[(v) => !!v || 'Item is required']"
                  required
                ></v-select>
                </v-flex>
                <div class="btncenter">
            <v-col cols="12">
              <v-btn large class="justify-center" md4 style="hight:300" depressed @click="saveClaims" :class="{ red: !valid, green: valid }">ส่งแบบฟอร์ม</v-btn>  
            </v-col>
            </div>
              
             </div>
      </v-layout>
     </v-form>
           
           
    </v-container>
    </div> 
  </v-app>
</template>

<script>
import http from "../http-common";
  export default {
    props: {
      source: String,
    },
    name: "claim",
   data() {
    return {
      claim: {
       
        hospitalId: "",
        insuranceId:"",
        customerIdent: "",
        treatmethodId: "",
        paychecksId: "",
        curebyId: "",
        insurancepackageId: "",
        
      },
      valid: false,
      customerCheck: false,
      customerName: "",
      drawer: false
    };
  },
  methods:{
   /* eslint-disable */
      getPaycheckss(){
        http
        .get("/paychecks")
        .then(response =>{
          this.$forceUpdate();
          this.paychecks = response.data;
          console.log(response.data);
        })
        .catch(e =>{
          console.log(e);
        });
      },
      getTreatmethods(){
        http
        .get("/treatmethod")
        .then(response =>{
          this.$forceUpdate();
          this.treatmethod = response.data;
          console.log(response.data);
        })
        .catch(e =>{
          console.log(e);
        })
      },
      getHospitals(){
        http
        .get("/hospital")
        .then(response =>{
          this.$forceUpdate();
          this.hospital = response.data;
          console.log(response.data);
        })
        .catch(e =>{
          console.log(e);
        })
      },
      getInsurances(){
        http
        .get("/insurancepackage")
        .then(response =>{
          this.$forceUpdate();
          this.insurancepackages = response.data;
          console.log(response.data);
        })
        .catch(e =>{
          console.log(e);
        })
      },
      getCurebies(){
      http
      .get("/cureby")
      .then(response =>{
        this.cureby = response.data;
        this.$forceUpdate();
        console.log(response.data);
      })
      .catch(e =>{
        console.log(e);
      })
    },
      findCustomer() {
          http
            .get("/customer/"+ this.claim.customerIdent)
            .then(response => {
              console.log(response);
              if (response.data.cusName != null) {
                this.customerName = response.data.cusName;
                this.customerCheck = response.status;
                alert('ค้นหาสำเร็จ')
                alert(this.claim.customerIdent)
              
              } else {
                alert('ไม่พบ ID ที่ค้นหา')
                this.clear()
              }          
            })
            .catch(e => {
              console.log(e);
            });
          this.submitted = true;
        },
        clear() {
      this.$refs.form.reset();
      this.customerCheck = false;
    },
    saveClaims() {
          http
        .post(
          // {hospital_id}/{insurance_id}/{customer_id}/{treatmethod_id}/{paychecks_id}/{cureby_id}
          "/Claim/" +
            this.claim.hospitalId +
            "/" +
            this.claim.insurancepackageId +
            "/" +
            this.claim.customerIdent +
            "/" +
            this.claim.treatmethodId +
            "/" +
            this.claim.paychecksId +
            "/" +
            this.claim.curebyId,
          this.claim
        )
        .then(response => {
          console.log(response);
          if(response = true){
            alert('บันทึกข้อมูลเสร็จสิ้น')
            const userId = this.claim.customerIdent
            this.$router.push("/viewClaim");
          } 
          this.$refs.form.reset();
          this.customerCheck = false;
        })
        .catch(e => {
          console.log(e);
           if(e = true){
            alert('การบันทึกข้อมูลผิดพลาด')
            
            this.clear()
          }
        });
      this.submitted = true;
    },
    refreshList() {
      this.getPaycheckss();
      this.getTreatmethods();
      this.getHospitals();
      this.getInsurances();
      this.getCurebies();
      this.saveClaims();
    },
    
  },
      mounted() {
      this.getPaycheckss();
      this.getTreatmethods();
      this.getHospitals();
      this.getInsurances();
      this.getCurebies();
      }
  
};
</script>

<style>
.btncenter{
    
    display: block;
    margin-left: auto;
    margin-right: auto;
}
</style>