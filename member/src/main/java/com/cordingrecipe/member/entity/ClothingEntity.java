package com.cordingrecipe.member.entity;

import com.cordingrecipe.member.dto.ClothingDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name= "clothing_table")

public class ClothingEntity {

    @Id
    @GeneratedValue
    private Long clothingId;

    @Column
    private  String clothingName;

    @Column
    private String clothingSize;

    @Column
    private String clothingCondition;

    @Column
    private Long id;

    public static ClothingEntity toClothingEntity(ClothingDTO clothingDTO){
        ClothingEntity clothingEntity = new ClothingEntity();

        clothingEntity.setClothingName(clothingDTO.getClothingName());
        clothingEntity.setClothingSize(clothingDTO.getClothingSize());
        clothingEntity.setClothingCondition(clothingDTO.getClothingCondition());
        clothingEntity.setId(clothingDTO.getId());

         return clothingEntity;
    }
    public static ClothingEntity toUpdateEntity(ClothingDTO clothingDTO){
        ClothingEntity clothingEntity = new ClothingEntity();
        clothingEntity.setClothingId(clothingDTO.getClothingId());
        clothingEntity.setClothingName(clothingDTO.getClothingName());
        clothingEntity.setClothingSize(clothingDTO.getClothingSize());
        clothingEntity.setClothingCondition(clothingDTO.getClothingCondition());
        clothingEntity.setId(clothingDTO.getId());
        return clothingEntity;
    }

}
