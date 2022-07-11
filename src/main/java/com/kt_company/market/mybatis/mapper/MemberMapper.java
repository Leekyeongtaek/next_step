package com.kt_company.market.mybatis.mapper;

import com.kt_company.market.dto.MemberDto;

public interface MemberMapper {
    MemberDto selectMember(MemberDto memberDto);
}
