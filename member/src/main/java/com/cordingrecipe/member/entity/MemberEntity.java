package com.cordingrecipe.member.entity;


import com.cordingrecipe.member.dto.MemberDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name= "user_table")
public class MemberEntity {

    @Id
    @GeneratedValue
    private Long id;

    @Column(unique=true)

    private String userEmail;

    @Column

    private String userQwd;

    @Column

    private String userName;

    @Column
    private String userPhoneNumber;

    @Column
    private String userSex;

    @Column
    private String userAddr;

    @Column
    private String userAuthority;

    @Column
    private String userBirth;

    @Column
    private String userSize;

    public static MemberEntity toMemberEntity(MemberDTO memberDTO){
        MemberEntity memberEntity =new MemberEntity();
        memberEntity.setUserEmail(memberDTO.getUserEmail());
        memberEntity.setUserQwd(memberDTO.getUserQwd());
        memberEntity.setUserName(memberDTO.getUserName());
        memberEntity.setUserPhoneNumber(memberDTO.getUserPhoneNumber());
        memberEntity.setUserSex(memberDTO.getUserSex());
        memberEntity.setUserAddr(memberDTO.getUserAddr());
        memberEntity.setUserAuthority(memberDTO.getUserAuthority());
        memberEntity.setUserBirth(memberDTO.getUserBirth());
        memberEntity.setUserSize(memberDTO.getUserSize());

        return memberEntity;
    }

    public static MemberEntity toUpdateEntity(MemberDTO memberDTO){
        MemberEntity memberEntity =new MemberEntity();
        memberEntity.setId(memberDTO.getId());
        memberEntity.setUserEmail(memberDTO.getUserEmail());
        memberEntity.setUserQwd(memberDTO.getUserQwd());
        memberEntity.setUserName(memberDTO.getUserName());
        memberEntity.setUserPhoneNumber(memberDTO.getUserPhoneNumber());
        memberEntity.setUserSex(memberDTO.getUserSex());
        memberEntity.setUserAddr(memberDTO.getUserAddr());
        memberEntity.setUserAuthority(memberDTO.getUserAuthority());
        memberEntity.setUserBirth(memberDTO.getUserBirth());
        memberEntity.setUserSize(memberDTO.getUserSize());
        return memberEntity;
    }

}
