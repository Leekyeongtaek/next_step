package com.kt_company.market.exemple;

public class EasyEnumExample {
    // Enum을 사용하지 않는 상수 정의 방법
    public static final String PROCEEDING = "진행중";
    public static final String COMPLETE = "진행완료";

    public static void main (String[] args) {
        String status1;

        status1 = EasyEnumExample.PROCEEDING;
        status1 = EasyEnumExample.COMPLETE;

        // PROCEEDING, COMPLETE를 제외한 다른 값을 할당하여도 컴파일 에러 X
        status1 = "준비중";


        Status status2;
        status2 = Status.PROCEEDING;
        status2 = Status.COMPLETE;

        //컴파일 시 의도하지 않는 상수 값을 검사하며, 컴파일 에러를 통해 확인할 수 있음
//        status2 = "준비중";

    }
}
