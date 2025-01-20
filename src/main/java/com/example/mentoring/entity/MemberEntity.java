package com.example.mentoring.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

import com.example.mentoring.dto.MemberDTO;

@Entity
@Data
@Table(name = "member")
public class MemberEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @Column(name = "member_name", nullable = false, length = 20)
    private String name;

    @Column(name = "member_id", nullable = false, length = 30)
    private String Id;

    @Column(name = "member_password", nullable = false)
    private String password;

    @Column(name = "phone_number", length = 13)
    private String phone;

    @Column(name = "member_email", length = 30)
    private String email;

    @Column(name = "member_birth")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birth;

    @CreationTimestamp
    @Column(name = "join_date", updatable = false)
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date joinDate;

    // DTO -> Entity 변환 메서드 추가
    public static MemberEntity toMemberEntity(MemberDTO memberDTO) {
        MemberEntity memberEntity = new MemberEntity();
        memberEntity.setName(memberDTO.getName());
        memberEntity.setPassword(memberDTO.getPassword());
        memberEntity.setEmail(memberDTO.getEmail());
        memberEntity.setBirth(memberDTO.getBirth());
        memberEntity.setPhone(memberDTO.getPhone());
        memberEntity.setId(memberDTO.getId());
        return memberEntity;
    }
}