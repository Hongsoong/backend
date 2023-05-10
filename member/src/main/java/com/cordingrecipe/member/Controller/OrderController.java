package com.cordingrecipe.member.Controller;


import com.cordingrecipe.member.dto.OrderDTO;

import com.cordingrecipe.member.service.OrderService;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;


    @GetMapping("/order/save")
    public String saveForm(){ return "ordersave";}
    //대여서비스 구현 order 테이블 대여시간 넣기
    @PostMapping("/order/save")
    public String save(@ModelAttribute OrderDTO orderDTO){
        System.out.println("OrderController.save");
        System.out.println("orderDTO=" +orderDTO);
        orderService.save(orderDTO);
        return "redirect:/clothing/user";
    }


    @GetMapping("/order/")
    public String findAll(Model model){
        List<OrderDTO> orderDTOList = orderService.findAll();
        model.addAttribute("orderList",orderDTOList);
        return "orderlist";
    }
    //반납 정보 입력 하기위해 list 출력.
    @GetMapping("/order/return")
    public String findAllReturn(Model model){
        List<OrderDTO> orderDTOList = orderService.findAll();
        model.addAttribute("orderList",orderDTOList);
        return "orderlistreturn";
    }

    @GetMapping("/order/{orderId}")
    public String findById(@PathVariable Long orderId,Model model){
        OrderDTO orderDTO = orderService.findByOrderId(orderId);
        model.addAttribute("order",orderDTO);
        return "orderdetail";
    }

    @GetMapping("/order/update/{orderId}")
    public String updateForm(@PathVariable Long orderId, Model model) {
        OrderDTO orderDTO = orderService.findByOrderId(orderId);
        model.addAttribute("orderUpdate", orderDTO);
        return "orderupdate";
    }
    @PostMapping("/order/update")
    public String update(@ModelAttribute OrderDTO orderDTO,Model model){
        OrderDTO order = orderService.update(orderDTO);
        model.addAttribute("order",order);
        return "orderdetail";

    }
    //반납정보 ReturnTime 현재 시간으로 입력하기.
    @GetMapping("/order/update/return/{orderId}")
    public String updateFormReturn(@PathVariable Long orderId, Model model, HttpSession session) {
        OrderDTO orderDTO = orderService.findByOrderId(orderId);
        model.addAttribute("orderUpdateReturn", orderDTO);

        //로그인 정보 memberDTO session의 id 값이 orderDTO.getId() 값이랑 일치하면 반납가능 아니면 불가능 문구 출력

        //    if(orderDTO.getId() == ){
            return "orderupdatereturn";
      // }
    //    else {
   //         return "null";
   //     }
    }
    @PostMapping("/order/update/return")
    public String updateReturn(@ModelAttribute OrderDTO orderDTO,Model model){
        OrderDTO order = orderService.update(orderDTO);
        model.addAttribute("orderReturn",order);
        return "redirect:/member/customer";
    }

    @GetMapping("/order/delete/{orderId}")
    public String delete(@PathVariable Long orderId) {
        orderService.delete(orderId);
        return "redirect:/order/";
    }

}
