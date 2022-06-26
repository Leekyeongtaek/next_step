package com.kt_company.market.util.common;

import java.security.MessageDigest;

public class StringUtil {

    /**
     * 파라미터로 받은 문자열을 SHA-256 해시값으로 반환한다.
     */
    public static String convertSHA256(String param) throws Exception {
        StringBuffer sbuf = new StringBuffer();

        MessageDigest mDigest = MessageDigest.getInstance("SHA-256");
        mDigest.update(param.getBytes());

        byte[] msgStr = mDigest.digest();

        for (byte tmpStrByte : msgStr) {
            String tmpEncTxt = Integer.toString((tmpStrByte & 0xff) + 0x100, 16).substring(1);
            sbuf.append(tmpEncTxt);
        }

        return sbuf.toString();
    }

}
