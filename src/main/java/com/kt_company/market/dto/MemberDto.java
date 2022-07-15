package com.kt_company.market.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class MemberDto {
    private String id;
    private String password;
    private String type;
    private String phoneNumber;
    private String grade;
    private String address1;
    private String address2;
    private String zipcode;
}
