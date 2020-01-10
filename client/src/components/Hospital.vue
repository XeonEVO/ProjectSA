<template>
  
  <v-app id="inspire" :style="{ backgroundImage: 'url(' + require('@/assets/b.jpg') + ')' }">
  <v-app-bar app color="blue darken-2">
      <v-toolbar-title class="headline text-uppercase">
        <span>Health</span>
        <span class="font-weight-light"> Insurance</span>
      </v-toolbar-title>
      <v-spacer></v-spacer>
      <v-btn color="grey lighten-5">
        <router-link class="mr-1" to="/hospital">New Hospital</router-link>
      </v-btn>&nbsp;
      <v-btn color="grey lighten-5">
        <router-link class="mr-1" to="/viewHospital">Hospital Informartion</router-link>
      </v-btn>&nbsp;
      <v-btn color="grey lighten-5">
        <router-link class="mr-1" to="/">Logout</router-link>
      </v-btn>&nbsp;
    </v-app-bar>
    <div class='bgn'>                   
    <br>
    <div class="text-center">
    <v-avatar>
      <img src="http://cdn.onlinewebfonts.com/svg/img_316596.png" alt="avatar">
    </v-avatar>
  </div>
      <h1 align='center'>บันทึกข้อมูลสถานพยาบาล</h1>
    
    <v-container nowrap  class="justify-center">
      <v-form v-model="valid" ref="form">
      <v-layout  row  class="justify-center">
      <v-col cols="5">
          <v-text-field
            solo
            label="ชื่อโรงพยาบาล"
            v-model="hospital.hname"
            :items="hname"
            :rules="[(v) => !!v || 'ชื่อโรงพยาบาล']"
            required
          ></v-text-field>
        </v-col>
        </v-layout>

           <v-layout  row  class="justify-center">
            <v-col cols="5">             
                  <v-select
                  solo
                    style="width: 300px"
                    label="คลินิก/โรงพยาบาล"
                    v-model="hospital.clinichospitalId"
                    :items="clinichospital"
                    item-text="clinichospitalName"
                    item-value="id"
                    :rules="[(v) => !!v || 'Item is required']"
                  ></v-select>
               </v-col>
            </v-layout>
      
            <v-layout  row  class="justify-center">
            <v-col cols="5">               
                  <v-select
                  solo
                    style="width: 300px"
                    label="ประเภทโรงพยาบาล"
                    v-model="hospital.hospitaltypeId"
                    :items="hospitaltype"
                    item-text="hospitaltypeName"
                    item-value="id"
                    :rules="[(v) => !!v || 'Item is required']"
                  ></v-select>
            </v-col>
            </v-layout>
               
      
             <v-layout  row  class="justify-center">
            <v-col cols="5">    
                  <v-select
                  solo
                    style="width: 300px"
                    label="จังหวัด"
                    v-model="hospital.provinceId"
                    :items="provinces"
                    item-text="province"
                    item-value="id"
                    :rules="[(v) => !!v || 'Item is required']"
                  ></v-select>
            </v-col>
            </v-layout>
              
              
              <v-layout  row  class="justify-center">
            <v-col cols="3">   
                <v-row justify="center">
              <v-col cols="12">  
                <v-btn @click="saveHospitals" :class="{ red: !valid, green: valid }">save</v-btn>
                <v-btn style="margin-left: 15px;" @click="clear">clear</v-btn>
              </v-col>
            </v-row>
            </v-col>
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
    name: "hospital",
   data() {
    return {
      hospital: {
       
        hospitalname: "",
        clinichospitalId:"",
        hospitaltypeId: "",
        provinceId: "",

        
      },
      valid: false,
      drawer: false
    };
  },
  methods:{
   /* eslint-disable */
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
        });
      },
      getClinichospitals(){
        http
        .get("/clinichospital")
        .then(response =>{
          this.$forceUpdate();
          this.clinichospital = response.data;
          console.log(response.data);
        })
        .catch(e =>{
          console.log(e);
        })
      },
      getHospitaltypes(){
        http
        .get("/hospitaltype")
        .then(response =>{
          this.$forceUpdate();
          this.hospitaltype = response.data;
          console.log(response.data);
        })
        .catch(e =>{
          console.log(e);
        })
      },
      getProvinces() {
      http
        .get("/province")
        .then(response => {
          this.$forceUpdate();
          this.provinces = response.data;
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
      },
      
      
    saveHospitals() {
          http
        .post(
          // ("/hospital/{hname}/{clinichospital_id}/{hospitaltype_id}/{province_id}")
          "http://localhost:9000/hospital/" +
            this.hospital.hname +
            "/" +
            this.hospital.clinichospitalId +
            "/" +
            this.hospital.hospitaltypeId +
            "/" +
            this.hospital.provinceId ,
           
          this.hospital
        )
        .then(response => {
          console.log(response);
          if(response = true){
            alert('บันทึกข้อมูลเสร็จสิ้น')
            this.$router.push("/viewHospital");
          } 
          this.$refs.form.reset();
          
        })
        .catch(e => {
          console.log(e);
           if(e = true){
            alert('กรุณากรอกข้อมูลให้ครบถ้วน')

            
            
          }
        });
      this.submitted = true;
    },
    refreshList() {
      this.getHospitals();
      this.getClinichospitals();
      this.getHospitaltypes();
      this.getProvinces();
    },
    
  },
      mounted() {
       this.getHospitals();
      this.getClinichospitals();
      this.getHospitaltypes();
      this.getProvinces();
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




