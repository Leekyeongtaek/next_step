package com.kt_company.market.exemple;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StreamExamples {

    public static void main(String[] args) {

        // Stream 사용 전
        String[] nameArr = {"IronMan", "Captain", "Hulk", "Thor"};
        List<String> nameList = Arrays.asList(nameArr);

        // 원본의 데이터가 직접 정렬됨
        Arrays.sort(nameArr);
        Collections.sort(nameList);

        for (String str : nameArr) {
            System.out.println("스트링 배열 = " + str);
        }

        for (String str : nameList) {
            System.out.println("리스트 배열 = " + str);
        }

        // Stream 사용 후
        String[] nameArr2 = {"IronMan", "Captain", "Hulk", "Thor"};
        List<String> nameList2 = Arrays.asList(nameArr2);

        // 원본의 데이터가 아닌 별도의 Stream을 생성함
        Stream<String> nameStream = nameList2.stream();
        Stream<String> arrayStream = Arrays.stream(nameArr2);

        // 복사된 데이터를 정렬하여 출력함
        nameStream.sorted().forEach(System.out::println);
        arrayStream.sorted().forEach(System.out::println);

        // Stream API는 일회용이기 때문에 한번 사용이 끝나면 재사용이 불가능하다. Stream이 또 필요한 경우에는 Stream을 다시 생성해주어야 한다.
        // 만약 닫힌 Stream을 다시 사용한다면 IllegalStateException이 발생하게 된다.

        List<String> myList = Arrays.asList("a1", "a2", "b1", "c2", "c1");

        myList
            .stream()                            // 생성하기
            .filter(s -> s.startsWith("c"))        // 가공하기
            .map(String::toUpperCase)            // 가공하기
            .sorted()                            // 가공하기
            .count();                            // 결과만들기

        //// 람다 방식
        //(매개변수, ... ) -> { 실행문 ... }

        //// 예시
        //() -> "Hello World!";

        // 이렇게 람다식이 등장하게 된 이유는 불필요한 코드를 줄이고, 가독성을 높이기 위함이다.
        // 그렇기 때문에 함수형 인터페이스의 인스턴스를 생성하여 함수를 변수처럼 선언하는 람다식에서는 메소드의 이름이 불필요하다고 여겨져서 이를 사용하지 않는다.

        //public class Lambda {
        //
        //    public static void main(String[] args) {
        //
        //        // 기존의 익명함수
        //        System.out.println(new MyLambdaFunction() {
        //            public int max(int a, int b) {
        //                return a > b ? a : b;
        //            }
        //        }.max(3, 5));
        //
        //    }
        //
        //}

        //@FunctionalInterface
        //interface MyLambdaFunction {
        //    int max(int a, int b);
        //}
        //
        //public class Lambda {
        //
        //    public static void main(String[] args) {
        //
        //        // 람다식을 이용한 익명함수
        //        MyLambdaFunction lambdaFunction = (int a, int b) -> a > b ? a : b;
        //        System.out.println(lambdaFunction.max(3, 5));
        //    }
        //
        //}

        // 하지만 함수형 인터페이스의 등장으로 우리는 함수를 변수처럼 선언할 수 있게 되었고, 코드 역시 간결하게 작성할 수 있게 되었다.
        // 함수형 인터페이스를 구현하기 위해서는 인터페이스를 개발하여 그 내부에는 1개 뿐인 abstract 함수를 선언하고, 위에는 @FunctionalInterface 어노테이션을 붙여주면 된다.
        // 위의 코드를 람다식으로 변경하면 다음과 같다.

        //1. 스트림 생성 방법들

        //[ Collection의 Stream 생성 ]
        // List로부터 스트림을 생성
        List<String> list = Arrays.asList("a", "b", "c");
        Stream<String> listStream = list.stream();

        //[ 배열의 Stream 생성 ]
        // 배열로부터 스트림을 생성
        Stream<String> stream1 = Stream.of("a", "b", "c"); //가변인자
        Stream<String> stream2 = Stream.of(new String[]{"a", "b", "c"});
        Stream<String> stream3 = Arrays.stream(new String[]{"a", "b", "c"});
        Stream<String> stream4 = Arrays.stream(new String[]{"a", "b", "c"}, 0, 3); //end범위 포함 x


        //[ 원시 Stream 생성 ]
        // 4이상 10 이하의 숫자를 갖는 IntStream
        IntStream stream = IntStream.range(4, 10);

        //2. 스트림 가공 하기.

        // 데이터 변환 [ 필터링 - Filter ]
        //Filter는 Stream에서 조건에 맞는 데이터만을 정제하여 더 작은 컬렉션을 만들어내는 연산이다.

        //예시
        Stream<String> stream5 =
            list.stream()
                .filter(name -> name.contains("a"));

        // [ 데이터 변환 - Map ]
        // Map은 기존의 Stream 요소들을 변환하여 새로운 Stream을 형성하는 연산이다
        // 저장된 값을 특정한 형태로 변환하는데 주로 사용되며, Java에서는 map 함수의 인자로 함수형 인터페이스 function을 받고 있다.
        // 예를 들어 String을 요소들로 갖는 Stream을 모두 대문자 String의 요소들로 변환하고자 할 때 map을 이용할 수 있다.

        List<String> names = Arrays.asList(nameArr);

        Stream<String> stream6 = names.stream().map(String::toUpperCase);

        stream6.forEach(System.out::println);

        List<String> list7 = Arrays.asList("Java", "Scala", "Groovy", "Python", "Go", "Swift", "Java");

        Stream<String> stream7 = list7.stream().distinct();

        // 만약  equals와 hashCode를 오버라이드하지 않았기 때문에, 아래의 코드를 실행해도 중복된 데이터가 제거되지 않고, size 값으로 2를 출력하게 된다.
        // Employee e1 = new Employee("MangKyu");
        // Employee e2 = new Employee("MangKyu");


        //[ 원시 Stream <-> Stream ]
        //작업을 하다 보면 일반적인 Stream 객체를 원시 Stream으로 바꾸거나 그 반대로 하는 작업이 필요한 경우가 있다.

        // IntStream -> Stream<Integer>
        IntStream.range(1, 4)
            .mapToObj(i -> "a" + i);

        // Stream<Double> -> IntStream -> Stream<String>
        Stream.of(1.0, 2.0, 3.0)
            .mapToInt(Double::intValue)
            .mapToObj(i -> "a" + i);

        // 3. Stream 결과 만들기(최종 연산)

        // [ 최댓값/최솟값/총합/평균/갯수 - Max/Min/Sum/Average/Count ]

        // [ 데이터 수집 - collect ]

        //Collectors.joining()
        //Stream에서 작업한 결과를 1개의 String으로 이어붙이기를 원하는 경우에 Collectors.joining()을 이용할 수 있다.
        // Collectors.joining()은 총 3개의 인자를 받을 수 있는데, 이를 이용하면 간단하게 String을 조합할 수 있다.

        //delimiter : 각 요소 중간에 들어가 요소를 구분시켜주는 구분자
        //prefix : 결과 맨 앞에 붙는 문자
        //suffix : 결과 맨 뒤에 붙는 문자

        // Collectors.averagingInt(), Collectors.summingInt(), Collectors.summarizingInt()
        //Double averageAmount = productList.stream()
        //	.collect(Collectors.averagingInt(Product::getAmount));
        //
        //// 86
        //Integer summingAmount = productList.stream()
        //	.collect(Collectors.summingInt(Product::getAmount));
        //
        //// 86
        //Integer summingAmount = productList.stream()
        //    .mapToInt(Product::getAmount)
        //    .sum();


        // 객체로 한번에 연산 값들을 받는 법.
        //IntSummaryStatistics statistics = productList.stream()
        //    .collect(Collectors.summarizingInt(Product::getAmount));
        //
        ////IntSummaryStatistics {count=5, sum=86, min=13, average=17.200000, max=23}

        //Collectors.groupingBy() -> Map 으로 반환됨.


        //Collectors.partitioningBy() -> true/fals 여부에 따라 MAP으로 반환.
        //Map<Boolean, List<Product>> mapPartitioned = productList.stream()
        //	.collect(Collectors.partitioningBy(p -> p.getAmount() > 15));

        //[ 조건 검사 - Match ]
        //Stream의 요소들이 특정한 조건을 충족하는지 검사하고 싶은 경우에는 match 함수를 이용할 수 있다
        //anyMatch: 1개의 요소라도 해당 조건을 만족하는가
        //allMatch: 모든 요소가 해당 조건을 만족하는가
        //nonMatch: 모든 요소가 해당 조건을 만족하지 않는가

        //[ 특정 연산 수행 - forEach ]

    }

}
