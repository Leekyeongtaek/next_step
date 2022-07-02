package com.kt_company.market.exemple;

public class LegacyCase {

    public String toTable1Value(String originValue) {
        if (originValue.equals("Y")) {
            return "1";
        } else {
            return "0";
        }
    }

    public boolean toTable2Value(String originValue) {
        if (originValue.equals("Y")) {
            return true;
        } else {
            return false;
        }
    }

}
