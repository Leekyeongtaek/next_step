//package com.kt_company.market.mybatis.service;
//
//import com.kt_company.market.dto.MemberDto;
//import com.kt_company.market.mybatis.mapper.MemberMapper;
//import com.kt_company.market.util.common.StringUtil;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.stereotype.Service;
//
//@Slf4j
//@RequiredArgsConstructor
//@Service
//public class MemberServiceBatis {
//
//    private final MemberMapper memberMapper;
//
//    /**
//     * 로그인.
//     */
//    public MemberDto login(MemberDto dto) throws Exception {
//        try{
//            dto.setPassword(StringUtil.convertSHA256(dto.getPassword()));
//            MemberDto findMember = memberMapper.selectMember(dto);
//            if(findMember == null) {
//                throw new Exception("존재하지 않은 아이디 입니다.");
//            }
//            return findMember;
//        }catch (Exception e){
//            throw new Exception(e);
//        }
//    }
//
//}
