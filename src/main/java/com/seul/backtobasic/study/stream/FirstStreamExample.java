package com.seul.backtobasic.study.stream;

import java.util.ArrayList;
import java.util.stream.Stream;

public class FirstStreamExample {

    public static void main(String[] args) {
        ArrayList<String> firstList = new ArrayList<>();
        firstList.add("1");
        firstList.add("2");
        firstList.add("3");
        firstList.add("4");
        firstList.add("5");
        firstList.add("6");
        firstList.add("7");
        firstList.add("8");
        firstList.add("9");
        firstList.add("0");

        System.out.println("First List: " + firstList);

        /*
        // 스트림 객체를 생성한다
        Stream<String> firstStream = firstList.stream();
        // 스트림 객체의 크기를 조회한다. (최종 연산)
        System.out.println("Stream 항목 개수 : " + firstStream.count());
        // 스트림에서 앞에서 5개의 데이터를 한정해서 새로운 스트림 객체를 생성한다
        Stream<String> limitedStream = firstStream.limit(5);
        limitedStream.forEach(System.out::println);
         */
        // 위와 같이 실행하면
        // stream has already been operated upon or closed -> 이런 에러 발생

        // 스트림은 한 번 사용하고 나면 다시 사용할 수 없다: 한 번 흐르면 다시 돌아오지 않기 때문에
        // void를 리턴하는 메서드를 호출하면 전체 데이터 스트림을 처리해서 데이터 소모 후 종료 된다

        // 스트림의 크기를 출력한다.
        Stream<String> firstStream = firstList.stream();
        System.out.println(firstStream.count());

        // 스트림 데이터를 5개로 제한한 후 그 값을 출력한다.
        firstStream = firstList.stream(); // 다시 Stream 객체 생성. 올바른 예는 아니다.
        Stream<String> limitedStream = firstStream.limit(5);
        limitedStream.forEach(System.out::println);
    }
}
