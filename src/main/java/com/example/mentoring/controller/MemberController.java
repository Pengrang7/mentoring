package com.example.mentoring.controller;

import com.example.mentoring.dto.MemberDTO;
import com.example.mentoring.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {
    private final MemberService memberService;

    // 회원 등록
    @PostMapping("/save")
    public ResponseEntity<MemberDTO> save(@RequestBody MemberDTO memberDTO) {
        return ResponseEntity.ok(memberService.save(memberDTO));
    }

    // 전체 회원 조회
    @GetMapping("/list")
    public ResponseEntity<List<MemberDTO>> findAll() {
        return ResponseEntity.ok(memberService.findAll());
    }

    // 단일 회원 조회
    @GetMapping("/{id}")
    public ResponseEntity<MemberDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(memberService.findById(id));
    }

    // 회원 정보 수정
    @PutMapping("/{id}")
    public ResponseEntity<MemberDTO> update(@PathVariable Long id, @RequestBody MemberDTO memberDTO) {
        return ResponseEntity.ok(memberService.update(id, memberDTO));
    }
}