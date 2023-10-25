package com.seul.backtobasic.study.stream;

import java.util.ArrayList;
import java.util.Comparator;

public class StreamSortedExample2 {
    public static void main(String[] args) {
        ArrayList<Person> personList = new ArrayList<>();
        personList.add(new Person("장윤기", 45));
        personList.add(new Person("장해라", 18));
        personList.add(new Person("장해윤", 14));
        personList.add(new Person("장윤기", 45));

        // 역방향 정렬
        // Comparable 인터페이스가 구현되어 있어야 한다
        personList.stream().sorted(Comparator.reverseOrder())
                .forEach(System.out::println);

        System.out.println("^_^");

        // 나이 순 정렬
        personList.stream().sorted(Comparator.comparing(Person::getAge))
                .forEach(System.out::println);

        System.out.println("^o^");

        // 이름 순 정렬
        personList.stream().sorted(Comparator.comparing(Person::getName))
                .forEach(System.out::println);
    }
}
