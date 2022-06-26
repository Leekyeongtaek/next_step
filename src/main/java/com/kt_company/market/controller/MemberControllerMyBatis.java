package com.kt_company.market.controller;


import com.kt_company.market.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RequiredArgsConstructor
@RequestMapping("/member/batis")
@RestController
@Controller
public class MemberControllerMyBatis {

    // 기능 요구 사항.
    /**
     * 1. Api. 만들기. -> Service 단 호출.
     * 2. 멤버 조회하기. -> 매퍼 써서.
     */

    private final MemberMapper memberMapper;

    
//    @PostMapping("/find")
//    public



}
