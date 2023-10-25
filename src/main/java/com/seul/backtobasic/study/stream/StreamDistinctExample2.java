package com.seul.backtobasic.study.stream;

import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * 만약 equals와 hashcode를 오버라이딩 할 수 없는 클래스를 활용해야 한다면?
 * 어쩔 수 없지... 중복 제거하는 메서드를 별도로 작서해서 적용해야지...
 */
public class StreamDistinctExample2 {
    public static <T> Predicate<T> distinctByKey(Function<? super T, ?> key) {
        Map<Object, Boolean> seen = new ConcurrentHashMap<>();
        return t -> seen.putIfAbsent(key.apply(t), Boolean.TRUE) == null;
    }

    public void test() {
        ArrayList<Person> personList = new ArrayList<>();
        personList.add(new Person("장윤기", 45));
        personList.add(new Person("장해라", 18));
        personList.add(new Person("장해윤", 14));
        personList.add(new Person("장윤기", 45));

        personList.stream().filter(distinctByKey(b -> (b.getName() + b.getAge())))
                .forEach(System.out::println);
    }

    public static void main(String[] args) {
        new StreamDistinctExample2().test();
    }
}
