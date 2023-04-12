package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.demo.mapper.UserProfileMapper;
import com.example.demo.model.UserProfile;
import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;




@RestController
public class UserProfileController {

    private UserProfileMapper mapper;

    private Map<String, UserProfile>userMap;

    public UserProfileController(UserProfileMapper mapper) {
        this.mapper = mapper;
    }

    @PostConstruct
    public void init(){
        userMap = new HashMap<String, UserProfile>();
        userMap.put("1",new UserProfile("1","1","hongsoongi", "01048782437","men","1", "seoul","1","1995-11-01"));
        userMap.put("2",new UserProfile("2","1","hongsoongi1", "01048782438","men","95", "seoul1","1","1998-12-11"));
        userMap.put("3",new UserProfile("3","1","hongsoongi2", "01048782439","men","100", "seoul2","1","1992-12-12"));
    }
    @GetMapping("/user/{user_id}")
    public UserProfile getUserProfile(@PathVariable("user_id") String user_id){
        return mapper.getUserProfile(user_id);
    }
    @GetMapping("/user/all")
    public List<UserProfile>getUserProfileList() {
        return mapper.getUserProfileList();
    }
    @PutMapping("/user/{user_id}")
    public void putUserProfile(@PathVariable("user_id") String user_id, @RequestParam("user_qwd") String user_qwd,@RequestParam("user_name") String user_name, @RequestParam("user_phone_number") String user_phone_number,@RequestParam("user_sex") String user_sex, @RequestParam("user_size") String user_size, @RequestParam("user_addr") String user_addr,@RequestParam("user_authority") String user_authority,@RequestParam("user_birth") String user_birth){
        mapper.putUserProfile(user_id, user_name, user_qwd, user_phone_number, user_sex, user_size, user_addr, user_authority, user_birth);
    }
    @PostMapping("/user/{user_id}")
    public void postUserProfile(@PathVariable("user_id") String user_id, @RequestParam("user_qwd") String user_qwd,@RequestParam("user_name") String user_name, @RequestParam("user_phone_number") String user_phone_number,@RequestParam("user_sex") String user_sex, @RequestParam("user_size") String user_size, @RequestParam("user_addr") String user_addr,@RequestParam("user_authority") String user_authority,@RequestParam("user_birth") String user_birth){
    mapper.updateUserProfile(user_id, user_name, user_qwd, user_phone_number, user_sex, user_size, user_addr, user_authority, user_birth);
    }
    @DeleteMapping("/user/{user_id}")
    public void deleteUserProfile(@PathVariable("user_id") String user_id){
        mapper.deleteUserProfile(user_id);
    }
}
