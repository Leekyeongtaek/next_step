package com.kt_company.market.exemple;

import java.util.Optional;

public class OptionalEx {

    public void findUserEmailOrElse() {
        String userEmail = "Empty";
        String result = Optional.ofNullable(userEmail)
            .orElse(getUserEmail());

        System.out.println(result);
    }

    public void findUserEmailOrElseGet() {
        String userEmail = "Empty";
        String result = Optional.ofNullable(userEmail)
            .orElseGet(this::getUserEmail);

        System.out.println(result);
    }

    public String getUserEmail() {
        System.out.println("getUserEmail() Called");
        return "mangkyu@tistory.com";
    }

    public static void main(String[] args) {
        OptionalEx optionalEx = new OptionalEx();
        System.out.println("1. orElse인 경우");
        optionalEx.findUserEmailOrElse();
        System.out.println();
        System.out.println("2. orElseGet인 경우");
        optionalEx.findUserEmailOrElseGet();
    }

}
