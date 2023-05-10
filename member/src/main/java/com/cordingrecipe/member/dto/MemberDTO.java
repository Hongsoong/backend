package com.cordingrecipe.member.dto;


import com.cordingrecipe.member.entity.MemberEntity;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MemberDTO {
    private Long id;
    private String userEmail;
    private String userQwd;
    private String userName;
    private String userPhoneNumber;
    private String userSex;
    private String userAddr;
    private String userAuthority;
    private String userBirth;
    private String userSize;

    public static MemberDTO toMemberDTO(MemberEntity memberEntity){
        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setId(memberEntity.getId());
        memberDTO.setUserEmail(memberEntity.getUserEmail());
        memberDTO.setUserQwd(memberEntity.getUserQwd());
        memberDTO.setUserName(memberEntity.getUserName());
        memberDTO.setUserPhoneNumber(memberEntity.getUserPhoneNumber());
        memberDTO.setUserSex(memberEntity.getUserSex());
        memberDTO.setUserAddr(memberEntity.getUserAddr());
        memberDTO.setUserAuthority(memberEntity.getUserAuthority());
        memberDTO.setUserBirth(memberEntity.getUserBirth());
        memberDTO.setUserSize(memberEntity.getUserSize());
        return memberDTO;
    }
}
