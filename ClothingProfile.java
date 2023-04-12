package com.example.demo.model;

public class ClothingProfile {
    private String clothing_id;
    private String clothing_name;
    private String clothing_size;
    private String clothing_condition;
    private String user_id;


    public ClothingProfile(String clothing_id, String clothing_name, String clothing_size, String clothing_condition, String user_id){
        super();
        this.clothing_id = clothing_id;
        this.clothing_name = clothing_name;
        this.clothing_size = clothing_size;
        this.clothing_condition = clothing_condition;
        this.user_id = user_id;


    }


    public String getClothing_id() {
        return clothing_id;
    }


    public void setClothing_id(String clothing_id) {
        this.clothing_id = clothing_id;
    }


    public String getClothing_name() {
        return clothing_name;
    }


    public void setClothing_name(String clothing_name) {
        this.clothing_name = clothing_name;
    }


    public String getClothing_size() {
        return clothing_size;
    }


    public void setClothing_size(String clothing_size) {
        this.clothing_size = clothing_size;
    }


    public String getClothing_condition() {
        return clothing_condition;
    }


    public void setClothing_condition(String clothing_condition) {
        this.clothing_condition = clothing_condition;
    }


    public String getUser_id() {
        return user_id;
    }


    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }
}
    
