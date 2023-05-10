package com.cordingrecipe.member.dto;

import  com.cordingrecipe.member.entity.OrderEntity;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class OrderDTO {
    private Long orderId;
    private Long id;
    private String borrowStartTime;
    private String borrowReturnTime;
    private Long clothingId;

    public static OrderDTO toOrderDTO(OrderEntity orderEntity){
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setOrderId(orderEntity.getOrderId());
        orderDTO.setId(orderEntity.getId());
        orderDTO.setBorrowStartTime(orderEntity.getBorrowStartTime());
        orderDTO.setBorrowReturnTime(orderEntity.getBorrowReturnTime());
        orderDTO.setClothingId(orderEntity.getClothingId());
        return orderDTO;
    }
}
