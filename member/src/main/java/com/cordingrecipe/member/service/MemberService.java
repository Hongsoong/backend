package com.cordingrecipe.member.service;

import com.cordingrecipe.member.dto.MemberDTO;
import com.cordingrecipe.member.entity.MemberEntity;
import com.cordingrecipe.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public void save(MemberDTO memberDTO) {

        MemberEntity memberEntity = MemberEntity.toMemberEntity(memberDTO);
        memberRepository.save(memberEntity);

    }

    public MemberDTO login(MemberDTO memberDTO) {
        Optional<MemberEntity> byUserEmail = memberRepository.findByUserEmail(memberDTO.getUserEmail());
        if (byUserEmail.isPresent()) {
            MemberEntity memberEntity = byUserEmail.get();
            if (memberEntity.getUserQwd().equals(memberDTO.getUserQwd())) {
                MemberDTO dto = MemberDTO.toMemberDTO(memberEntity);
                return dto;
            } else {
                return null;
            }
        } else {
            return null;
        }
    }


    public List<MemberDTO> findAll(){
        List<MemberEntity> memberEntityList =memberRepository.findAll();
        List<MemberDTO> memberDTOList = new ArrayList<>();
        for (MemberEntity memberEntity: memberEntityList){
            memberDTOList.add(MemberDTO.toMemberDTO(memberEntity));
        }
        return memberDTOList;
    }
    public MemberDTO findById(Long id){
        Optional<MemberEntity> optionalMemberEntity =memberRepository.findById(id);
        if(optionalMemberEntity.isPresent()){
            return MemberDTO.toMemberDTO(optionalMemberEntity.get());
        } else {
            return null;
        }
    }
/*
    public MemberDTO updateForm(String myEmail) {
        Optional<MemberEntity> optionalMemberEntity = memberRepository.findByUserEmail(myEmail);
        if (optionalMemberEntity.isPresent()) {
            return MemberDTO.toMemberDTO(optionalMemberEntity.get());
        } else {
            return null;
        }
    }
    public void update(MemberDTO memberDTO){

        memberRepository.save(MemberEntity.toUpdateMemberEntity(memberDTO));
    }
*/
    public void delete(Long id){
        memberRepository.deleteById(id);
    }

    public MemberDTO update(MemberDTO memberDTO) {
        MemberEntity memberEntity = MemberEntity.toUpdateEntity(memberDTO);
        memberRepository.save(memberEntity);
        return findById(memberDTO.getId());
    }
}

