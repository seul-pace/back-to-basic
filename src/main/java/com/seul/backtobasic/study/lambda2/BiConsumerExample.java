package com.seul.backtobasic.study.lambda2;

import java.util.function.BiConsumer;

public class BiConsumerExample {
    // 입력이 두 개라 제네릭 타입 역시 두 개를 지정해야 한다.
    public static void executeBiConsumer(String param1, String param2, BiConsumer<String, String> biConsumer) {
        biConsumer.accept(param1, param2);
    }

    // BiConsumer 인터페이스 실행 예
    public static void main(String[] args) {
        BiConsumer<String, String> biConsumer = (String param1, String param2) -> {
            System.out.print(param1);
            System.out.println(param2);
        };

        BiConsumerExample.executeBiConsumer("Hello ", "World!", biConsumer);
    }
}
