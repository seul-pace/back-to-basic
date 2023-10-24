package com.seul.backtobasic.study.methodReference;

import java.util.function.Consumer;

public class AndThenExample {

    public static void main(String[] args) {
        Consumer<String> consumer = (String text) -> System.out.println("Hello : " + text);
        Consumer<String> consumerAndThen = (String text) -> System.out.println("Text Length is " + text.length());

        consumer.andThen(consumerAndThen).accept("Java");
        // accept 메서드는 리턴 값이 void 타입
        // 한번에 호출하지만 연결해서 처리하지 않는다
    }
}
