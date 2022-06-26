package com.kt_company.market.controller;

import com.kt_company.market.dto.MemberDto;
import com.kt_company.market.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/member")
@RestController
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/create")
    public ResponseEntity<?> joinMember(@ModelAttribute MemberDto memberDto) throws Exception {
        log.info(memberDto.getId());
        log.info(memberDto.getPassword());
        memberService.join(memberDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
