package com.seul.backtobasic.study.stream;

import java.util.ArrayList;

/*
Distinct
1. 메서드 성능을 저하시킬 수 있다
-> 병렬 처리를 목적으로 스트림을 생성하면 distinct 별로
-> 데이터 중복을 제거하기 위해 여러 스레드에 분산해 놓은 데이터를 동기화해서 비교해야 하기 때문
-> 병렬 스트림보다는 순차 스트림을 이용하는 것이 더 빠르다

2. 중복 제거가 안 될 수도 있다
-> 스트림 항목의 중복 여부를 확인하기 위해 equals 메서드가 내부적으로 호출된다
-> String, Integer는 괜찮은데 객체는 안 된다는 거지 (따로 오버라이딩 하든가...)

 */
public class StreamDistinctExample {
    public void test() {
        ArrayList<Person> personList = new ArrayList<>();
        personList.add(new Person("장윤기", 45));
        personList.add(new Person("장해라", 18));
        personList.add(new Person("장해윤", 14));
        personList.add(new Person("장윤기", 45));

        personList.stream().distinct().forEach(System.out::println);
    }

    public static void main(String[] args) {
        new StreamDistinctExample().test();
    }
}
