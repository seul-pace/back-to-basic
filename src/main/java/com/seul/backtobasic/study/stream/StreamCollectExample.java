package com.seul.backtobasic.study.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamCollectExample {

    public static void main(String[] args) {
        ArrayList<Person> personList = new ArrayList<>();
        personList.add(new Person("장윤기", 45));
        personList.add(new Person("장해리", 18));
        personList.add(new Person("장해윤", 14));
        personList.add(new Person("장윤기", 45));

        // 최종 결과를 List 객체르 반환
        List<Person> sortedList = personList.stream().sorted().collect(Collectors.toList());

        for (Person person : sortedList) {
            System.out.println(person);
        }
        /*
        Collectors.joining(",")
        - 스트림의 데이터를 하나로 합치는 것, 괄호 안에 든 string = 구분자

        Collectors.summingInt()
        - 전체 값을 합산

        Collectors.groupingBy
        - 분류해서... 리스트로 묶어줌

        Collectors.partitioningBy
        - 조건에 맞는지 여부에 따라 두 가지로 분류해서 Boolean 값으로 나타낸다
         */
    }
}
