package com.kt_company.market.service;

import com.kt_company.market.dto.MemberDto;
import com.kt_company.market.entity.MemberEntity;
import com.kt_company.market.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class MemberService {

    private final MemberRepository memberRepository;

    /**
     * 회원가입.
     */
    public void join(MemberDto memberDto) throws Exception {
        MemberEntity member = MemberEntity.builder()
            .id(memberDto.getId())
            .password(memberDto.getPassword())
            .build();

        memberRepository.save(member);
    }



}
