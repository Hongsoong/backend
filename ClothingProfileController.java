package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.demo.mapper.ClothingProfileMapper;
import com.example.demo.model.ClothingProfile;
import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;




@RestController
public class ClothingProfileController {

    private ClothingProfileMapper mapper;

    private Map<String, ClothingProfile>userMap;

    public ClothingProfileController(ClothingProfileMapper mapper) {
        this.mapper = mapper;
    }

    @PostConstruct
    public void init(){
        userMap = new HashMap<String, ClothingProfile>();
        userMap.put("1",new ClothingProfile("","","", "",""));
        
    }
    @GetMapping("/clothing/{clothing_id}")
    public ClothingProfile getClothingProfile(@PathVariable("clothing_id") String clothing_id){
        return mapper.getClothingProfile(clothing_id);
    }
    @GetMapping("/clothing/all")
    public List<ClothingProfile>getClothingProfileList() {
        return mapper.getClothingProfileList();
    }
    @PutMapping("/clothing/{clothing_id}")
    public void putClothingProfile(@PathVariable("clothing_id") String clothing_id, @RequestParam("clothing_name") String clothing_name, @RequestParam("clothing_size") String clothing_size,@RequestParam("clothing_condition") String clothing_condition, @RequestParam("user_id") String user_id  ){
        mapper.putClothingProfile(clothing_id, clothing_name, clothing_size, clothing_condition, user_id);
    }
    @PostMapping("/clothing/{clothing_id}")
    public void postClothingProfile(@PathVariable("clothing_id") String clothing_id, @RequestParam("clothing_name") String clothing_name,@RequestParam("clothing_size") String clothing_size, @RequestParam("clothing_condition") String clothing_condition,@RequestParam("user_id") String user_id ){
    mapper.updateClothingProfile(clothing_id, clothing_name, clothing_size, clothing_condition, user_id);
    }
    @DeleteMapping("/clothing/{clothing_id}")
    public void deleteClothingProfile(@PathVariable("clothing_id") String clothing_id){
        mapper.deleteClothingProfile(clothing_id);
    }
}
