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
  <v-container>
    <v-layout text-center wrap>
      <v-flex mb-4>
        <br />        
        <h1 class="display-2 font-weight-bold mb-3 color=white "><font color=ebecf7>Hospital Data</font></h1>
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
  name: "ViewHospitalData",
  data() {
    return {
      headers: [
        { text: "ชื่อโรงพยาบาล", value: "hname" },
        { text: "คลินิก/โรงพยาบาล", value: "clinichospital.clinichospitalName" },
        { text: "ประเภทโรงพยาบาล", value: "hospitaltype.hospitaltypeName" },
        { text: "จังหวัด", value: "province.province" }
        
      ],
      items: []
    };
  },
  methods: {
    /* eslint-disable no-console */
    // ดึงข้อมูล Hospital ใส่ combobox
    getHospitals() {
      http
        .get("/hospital")
        .then(response => {
          this.items = response.data;
          console.log(this.items);
        })
        .catch(e => {
          console.log(e);
        });
    },
    refreshList() {
      this.getHospitals();
    }
    /* eslint-disable no-console */
  },
  mounted() {
    this.getHospitals();
  }
};
</script>