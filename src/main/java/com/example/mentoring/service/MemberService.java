package com.example.mentoring.service;

import com.example.mentoring.dto.MemberDTO;
import com.example.mentoring.entity.MemberEntity;
import com.example.mentoring.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service //스프링이 관리해주는 객체 == 스프링 빈
@RequiredArgsConstructor //controller와 같이. final 멤버변수 생성자 만드는 역할
@Transactional
public class MemberService {

    private final MemberRepository memberRepository; // 먼저 jpa, mysql dependency 추가

    // 회원 등록
    public MemberDTO save(MemberDTO memberDTO) {
        MemberEntity memberEntity = MemberEntity.toMemberEntity(memberDTO);
        MemberEntity savedEntity = memberRepository.save(memberEntity);
        return MemberDTO.toMemberDTO(savedEntity);
    }

    // 전체 회원 조회
    public List<MemberDTO> findAll() {
        List<MemberEntity> memberEntityList = memberRepository.findAll();
        List<MemberDTO> memberDTOList = new ArrayList<>();
        for (MemberEntity memberEntity : memberEntityList) {
            memberDTOList.add(MemberDTO.toMemberDTO(memberEntity));
        }
        return memberDTOList;
    }

    // 단일 회원 조회
    public MemberDTO findById(Long id) {
        MemberEntity memberEntity = memberRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("회원이 존재하지 않습니다."));
        return MemberDTO.toMemberDTO(memberEntity);
    }

    // 회원 정보 수정
    public MemberDTO update(Long id, MemberDTO memberDTO) {
        MemberEntity memberEntity = memberRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("회원이 존재하지 않습니다."));
        
        // 기존 데이터 업데이트
        memberEntity.setName(memberDTO.getName());
        memberEntity.setEmail(memberDTO.getEmail());
        memberEntity.setPassword(memberDTO.getPassword());
        memberEntity.setBirth(memberDTO.getBirth());
        memberEntity.setPhone(memberDTO.getPhone());
        
        return MemberDTO.toMemberDTO(memberRepository.save(memberEntity));
    }

}