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
<div class='bgn'>
  <v-container>

    <v-layout text-center wrap>
      <v-flex mb-4>
        <br />
        <div class="text-center">
    <v-avatar>
        <img src="http://icons.iconarchive.com/icons/graphicloads/100-flat-2/256/email-icon.png" alt="avatar">
    </v-avatar>
  </div>
        <h1 class="display-2 font-weight-bold mb-3">Contact For Information</h1>
      </v-flex>
    </v-layout>

    <v-row justify="center">
      <v-col cols="15">
        <v-form v-model="valid" ref="form">
           <v-row justify="center"> 
            <v-col cols="8">
              <v-text-field
                solo
                label="เลขบัตรประชาชน"
                v-model="recordquestion.customerIdent"
                :rules="[(v) => !!v || 'Item is required']"
                required
              ></v-text-field>
              <p v-if="customerCheck != ''">ชื่อ : {{customerName}}<br>
  
              </p>
            </v-col>
            <v-col cols="2">
              <div class="my-2">
                <v-btn @click="findCustomer" depressed large color="primary">ค้นหา</v-btn>
              </div>
            </v-col>
           </v-row> 
           <v-row justify="center">
              <v-col cols="10">
                <v-select
                  label="เลือกช่องทางการติดต่อกลับ"
                  solo
                  v-model="recordquestion.contactId"
                  :items="contacts"
                  item-text="contactname"
                  item-value="id"
                  :rules="[(v) => !!v || 'Item is required']"
                  required
                ></v-select>
              </v-col>
           </v-row>
           
             <v-row justify="center">
              <v-col cols="10">
                <v-select
                  label="เลือกสาขาที่ต้องการติดต่อ"
                  solo
                  v-model="recordquestion.branchId"
                  :items="branch"
                  item-text="name_br"
                  item-value="id"
                  :rules="[(v) => !!v || 'Item is required']"
                  required
                ></v-select>
              </v-col>
             </v-row> 

            <v-row justify="center">
              <v-col cols="10">
                <v-select
                  label="เลือกเรื่องที่ต้องการติดต่อ"
                  solo
                  v-model="recordquestion.headingId"
                  :items="headings"
                  item-text="headingname"
                  item-value="id"
                  :rules="[(v) => !!v || 'Item is required']"
                  required
                ></v-select>
              </v-col>
            </v-row> 

            <v-row justify="center">
              <v-col cols="20" md="10">
                <v-textarea
                  solo
                  v-model="recordquestion.detail"
                  name="input-7-4"
                  label="ระบุรายละเอียดที่ต้องการติดต่อ"
                  value=""
                ></v-textarea>
                <v-btn @click="saveRecQuestion" :class="{ red: !valid, primary: valid }">submit</v-btn>
              </v-col>
            </v-row>
            <br />
        </v-form>
      </v-col>
    </v-row>
  </v-container>
  </div>
    <br>
    <br>
    <br>
    <br>
</v-app>
</template>

<script>
import http from "../http-common";
// eslint-disable-next-line no-unused-vars
import DatePicker from 'vuetify'
export default {
  name: "recordquestion",
  components: {
    // eslint-disable-next-line vue/no-unused-components
    DatePicker
  },
  data() {
    return {
      recordquestion: {
        customerIdent: "",
        contactId: "",
        branchId: "",
        headingId: "",
        detail: ""
      },
      valid: false,
      customerCheck: false,
      customerName: ""
    };
  },
  methods: {
    /* eslint-disable no-console */
  /* eslint-disable */
    // ดึงข้อมูล Contact ใส่ combobox
    getContact() {
      http
        .get("/contact")
        .then(response => {
          this.contacts = response.data;
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
    },
    // ดึงข้อมูล Branch ใส่ combobox
    getBranch() {
      http
        .get("/branch")
        .then(response => {
          this.$forceUpdate();
          this.branch = response.data;
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
    },
    // ดึงข้อมูล Heading ใส่ combobox
    getHeading() {
      http
        .get("/heading")
        .then(response => {
          this.$forceUpdate();
          this.headings = response.data;
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
    },
    // function ค้นหาลูกค้าด้วย ID
    findCustomer() {
      http
        .get("/customer/" + this.recordquestion.customerIdent)
        .then(response => {
          this.$forceUpdate();
          console.log(response);
          if (response.data != null) {
            this.customerName = response.data.cusName;
            this.customerCheck = response.status;
          } else {
            this.clear()
          }          
        })
        .catch(e => {
          console.log(e);
        });
      this.submitted = true;
    },

    saveRecQuestion() {
   
      http
        .post(
          "/recordquestion/" +
            this.recordquestion.customerIdent +
            "/" +
            this.recordquestion.contactId +
            "/" +
            this.recordquestion.branchId +
            "/" +
            this.recordquestion.headingId +
            "/"+
            this.recordquestion.detail,
          this.recordquestion
        )
        .then(response => {
          console.log(response);
          if(response = true){
            this.$router.push("/viewRecordQuestion");
            alert('บันทึกคำถามสำเร็จ')
            
          }
        })
        .catch(e => {
          if(e = true){
            alert('บันทึกคำถามไม่สำเร็จ')
          }
          console.log(e);
        });
      this.submitted = true;
    
   
    },
    refreshList() {
      this.getContact();
      this.getBranch();
      this.getHeading();
    }

  },
  mounted() {
      this.getContact();
      this.getBranch();
      this.getHeading();
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