package com.example.mentoring.dto;

import com.example.mentoring.entity.MemberEntity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@NoArgsConstructor
@ToString
public class MemberDTO {
    private Long idx;
    private String name;
    private String password;
    private String email;
    private Date birth;
    private Date joinDate;
    private String phone;
    private String Id;

    public static MemberDTO toMemberDTO(MemberEntity memberEntity) {
        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setIdx(memberEntity.getIdx());
        memberDTO.setName(memberEntity.getName());
        memberDTO.setPassword(memberEntity.getPassword());
        memberDTO.setEmail(memberEntity.getEmail());
        memberDTO.setBirth(memberEntity.getBirth());
        memberDTO.setJoinDate(memberEntity.getJoinDate());
        memberDTO.setPhone(memberEntity.getPhone());
        memberDTO.setId(memberEntity.getId());
        return memberDTO;
    }
} 