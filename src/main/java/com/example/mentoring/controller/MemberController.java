package com.example.mentoring.controller;

import com.example.mentoring.dto.MemberDTO;
import com.example.mentoring.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController  // @Controller 대신 @RestController 사용
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/member/list")
    public List<MemberDTO> findAll() {  // Model 파라미터와 String 리턴 제거
        return memberService.findAll();  // DTO 리스트를 직접 반환
    }

}