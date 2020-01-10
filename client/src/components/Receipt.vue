<template>
  <v-app id="inspire" :style="{ backgroundImage: 'url(' + require('@/assets/f.jpg') + ')' }">
  <v-app-bar app color="blue darken-2">
      <v-toolbar-title class="headline text-uppercase">
        <span>Health</span>
        <span class="font-weight-light"> Insurance</span>
      </v-toolbar-title>
      <v-spacer></v-spacer>
      <v-btn color="grey lighten-5">
        <router-link class="mr-1" to="/receipt">New Receipt</router-link>
      </v-btn>&nbsp;
      <v-btn color="grey lighten-5">
        <router-link class="mr-1" to="/viewReceipt">Receipt Information</router-link>
      </v-btn>&nbsp;
       <v-btn color="grey lighten-5">
        <router-link class="mr-1" to="/">Logout</router-link>
      </v-btn>&nbsp;
    </v-app-bar>
      <div class="bgn">

          <br/>
      <div class="text-center">
        <v-avatar>
          <img src="https://img2.freepng.es/20180410/yie/kisspng-invoice-payment-electronic-billing-money-computer-invoice-5acc3eaf2c9139.5288399415233348311826.jpg" alt="avatar">
        </v-avatar>
        <br/>
      </div>
      <h1 align='center' class="display-1 font-weight-bold mb-2">Health Insurance Receipt</h1>
         <v-container nowrap  class="justify-center">  
           <v-form v-model="valid" ref="form">
            <v-layout  row nowrap class="justify-center">
              <v-col cols="4">
                  <v-text-field
                      class="justify-center"
                      label="ค้นหาIDลูกค้า"
                      style="width:300px"
                      solo
                      v-model="receipt.customerIdent"
                  ></v-text-field>
              </v-col>
            </v-layout>

              <v-layout  row nowrap class="justify-center">
             <v-col cols="4">
              <p align = 'center' v-if="customerCheck != ''" >Customer Name : {{customerName}}</p>
             </v-col>
              </v-layout>
              
            
             
               <v-layout  row nowrap class="justify-center">
              <v-col cols="4">
                  <v-btn class="justify-center" @click="findCustomer" depressed large color="primary">Search</v-btn>
              </v-col>
               </v-layout>
              <br>

              <v-layout  row nowrap class="justify-center">
               <v-col cols="4">
                  <v-select
                    style="width: 300px"
                    label="Insurance"
                    solo
                    v-model="receipt.paidtypeId"
                    :items="paidtype"
                    item-text="paid"
                    item-value="id"
                    :rules="[(v) => !!v || 'Item is required']"
                  ></v-select>
               </v-col>
              </v-layout>

              <v-layout  row nowrap class="justify-center">
               <v-col cols="4">
                 <v-select
                  style="width: 300px"
                  label="Employee"
                  solo
                  v-model="receipt.employeeId"
                  :items="employee"
                  item-text="empName"
                  item-value="id"
                  :rules="[(v) => !!v || 'Item is required']"
                  required
                ></v-select>
               </v-col>
              </v-layout>

              <v-layout  row nowrap class="justify-center">
                <v-col cols="4">
                 <v-select
                 style="width: 300px"
                  label="Branch"
                  solo
                  v-model="receipt.branchId"
                  :items="branch"
                  item-text="name_br"
                  item-value="id"
                  :rules="[(v) => !!v || 'Item is required']"
                  required
                ></v-select>
                </v-col>
              </v-layout>

                <v-layout  row nowrap class="justify-center">
              <v-col cols="3">  
                <v-btn @click="saveReceipts" :class="{ red: !valid, green: valid }">save</v-btn>
                <v-btn style="margin-left: 15px;" @click="clear">clear</v-btn>
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
    name: "receipt",
   data() {
    return {
      receipt: {
       
        customerIdent: "",
        paidtypeId:"",
        employeeId: "",
        branchId: "",

        
      },
      valid: false,
      customerCheck: false,
      customerName: "",
      drawer: false
    };
  },
  methods:{
   /* eslint-disable */
      getPaidtypes(){
        http
        .get("/paidtype")
        .then(response =>{
          this.$forceUpdate();
          this.paidtype = response.data;
          console.log(response.data);
        })
        .catch(e =>{
          console.log(e);
        });
      },
      getEmployees(){
        http
        .get("/employee")
        .then(response =>{
          this.$forceUpdate();
          this.employee = response.data;
          console.log(response.data);
        })
        .catch(e =>{
          console.log(e);
        })
      },
      getBranchs(){
        http
        .get("/branch")
        .then(response =>{
          this.branch = response.data;
          console.log(response.data);
        })
        .catch(e =>{
          console.log(e);
        })
      },
      
     findCustomer() {
          http
            .get("/customer/"+ this.receipt.customerIdent)
            .then(response => {
              console.log(response);
              if (response.data.cusName != null) {
                this.customerName = response.data.cusName;
                this.customerCheck = response.status;
                alert('ค้นหาสำเร็จ')
                alert(this.claim.customerIdent)
              
              } else {
                alert('ไม่พบข้อมูล')
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
    saveReceipts() {
          http
        .post(
          // {customer_id}/{paidtype_id}/{employee_id}/{branch_id}
          "/receipt/" +
            this.receipt.customerIdent +
            "/" +
            this.receipt.paidtypeId +
            "/" +
            this.receipt.employeeId +
            "/" +
            this.receipt.branchId ,
           
          this.receipt
        )
       .then(response => {
          console.log(response);
          this.$router.push("/viewReceipt");
          alert('บันทึกข้อมูลเสร็จสิ้น')
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
  
    refreshList() {
      this.getPaidtypes();
      this.getEmployees();
      this.getBranchs();
      this.saveReceipts();
    },
    
  },
      mounted() {
      this.getPaidtypes();
      this.getEmployees();
      this.getBranchs();
      this.saveReceipts();
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