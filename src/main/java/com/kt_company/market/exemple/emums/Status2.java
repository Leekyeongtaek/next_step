package com.kt_company.market.exemple.emums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Status2 implements EnumMapperType {
    PROCEEDING("진행중"),
    COMPLETE("진행완료");

    @Getter
    private final String title;

    @Override
    public String getCode() {
        return name();
    }

}
