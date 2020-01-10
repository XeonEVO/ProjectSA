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
  
    <v-container nowrap  class="justify-center">
      <v-form v-model="valid" ref="form">
      <v-layout  row nowrap class="justify-center">

  <v-container>
    <v-layout text-center wrap>
      <v-flex mb-4>
        <br />
        <h1 class="display-2 font-weight-bold mb-3">Receipt Information</h1>
      </v-flex>
    </v-layout>

    <v-row justify="center">
      <v-col cols="8">
        <v-data-table :headers="headers" :items="items" :items-per-page="5" class="elevation-1">
        </v-data-table>
      </v-col>
    </v-row>

  </v-container>
           
      </v-layout>
     </v-form>
           
           
    </v-container>
  </v-app>
</template>

<script>
import http from "../http-common";

export default {
  name: "ViewReceiptData",
  data() {
    return {
      headers: [
        { text: "Date", value: "receiptDate" },
        { text: "Customer", value: "customer.cusName" },
        { text: "Employee", value: "employee.empName" },
        { text: "Branch", value: "branch.name_br" },
        { text: "Price", value: "paidtype.price" }
        
      
      ],
      items: []
    };
  },
  methods: {
    /* eslint-disable no-console */
    // ดึงข้อมูล receipt ใส่ combobox
    getReceipts() {
      http
        .get("/receipt")
        .then(response => {
          this.items = response.data;
          console.log(this.items);
        })
        .catch(e => {
          console.log(e);
        });
    },
    refreshList() {
      this.getReceipts();
    }
    /* eslint-disable no-console */
  },
  mounted() {
    this.getReceipts();
  }
};
</script>
