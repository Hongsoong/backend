package com.cordingrecipe.member.entity;

import com.cordingrecipe.member.dto.OrderDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "order_table")
public class OrderEntity {
    @Id
    @GeneratedValue
    private Long orderId;

    @Column
    private Long id;

    @Column
    private String borrowStartTime;

    @Column
    private String borrowReturnTime;

    @Column
    private Long clothingId;

    public static OrderEntity toOrderEntity(OrderDTO orderDTO){
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setId(orderDTO.getId());
        orderEntity.setBorrowStartTime(orderDTO.getBorrowStartTime());
        orderEntity.setBorrowReturnTime(orderDTO.getBorrowReturnTime());
        orderEntity.setClothingId(orderDTO.getClothingId());
        return orderEntity;

    }
    public static OrderEntity toUpdateEntity(OrderDTO orderDTO){
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setOrderId(orderDTO.getOrderId());
        orderEntity.setId(orderDTO.getId());
        orderEntity.setBorrowStartTime(orderDTO.getBorrowStartTime());
        orderEntity.setBorrowReturnTime(orderDTO.getBorrowReturnTime());
        orderEntity.setClothingId(orderDTO.getClothingId());
        return orderEntity;

    }
}
