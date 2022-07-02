package com.kt_company.market.exemple;

public class LegacyPayGroup {

    public static String getPayGroup(String payCode) {

        if (payCode.equals("ACCOUNT_TRANSFER") || payCode.equals("REMITTANCE") || payCode.equals("ON_SITE_PAYMENT") || payCode.equals(
            "TOSS")) {
            return "CASH";
        } else if (payCode.equals("PAYCO") || payCode.equals("CARD") || payCode.equals("KAKAO_PAY") || payCode.equals("BAMIN_PAY")) {
            return "CARD";
        } else if (payCode.equals("POINT") || payCode.equals("COUPON")) {
            return "ETC";
        } else {
            return "EMPTY";
        }
    }
}
