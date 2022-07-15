package com.kt_company.market.service;

import com.kt_company.market.dto.MemberDto;
import com.kt_company.market.util.common.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
public class MemberServiceTest {

    @Autowired
    MemberService memberService;

    @Test
    public void init() {
        log.debug("초기화.....");
    }

    @Test
    @DisplayName("테스트용 회원 데이터 입력.")
    public void joinMembers() throws Exception {

        for (int i = 0; i < 1000; i++) {
            MemberDto memberDto = new MemberDto();
            memberDto.setId("member" + i);
            memberDto.setPassword(StringUtil.convertSHA256("111111"));
            memberDto.setPhoneNumber("01012345678");
            memberDto.setAddress1("주소 1번");
            memberDto.setAddress2("주소 2번");
            memberDto.setZipcode("10000");
            memberDto.setType("NORMAL");
            memberDto.setGrade("BRONZE");
            memberService.join(memberDto);
        }

    }


}
