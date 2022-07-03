package com.kt_company.market.controller;

import com.kt_company.market.dto.MemberDto;
import com.kt_company.market.service.MemberService;
import java.util.HashMap;
import java.util.Map;
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
        try {
            memberService.join(memberDto);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            Map<String, Object> result = new HashMap<>();
            result.put("errorCode", 500);
            result.put("errorMsg", "회원가입 중 오류가 발생 했습니다. 고객센터로 문의해주시기 바랍니다.");
            return new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
