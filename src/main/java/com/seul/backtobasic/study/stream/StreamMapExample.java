package com.seul.backtobasic.study.stream;

import java.util.ArrayList;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamMapExample {

    public static void main(String[] args) {
        ArrayList<Person> personList = new ArrayList<>();
        personList.add(new Person("장윤기", 45));
        personList.add(new Person("장해라", 18));
        personList.add(new Person("장해윤", 14));
        personList.add(new Person("장윤기", 45));

        // Stream<Person> -> Stream<String> 변환
//        Stream<String> personStream = personList.stream().map((Person p) -> p.toString());
//        personStream.forEach(System.out::println);

        // mapToInt: ToIntFunction 인터페이스를 파라미터로 받아서 IntStream 으로 리턴
        IntStream intStream = personList.stream().mapToInt((Person p) -> p.getAge());
        intStream.forEach(System.out::println);
    }
}
