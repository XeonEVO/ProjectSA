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
  <v-container>
    <v-layout text-center wrap>
      <v-flex mb-4>
        <br />
        <h1 class="display-2 font-weight-bold mb-3"><font color="#ebecf7">HealthInsurance Information</font></h1>
      </v-flex>
    </v-layout>

    <v-row justify="center">
      <v-col cols="8">
        <v-data-table :headers="headers" :items="items" :items-per-page="5" class="elevation-1">
        </v-data-table>
      </v-col>
    </v-row>

  </v-container>
</v-app>
</template>

<script>

import http from "../http-common";
export default {
  name: "ViewHealthInsurance",
  data() {
    return {
      headers: [
        { text: "ประเภทประกัน", value: "insurancetype.intype" },
        { text: "รูปแบบการจ่าย", value: "paidtype.paid" },
        { text: "แพ็คเก็จประกัน", value: "insurancepackage.pack" },
        { text: "พนักงานที่ทำประกัน", value: "employee.empName" },
        { text: "ชื่อลูกค้า", value: "customerHealthInsurance.cusName" }
      
      ],
      items: []
    };
  }, 
  methods: {
    /* eslint-disable */

    getHealthInsurances() {
      http
        .get("/healthinsurance")
        .then(response => {
          this.items = response.data;
          console.log(this.items);
        })
        .catch(e => {
          console.log(e);
        });
    },
    refreshList() {
      this.getHealthInsurances();
    }
    /* eslint-disable no-console */
  },
  mounted() {
    this.getHealthInsurances();
  }
};
</script>