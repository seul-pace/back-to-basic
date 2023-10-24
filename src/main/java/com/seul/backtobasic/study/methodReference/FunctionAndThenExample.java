package com.seul.backtobasic.study.methodReference;

import java.util.function.Function;

public class FunctionAndThenExample {
    // Function 인터페이스 조합 예
    public static void main(String[] args) {
        Function<String, Integer> parseIntFunction = (String str) -> Integer.parseInt(str) + 1;
        Function<Integer, String> intToStrFunction = (Integer i) -> "String : " + Integer.toString(i);

        System.out.println(parseIntFunction.apply("1000"));
        System.out.println(intToStrFunction.apply(1000));

        // Function 객체 조합 후 실행
        System.out.println(parseIntFunction.andThen(intToStrFunction).apply("1000"));
        // 결과: 1001
        // 입력 값과 리턴 값이 존재하기 때문에 첫 번재 람다 표현식의 결괏값을 다음 람다 표현식의 입력갑승로 전달해서 사용한다

        System.out.println(intToStrFunction.compose(parseIntFunction).apply("1000"));
        // 뒤에서 앞으로 함수형 메서드가 호출된다
    }

}
