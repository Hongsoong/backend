package com.cordingrecipe.member.repository;

import com.cordingrecipe.member.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
    Optional<OrderEntity> findByOrderId(Long orderId);
}
