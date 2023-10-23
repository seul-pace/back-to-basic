package com.seul.backtobasic.study.lambda2;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerExample {
    public static void executeConsumer(List<String> nameList, Consumer<String> consumer) {
        for (String name : nameList) {
            // 메서드의 두 번재 인수로 전달된 람다 표현식을 실행시킨다.
            consumer.accept(name);
        }
    }

    // Consumer 인터페이스 활용 예제
    public static void main(String[] args) {
        List<String> nameList = new ArrayList<>();
        nameList.add("홍길동");
        nameList.add("김진서");
        nameList.add("김태이");
        nameList.add("이슬희");
        ConsumerExample.executeConsumer(nameList,
                (String name) -> System.out.println(name));
        // 랃다 표현식은 그 자체로 실행되는 것이 아니라,
        // 함수형 인터페이스에 포함되어 있는 함수형 메서드의 내부 코드를 정의하는 역할을 한다
    }
}
