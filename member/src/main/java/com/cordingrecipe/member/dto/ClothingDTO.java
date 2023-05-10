package com.cordingrecipe.member.dto;

import com.cordingrecipe.member.entity.ClothingEntity;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ClothingDTO {
    private Long clothingId;
    private String clothingName;
    private String clothingSize;
    private String clothingCondition;
    private Long id;

    public static ClothingDTO toClothingDTO(ClothingEntity clothingEntity){
        ClothingDTO clothingDTO = new ClothingDTO();
        clothingDTO.setClothingId(clothingEntity.getClothingId());
        clothingDTO.setClothingName(clothingEntity.getClothingName());
        clothingDTO.setClothingSize(clothingEntity.getClothingSize());
        clothingDTO.setClothingCondition(clothingEntity.getClothingCondition());
        clothingDTO.setId(clothingEntity.getId());

        return clothingDTO;
    }
}
