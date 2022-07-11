package com.kt_company.market.mybatis.controller;


import com.kt_company.market.dto.MemberDto;
import com.kt_company.market.mybatis.service.MemberServiceBatis;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/member/batis")
@RestController
public class MemberControllerMyBatis {

    private final MemberServiceBatis memberServiceBatis;

    @GetMapping("/")
    public ResponseEntity<?> login(@ModelAttribute MemberDto memberDto) throws Exception {
        try {
            MemberDto findMember = memberServiceBatis.login(memberDto);
            return new ResponseEntity<>(findMember.getId(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
