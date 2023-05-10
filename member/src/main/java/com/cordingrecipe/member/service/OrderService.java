package com.cordingrecipe.member.service;

import com.cordingrecipe.member.dto.OrderDTO;
import com.cordingrecipe.member.entity.OrderEntity;
import com.cordingrecipe.member.repository.OrderRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;

    public void save(OrderDTO orderDTO) {
        OrderEntity orderEntity = OrderEntity.toOrderEntity(orderDTO);
        orderRepository.save(orderEntity);
    }
    public List<OrderDTO> findAll(){
        List<OrderEntity> orderEntityList = orderRepository.findAll();
        List<OrderDTO> orderDTOList =new ArrayList<>();
        for(OrderEntity orderEntity: orderEntityList) {
            orderDTOList.add(OrderDTO.toOrderDTO(orderEntity));
        }
        return orderDTOList;
    }
    public OrderDTO findByOrderId(Long orderId){
        Optional<OrderEntity> optionalOrderEntity = orderRepository.findByOrderId(orderId);
        if(optionalOrderEntity.isPresent()){
            return OrderDTO.toOrderDTO(optionalOrderEntity.get());
        }
        else {
            return null;
        }
    }
    public OrderDTO update(OrderDTO orderDTO) {
        OrderEntity orderEntity = OrderEntity.toUpdateEntity(orderDTO);
        orderRepository.save(orderEntity);
        return findByOrderId(orderDTO.getOrderId());
    }
    public void delete(Long orderId){
        orderRepository.deleteById(orderId);
    }
}
