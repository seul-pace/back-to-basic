package com.seul.backtobasic.study.methodReference;

import java.util.function.Predicate;

public class PredicateAndExample {
    // 남자인지 판단
    public static Predicate<Person> isMale() {
        // 재활용하고 공유할 수도 있고, 특별한 이름을 부여함
        // 가독성이 높아짐!
        return (Person p) -> "male".equals(p.getSex());
    }

    // 성인인지 판단
    public static Predicate<Person> isAdult() {
        return (Person p) -> p.getAge() > 20;
    }

    // Predicate 조합 예
    public static void main(String[] args) {
        Predicate<Person> predicateA = PredicateAndExample.isMale();
        Predicate<Person> predicateB = PredicateAndExample.isAdult();

        Predicate<Person> predicateAB = predicateA.and(predicateB);

        Person person = new Person();
        person.setName("David Chang");
        person.setAge(35);
        person.setSex("male");

        System.out.println(person.getName() + " 's result : " + predicateAB.test(person));
    }
}
