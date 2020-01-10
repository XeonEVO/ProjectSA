
<template>
<v-app id="inspire" :style="{ backgroundImage: 'url(' + require('@/assets/g.jpeg') + ')' }">
<v-app-bar app color="blue darken-2">
      <v-toolbar-title class="headline text-uppercase">
        <span>Health</span>
        <span class="font-weight-light"> Insurance</span>
      </v-toolbar-title>
      <v-spacer></v-spacer>
      <v-btn color="grey lighten-5">
        <router-link class="mr-1" to="/healthInsurance">New Health Insurance</router-link>
      </v-btn>&nbsp;
       <v-btn color="grey lighten-5">
        <router-link class="mr-1" to="/viewHealthInsurance">Health Insurance Informartion</router-link>
      </v-btn>&nbsp;
      <v-btn color="grey lighten-5">
        <router-link class="mr-1" to="/">Logout</router-link>
      </v-btn>&nbsp;
    </v-app-bar>
<div class="bgn">
  <v-layout text-center wrap>
      <v-flex mb-4>
        <br />
       <div class="text-center">
    <v-avatar>
      <img src="https://www.pinclipart.com/picdir/middle/146-1468731_college-survival-guide-3-icon-hospital-icon-red.png" alt="avatar">
    </v-avatar>
  </div>
  <br/>
        <h1 class="display-2 font-weight-bold mb-3">Health Insurance</h1>
      </v-flex>
    </v-layout>

  <v-container fluid>
    <v-row justify="center">
  <v-form v-model="valid" ref="form">
    <v-row>
    <v-container>
    <v-row justify="center">
      <v-col class="d-flex" cols="12" sm="10">
        <v-select
            label="เลือกประกันสุขภาพ"
            solo
            v-model="healthinsurance.insurancetypeId"
            :items="insurancetype"
            item-text="intype"
            item-value="id"
            :rules="[(v) => !!v || 'กรุณาเลือกประกัน']"
            required
          ></v-select>
      </v-col>
      </v-row>
      </v-container>

      <v-container>
      <v-row justify="center">
      <v-col class="d-flex" cols="12" sm="10">
        <v-select
            label="เลือกรูปแบบการจ่ายประกันสุขภาพ"
            solo
             v-model="healthinsurance.paidtypeId"
            :items="paidtype"
            item-text="paid"
            item-value="id"
            :rules="[(v) => !!v || 'กรุณาเลือกรูปแบบการจ่าย']"
            required
          ></v-select>
      </v-col>
      </v-row>
      </v-container>

      <v-container>
      <v-row justify="center">
      <v-col class="d-flex" cols="12" sm="10">
        <v-select
            label="เลือกแพ็คเก็จประกันสุขภาพ"
            solo
             v-model="healthinsurance.insurancepackageId"
            :items="insurancepackage"
            item-text="pack"
            item-value="id"
            :rules="[(v) => !!v || 'กรุณาเลือกแพ็คเก็จ']"
            required
          ></v-select>
      </v-col>
      </v-row>
      </v-container>

       <v-container>
    <v-row justify="center">
       <v-col class="d-flex" cols="12" sm="10">
        <v-select
            label="พนักงานทำประกัน"
            solo
           v-model="healthinsurance.employeeId"
            :items="employee"
            item-text="empName"
            item-value="id"
            :rules="[(v) => !!v || 'กรุณาเลือกรายชื่อพนักทำประกัน']"
            required
          ></v-select>
      </v-col>
      </v-row>
      </v-container>

 <v-container>

    <v-row justify="center">
     <v-col class="d-flex" cols="12" sm="10">
        <v-select
            label="รายชื่อลูกค้า"
            solo
            v-model="healthinsurance.customerId"
            :items="customers"
            item-text="cusName"
            item-value="id"
            :rules="[(v) => !!v || 'กรุณาเลือกรายชื่อลูกค้า']"
            required
          ></v-select>
          
      </v-col> 
      </v-row>
      </v-container>


<v-container>
  <v-row justify="center">
      <div class="text-center">
     <v-btn @click="saveHealthinsurances" :class="{ red: !valid, green: valid}">save</v-btn>
     <v-btn style="margin-left: 15px;" @click="clear">clear</v-btn>
  </div>
  </v-row>
</v-container>
    </v-row>
     </v-form>
      </v-row>
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
name: "healthinsurance",
   data() {
    return {
      healthinsurance: {
        healthinsuranceId:"",
        insurancetypeId:"",
        paidtypeId:"",
        insurancepackageId: "",
        employeeId: "",
        customerId: "",
 },
      valid: false,
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

      getInsurancepackages(){
        http
        .get("/insurancepackage")
        .then(response =>{
          this.insurancepackage = response.data;
          console.log(response.data);
        })
        .catch(e =>{
          console.log(e);
        })
      },

      getInsurancetypes(){
        http
        .get("/insurancetype")
        .then(response =>{
          this.insurancetype = response.data;
          console.log(response.data);
        })
        .catch(e =>{
          console.log(e);
        })
      },

      getCustomers() {
      http
        .get("/customer")
        .then(response => {
          this.customers = response.data;
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
    },

clear() {
      this.$refs.form.reset();
    },

 saveHealthinsurances() {
          http
        .post(
          "/healthinsurance/"
            +
            this.healthinsurance.insurancetypeId +
            "/" +
            this.healthinsurance.paidtypeId +
            "/" +
            this.healthinsurance.insurancepackageId +
            "/" +
            this.healthinsurance.employeeId +
            "/"+
            this.healthinsurance.customerId,
          this.healthinsurance
          )
        .then(response => {
          console.log(response);
          if(response = true){
            alert('บันทึกข้อมูลเสร็จสิ้น')
            this.$router.push("/viewHealthInsurance");
          } 
          this.$refs.form.reset();   
        })
        .catch(e => {
          console.log(e);
           if(e = true){
            alert('กรุณาบันทึกข้อมูลให้ครบถ้วน')
          }
        });
      this.submitted = true;
    },
     refreshList() {
      this.getInsurancetypes();
      this.getInsurancepackages();
      this.getPaidtypes();
      this.getEmployees();
      this.getCustomers();
    },
     },
      mounted() {
      this.getInsurancetypes();
      this.getInsurancepackages();
      this.getPaidtypes();
      this.getEmployees();
      this.getCustomers();
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