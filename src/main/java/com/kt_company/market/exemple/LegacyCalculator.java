package com.kt_company.market.exemple;

public class LegacyCalculator {

    public static long calculate(String code, long originValue) {

        if (code.equals("CALC_A")) {
            return originValue;
        } else if (code.equals("CALC_B")) {
            return originValue * 10;
        } else if (code.equals("CALC_C")) {
            return originValue * 3;
        } else {
            return 0;
        }
    }

}
