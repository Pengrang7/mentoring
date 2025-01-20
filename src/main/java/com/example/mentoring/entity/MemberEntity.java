package com.example.mentoring.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "member")
public class MemberEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @Column(name = "member_name")
    private String name;

    @Column(name = "member_password")
    private String password;

    @Column(name = "member_email")
    private String email;

    @Column(name = "member_birth")
    private Date birth;

    @Column(name = "join_date")
    private Date joinDate;

    @Column(name = "phone_number")
    private Integer phone;

    @Column(name = "member_id")
    private String Id;

}