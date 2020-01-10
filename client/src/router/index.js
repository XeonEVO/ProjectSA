import Vue from 'vue'
import Router from 'vue-router';
import ViewCustomer from '../components/ViewCustomerData.vue';
import Customer from '../components/Customer.vue';
import ViewHospitalData from '../components/ViewHospitalData.vue';
import Hospital from '../components/Hospital.vue';
import ViewReceipt from '../components/ViewReceiptData';
import Receipt from '../components/Receipt';
import ViewRecord from '../components/ViewRecordData.vue';
import Record from '../components/Record.vue';
import Claim from '@/components/claim.vue'
import ViewClaim from '../components/ViewClaim.vue';
import ViewHealthInsurance from '../components/ViewHealthInsurance.vue';
import HealthInsurance from '../components/HealthInsurance.vue';
import Loginform from '../components/Loginform.vue';
import Registerform from '../components/Registerform.vue';
import Menu from '../components/Menu.vue';

Vue.use(Router);

export default new Router({
    mode: 'history',
    base: process.env.BASE_URL,
    routes: [{
            path: '/customer',
            name: "home",
            component: Customer
        },
        {
            path: '/viewCustomer',
            name: "view",
            component: ViewCustomer
        },
        {
            path: '/hospital',
            name: "home",
            component: Hospital
        },
        {
            path: '/viewHospital',
            name: "view",
            component: ViewHospitalData
        },
        {
            path: '/receipt',
            component: Receipt
        },
        {
            path: '/viewReceipt',
            component: ViewReceipt
        },
        {
            path: '/recordQuestion',
            name: "home",
            component: Record
        },
        {
            path: '/viewRecordquestion',
            name: "view",
            component: ViewRecord
        },
        {
            path: '/claim',
            name: 'claim',
            component: Claim
          },
          {
            path: '/viewClaim',
            name: "view",
            component: ViewClaim
        },
        {
            path: '/healthInsurance',
            name: "home",
            component: HealthInsurance
        },
        {
            path: '/viewHealthInsurance',
            name: "view",
            component: ViewHealthInsurance
        },
        {
            path: '/',
            name: "login",
            component: Loginform
        },
        {
            path: '/register',
            name: "register",
            component: Registerform
        },
        {
            path: '/menu',
            name: "menu",
            component: Menu
        },

    ]
});