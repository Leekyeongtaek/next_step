package com.kt_company.market.exemple.emums;

import lombok.Getter;

@Getter
public class EnumMapperValue {
    private String code;
    private String title;

    public EnumMapperValue(EnumMapperType enumMapperType) {
        code = enumMapperType.getCode();
        title = enumMapperType.getTitle();
    }

}
