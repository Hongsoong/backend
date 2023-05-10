package com.cordingrecipe.member.repository;

import com.cordingrecipe.member.entity.ClothingEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClothingRepository extends JpaRepository<ClothingEntity,Long> {
    Optional<ClothingEntity> findByClothingId(Long clothingId);

}
