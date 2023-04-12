package com.example.demo.controller;


import java.time.LocalDateTime;

import java.util.HashMap;
import java.util.List;
import java.util.Map;



import com.example.demo.mapper.OrderProfileMapper;
import com.example.demo.model.OrderProfile;
import javax.annotation.PostConstruct;


import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class OrderProfileController {
    
    LocalDateTime now = LocalDateTime.now();


    private OrderProfileMapper mapper;

    private Map<String, OrderProfile>userMap;

    public OrderProfileController(OrderProfileMapper mapper) {
        this.mapper = mapper;
    }

    @PostConstruct
    public void init(){
        userMap = new HashMap<String, OrderProfile>();
        userMap.put("1",new OrderProfile(1,"",null, null ,""));
    }
    @GetMapping("/order/{order_id}")
    public OrderProfile getOrderProfile(@PathVariable("order_id") Integer order_id){
        return mapper.getOrderProfile(order_id);
    }
    @GetMapping("/order/all")
    public List<OrderProfile>getOrderProfileList() {
        return mapper.getOrderProfileList();
    }
    @PutMapping("/order/{order_id}")
    public void putOrderProfile(@PathVariable("order_id") Integer order_id, @RequestParam("user_id") String user_id, @RequestParam("borrow_start_time") String borrow_start_time ,@RequestParam("borrow_return_time") String borrow_return_time, @RequestParam("clothing_id") String clothing_id){
    mapper.putOrderProfile(null, user_id, now.toString(), null, clothing_id);

    }
    @PostMapping("/order/{order_id}")
    public void postClothingProfile(@PathVariable("order_id") Integer order_id, @RequestParam("user_id") String user_id, @RequestParam("borrow_start_time") String borrow_start_time,@RequestParam("borrow_return_time") String borrow_return_time, @RequestParam("clothing_id") String clothing_id){
    mapper.updateOrderProfile(order_id, user_id, borrow_start_time, borrow_return_time, clothing_id);
    }
    @DeleteMapping("/order/{order_id}")
    public void deleteOrderProfile(@PathVariable("order_id") Integer order_id){
        mapper.deleteOrderProfile(order_id);
    }
}

