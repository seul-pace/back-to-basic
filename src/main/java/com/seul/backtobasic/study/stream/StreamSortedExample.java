package com.seul.backtobasic.study.stream;

import java.util.ArrayList;

public class StreamSortedExample {

    public static void main(String[] args) {
        ArrayList<Person> personList = new ArrayList<>();
        personList.add(new Person("장윤기", 45));
        personList.add(new Person("장해라", 18));
        personList.add(new Person("장해윤", 14));
        personList.add(new Person("장윤기", 45));

        personList.stream().sorted().forEach(System.out::println);
    }
}
