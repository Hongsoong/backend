package com.example.demo.model;

public class UserProfile {
    private String user_id;
    private String user_qwd;
    private String user_name;
    private String user_phone_number;
    private String user_sex;
    private String user_size;
    private String user_addr;
    private String user_authority;
    private String user_birth;

    public UserProfile(String user_id,String user_qwd, String user_name, String user_phone_number,String user_sex,String user_size, String user_addr,String user_authority,String user_birth){
        super();
        this.user_id=user_id;
        this.user_qwd=user_qwd;
        this.user_name=user_name;
        this.user_phone_number=user_phone_number;
        this.user_sex=user_sex;
        this.user_size=user_size;
        this.user_addr=user_addr;
        this.user_authority=user_authority;
        this.user_birth=user_birth;
    }
    public String getID(){
        return user_id;
    }
    public void setID(String user_id){
        this.user_id=user_id;
    }
    public String getQWD(){
        return user_qwd;
    }
    public void setQWD(String user_qwd){
        this.user_qwd=user_qwd;
    }
    public String getName(){
        return user_name;
    }
    public void setName(String user_name){
        this.user_name=user_name;
    }
    public String getPhone(){
        return user_phone_number;
    }
    public void setPhone(String user_phone_number){
        this.user_phone_number=user_phone_number;
    }
    public String getSex(){
        return user_sex;
    }
    public void setSex(String user_sex){
        this.user_sex=user_sex;
    }
    public String getSize(){
        return user_size;
    }
    public void setSize(String user_size){
        this.user_size=user_size;
    }
    public String getAddr(){
        return user_addr;
    }
    public void setAddr(String user_addr){
        this.user_addr=user_addr;
    }
    public String getAuthority(){
        return user_authority;
    }
    public void setAuthority(String user_authority){
        this.user_authority=user_authority;
    }
    public String getBirth(){
        return user_birth;
    }
    public void setBirth(String user_birth){
        this.user_birth=user_birth;
    }

}
