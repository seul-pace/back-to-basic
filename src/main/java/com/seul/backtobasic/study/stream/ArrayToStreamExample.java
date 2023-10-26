package com.seul.backtobasic.study.stream;

import java.util.Arrays;
import java.util.stream.Stream;

public class ArrayToStreamExample {
    // 배열을 스트림으로 변환하는 예
    public static void main(String[] args) {
        Person[] personList = {
                new Person("장윤기", 45),
                new Person("장해라", 14),
                new Person("장해윤", 18),
                new Person("장윤기", 45)
        };

        Stream<Person> stream = Arrays.stream(personList);
        stream.forEach(System.out::println);

        /*
        parallelSort: 배열의 데이터 정렬
        parallelPrefix: 배열의 데이터에 특정한 값을 더한다
        spliterator: 병렬 처리가 가능한 Iterator 객체를 전달한다
         */
    }
}
