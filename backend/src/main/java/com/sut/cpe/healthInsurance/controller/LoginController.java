package com.sut.cpe.healthInsurance.controller;

import com.sut.cpe.healthInsurance.repository.ProfileloginRepository;
import com.sut.cpe.healthInsurance.entity.Profilelogin;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.validation.Validator;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.CrossOrigin;


@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class LoginController{
String username;
    @Autowired
    ProfileloginRepository profileloginRepository;

    LoginController(ProfileloginRepository profileloginRepository) {
        this.profileloginRepository = profileloginRepository;
    }
    
    @PostMapping("/validate/{password}/{username}")
    public HashMap<String, String> login( 
    @PathVariable String username,
    @PathVariable String password){
    HashMap<String,String> map = new HashMap<>();
    Profilelogin profilelogin = profileloginRepository.findByUsername(username);
    try{
        if(profilelogin.getUsername().equals("hospital")){
            if(profilelogin.getPassword().equals(password)){
            map.put("p1","true");
            }
            else{
                map.put("p1","false");
            }
        }
        else if(profilelogin.getUsername().equals("insurance")) {
            if(profilelogin.getPassword().equals(password)) {
                map.put("p2","true");
                }
            else {
                map.put("p2","false");
            }
        }
        else if(profilelogin.getUsername().equals("receipt")) {
            if(profilelogin.getPassword().equals(password)) {
                map.put("p3","true");
                }
            else {
                map.put("p3","false");
            }
        }
        else if(profilelogin.getUsername().equals("store")) {
            if(profilelogin.getPassword().equals(password)) {
                map.put("p4","true");
                }
            else {
                map.put("p4","false");
            }
        }
        else if(profilelogin.getUsername().equals("customer")) {
            if(profilelogin.getPassword().equals(password)) {
                map.put("p5","true");
                }
            else {
                map.put("p5","false");
            }
        }
        else
            map.put("massage","false");
        
    }
    catch (Exception e){
        map.put("message", "test");
    }
        return map;
    }

    @GetMapping("/getuser")
    public Profilelogin getUser(){
        return profileloginRepository.findByUsername(username);
    }
}