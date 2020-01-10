<template>
    <v-app id="inspire" :style="{ backgroundImage: 'url(' + require('@/assets/menu.jpg') + ')' }">
         <v-app-bar app color="blue darken-2">
      <v-toolbar-title class="headline text-uppercase">
        <span>Health</span>
        <span class="font-weight-light"> Insurance</span>
      </v-toolbar-title>
      <v-spacer></v-spacer>
      <v-btn color="grey lighten-5">
        <router-link class="mr-1" to="/">Logout</router-link>
      </v-btn>&nbsp;
    </v-app-bar>
            
         <div class='rgn'>
            <br/>
            <div class="text-center">
                <v-avatar>
                <img src="https://www.clipartmax.com/png/middle/110-1105887_north-arrow-compass-rose-clip-art-north-arrow-no-background.png" alt="avatar">
                </v-avatar>
                <br/>
            </div>
            <h1 align='center' class="display-1 font-weight-bold mb-2">Navigator</h1>
            <br>
                    <v-layout  row nowrap class="justify-center">
                
                <v-btn x-large class="ma-2" solo color="orange">
                    <router-link class="mr-1" to="/claim">Claim</router-link>
                </v-btn>&nbsp;
            </v-layout>
            <br>
            <v-layout  row nowrap class="justify-center">
                <v-btn x-large class="ma-2" solo color="green ">
                    <router-link class="mr-1" to="/recordQuestion">Record Question</router-link>
                </v-btn>&nbsp;
            </v-layout>
         </div>
    </v-app>
</template>

<style>
.btncenter{
    
    display: block;
    margin-left: auto;
    margin-right: auto;
}
.rgn{
    display: block;
    margin-left: auto;
    margin-right: auto;
    height: 1000px;
    width: 800px; 
    background-color: #ebecf7;
    opacity: 1;
    -moz-box-shadow:inset 0 0 10px #000000;
   -webkit-box-shadow:inset 0 0 10px #000000;
   box-shadow:inset 0 0 10px #000000;
}
</style>