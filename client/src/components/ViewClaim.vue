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
    <br />
    <br /><br /><br />
    <h1 class="text-center">รายละเอียดการเคลม</h1>
    <br /><br /><br />
    <pre></pre>
    <pre></pre>
    <pre></pre>
    <pre></pre>
    <pre></pre>
    
    <v-row justify="center">
      <v-col cols="8">
        <v-data-table :headers="headers" :items="items" :items-per-page="5" class="elevation-1">
        </v-data-table>
      </v-col>
    </v-row>
</v-app>
</template>

<script>
import http from "../http-common";
export default {
  name: "ViewClaim",
  data() {
    return {
      headers: [
        {
          text: "ชื่อผู้ทำประกัน",
          align: "left",
          sortable: false,
          value: "createdBy.cusName"
        },
        {text: "หมายเลขบัตรประชาชน",value: "createdBy.identification"},
        { text: "โรงพยาบาล", value: "hospital.hname" },
        { text: "เเพ็คเกจ", value: "insurancepackage.pack" },
        { text: "จ่ายผ่าน", value: "paychecks.payto" },
        { text: "รักษาโดยการ", value: "cureby.curemeth" },
        {text: "ตรวจโดยวิธีการ", value: "treatmethod.treatby"}
      ],
      items: [],
      drawer: false
    };
    
  },
  methods: {
    /* eslint-disable no-console */
    getClaims() {
      http
        .get("/Claim")
        .then(response => {
          this.$forceUpdate();
          this.items = response.data;
          console.log(this.items);
        })
        .catch(e => {
          console.log(e);
        });
    },
    refreshList() {
      this.getClaims();
    }
  },
  mounted() {
    this.getClaims();
  }
};
</script>