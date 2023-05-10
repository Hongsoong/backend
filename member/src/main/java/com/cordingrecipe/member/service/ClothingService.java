package com.cordingrecipe.member.service;

import com.cordingrecipe.member.dto.ClothingDTO;

import com.cordingrecipe.member.entity.ClothingEntity;
import com.cordingrecipe.member.repository.ClothingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClothingService {
    private final ClothingRepository clothingRepository;

    public void save(ClothingDTO clothingDTO) {
        ClothingEntity clothingEntity = ClothingEntity.toClothingEntity(clothingDTO);
        clothingRepository.save(clothingEntity);

    }

    public List<ClothingDTO> findAll(){
        List<ClothingEntity> clothingEntityList = clothingRepository.findAll();
        List<ClothingDTO> clothingDTOList = new ArrayList<>();
        for (ClothingEntity clothingEntity: clothingEntityList){
            clothingDTOList.add(ClothingDTO.toClothingDTO(clothingEntity));
        }
        return clothingDTOList;
    }
    public ClothingDTO findByClothingId(Long clothingId){
        Optional<ClothingEntity> optionalClothingEntity =clothingRepository.findByClothingId(clothingId);
        if(optionalClothingEntity.isPresent()){
            return ClothingDTO.toClothingDTO(optionalClothingEntity.get());
        } else {
            return null;
        }
    }
    public void delete(Long clothingId) {
        clothingRepository.deleteById(clothingId);
    }
    public ClothingDTO update(ClothingDTO clothingDTO) {
        ClothingEntity clothingEntity = ClothingEntity.toUpdateEntity(clothingDTO);
        clothingRepository.save(clothingEntity);
        return findByClothingId(clothingDTO.getClothingId());
    }
}


