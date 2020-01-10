<template>
<v-app id="inspire" :style="{ backgroundImage: 'url(' + require('@/assets/d.jpg') + ')' }">
<v-app-bar app color="blue darken-2">
      <v-toolbar-title class="headline text-uppercase">
        <span>Health</span>
        <span class="font-weight-light"> Insurance</span>
      </v-toolbar-title>
      <v-spacer></v-spacer>
     <v-btn color="grey lighten-5">
        <router-link class="mr-1" to="/recordQuestion">New Record Question</router-link>
      </v-btn>&nbsp;
      <v-btn color="grey lighten-5">
        <router-link class="mr-1" to="/viewRecordQuestion">Record Question Information</router-link>
      </v-btn>&nbsp;
      <v-btn color="grey lighten-5">
        <router-link class="mr-1" to="/menu">Home</router-link>
      </v-btn>&nbsp;
      <v-btn color="grey lighten-5">
        <router-link class="mr-1" to="/">Logout</router-link>
      </v-btn>&nbsp;
    </v-app-bar>
  <v-container>
    <v-layout text-center wrap>
      <v-flex mb-4>
        <br />
        <h1 class="display-2 font-weight-bold mb-3 color=white "><font color=ebecf7>ข้อมูลลูกค้าที่ติดต่อสอบถาม</font></h1>
      </v-flex>
    </v-layout>

    <v-row justify="center">
      <v-col cols="8">
        <v-data-table :headers="headers" :items="items" :items-per-page="10" class="elevation-1">
        </v-data-table>
      </v-col>
    </v-row>

  </v-container>
</v-app>
</template>

<script>
import http from "../http-common";
export default {
  name: "ViewRecordData",
  data() {
    return {
      headers: [
        { text: "ชื่อ", value: "createdBy.cusName" },
        { text: "ติดต่อกลับ", value: "contact.contactname" },
        { text: "สาขา", value: "branch.name_br" },
        { text: "เรื่อง", value: "heading.headingname" },
        { text: "รายละเอียด", value: "detail" }
      ],
      items: []
    };
  },
  methods: {
    /* eslint-disable no-console */
    // ดึงข้อมูล Customer ใส่ combobox
    getRecordquestions() {
      http
        .get("/recordquestion")
        .then(response => {
          this.items = response.data;
          console.log(this.items);
        })
        .catch(e => {
          console.log(e);
        });
    },
    refreshList() {
      this.getRecordquestions();
    }
    /* eslint-disable no-console */
  },
  mounted() {
    this.getRecordquestions();
  }
};
</script>
