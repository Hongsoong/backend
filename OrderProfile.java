package com.example.demo.model;



public class OrderProfile {
    private Integer order_id;
    private String user_id;
    private String borrow_start_time;
    private String borrow_return_time;
    private String clothing_id;

    public OrderProfile(Integer order_id, String user_id,String borrow_start_time,String borrow_return_time, String clothing_id){
        super();
        this.clothing_id=clothing_id;
        this.user_id=user_id;
        this.borrow_return_time=borrow_return_time;
        this.borrow_start_time=borrow_start_time;
        this.order_id=order_id;
    }

    public Integer getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Integer order_id) {
        this.order_id = order_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getBorrow_start_time() {
        return borrow_start_time;
    }

    public void setBorrow_start_time(String borrow_start_time) {
        this.borrow_start_time = borrow_start_time;
    }

    public String getBorrow_return_time() {
        return borrow_return_time;
    }

    public void setBorrow_return_time(String borrow_return_time) {
        this.borrow_return_time = borrow_return_time;
    }

    public String getClothing_id() {
        return clothing_id;
    }

    public void setClothing_id(String clothing_id) {
        this.clothing_id = clothing_id;
    }

   
    
}
