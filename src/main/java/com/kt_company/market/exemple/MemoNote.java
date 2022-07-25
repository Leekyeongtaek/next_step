package com.kt_company.market.exemple;

public class MemoNote {

    public static void main(String[] args) {
        int x = 10;
        int[] y = {2, 3, 4};
        Dog dog1 = new Dog("강아지1");
        Dog dog2 = new Dog("강아지2");

        // 함수 실행
        foo(x, y, dog1, dog2);

        // 어떤 결과가 출력될 것 같은지 혹은 값이 어떻게 변할지 예상해보세요!
        System.out.println("x = " + x); // 10
        System.out.println("y = " + y[0]); // 3
        System.out.println("dog1.name = " + dog1.getName()); // 강아지1
        System.out.println("dog2.name = " + dog2.getName()); // 이름 바뀐 강아지2
    }

    public static void foo(int x, int[] y, Dog dog1, Dog dog2) {
        x++;
        y[0]++; // 3
        dog1 = new Dog("이름 바뀐 강아지1");
        dog2.setName("이름 바뀐 강아지2");
    }


}


class Dog {

    private String name;

    public Dog (String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
