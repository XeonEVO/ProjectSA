<template>
  <v-app id="inspire" :style="{ backgroundImage: 'url(' + require('@/assets/a.jpeg') + ')' }"> 
  <v-app-bar app color="blue darken-2">
      <v-toolbar-title class="headline text-uppercase">
        <span>Health</span>
        <span class="font-weight-light"> Insurance</span>
      </v-toolbar-title>
      <v-spacer></v-spacer>
      <v-btn color="grey lighten-5">
        <router-link class="mr-1" to="/customer">New Customer</router-link>
      </v-btn>&nbsp;
      <v-btn color="grey lighten-5">
        <router-link class="mr-1" to="/viewCustomer">Customer Informartion</router-link>
      </v-btn>&nbsp;
      <v-btn color="grey lighten-5">
        <router-link class="mr-1" to="/">Logout</router-link>
      </v-btn>&nbsp;
    </v-app-bar>
  <v-container>
    <v-layout text-center wrap>
      <v-flex mb-4>
        <br />
        <h1 class="display-1 font-weight-bold mb-2">Customer Information</h1>
      </v-flex>
    </v-layout>

    <v-row justify="center">
      <v-col cols="10">
        <v-data-table :headers="headers" :items="items" :items-per-page="15" class="elevation-6">
        </v-data-table>
      </v-col>
    </v-row>
  </v-container>
  </v-app>
</template>

<script>
import http from "../http-common";

export default {
  name: "ViewCustomerData",
  data() {
    return {
      headers: [
        { text: "ชื่อลูกค้า", value: "cusName" },
        { text: "หมายเลขประจำตัวประชาชน", value: "identification" },
        { text: "เพศ", value: "customerSex.sex" },
        { text: "อายุ", value: "age" },
        { text: "วันเกิด", value: "birth" },
        { text: "ที่อยู่", value: "address" },
        { text: "ตำบล", value: "subDistrict" },
        { text: "อำเภอ", value: "district" },
        { text: "จังหวัด", value: "province.province" },
        { text: "เบอร์โทรศัพท์", value: "tel" },
        { text: "ผู้บันทึก", value: "createdBy.empName" }
      ],
      items: []
    };
  },
  methods: {
    /* eslint-disable no-console */
    // ดึงข้อมูล Customer ใส่ combobox
    getCustomers() {
      http
        .get("/customer")
        .then(response => {
          this.items = response.data;
          console.log(this.items);
        })
        .catch(e => {
          console.log(e);
        });
    },
    refreshList() {
      this.getCustomers();
    }
    /* eslint-disable no-console */
  },
  mounted() {
    this.getCustomers();
  }
};
</script>
