package com.cordingrecipe.member.repository;

import com.cordingrecipe.member.entity.EventEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EventRepository extends JpaRepository<EventEntity, Long> {
    Optional<EventEntity> findByEventNum(Long eventNum);
}
