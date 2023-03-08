package com.seul.backtobasic.study;

import org.springframework.util.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 문자열 계산기
 * 쉼표, 또는 콜론을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환한다
 *
 * 1. 커스텀 구분자를 지정할 수 있다.
 * 문자열의 앞부분의 "//"와 "\n" 사이에 위치하는 문자를 커스텀 구분자로 사용
 *
 * 2. 문자열 계산기에 음수를 전달하는 경우 RuntimeException으로 예외 처리
 */
public class StringCalculator {

    /*
    리팩토링
    1. 메소드가 한 가지 책임만 가지도록 구현한다
    2. 인덴트(들여쓰기) 깊이를 1단계로 유지한다
    3. else를 사용하지 마라
     */

    /*
    1. 요구사항을 작은 단위로 나누기
    2. 모든 단계의 끝은 리팩토링! 하나의 요구사항 완료 후 리팩토링 진행 필수

     */

    public int add(String text) {
        if (isBlank(text)) {
            return 0;
        }

        return sum(toInts(split(text)));
    }

    private boolean isBlank(String text) {
        return text == null || text.isEmpty();
    }

    private String[] split(String text) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (m.find()) {
            String customDelimeter = m.group(1);
            return m.group(2).split(customDelimeter);
        }

        return text.split(",|;");
    }

    // 숫자의 합을 구하는 부분을 메소드로 분리
    private int sum(int[] numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return sum;
    }

    // 하나의 메서드에 하나의 기능을 하게 하기 위해
    // int 배열로 바꿔주는 작업을 분리한다
    private int[] toInts(String[] values) {
        int[] numbers = new int[values.length];
        for (int i = 0; i < values.length; i++) {
            numbers[i] = toPositive(values[i]);
        }
        return numbers;
    }

    private int toPositive(String value) {
        int number = Integer.parseInt(value);
        if (number < 0) {
            throw new RuntimeException();
        }
        return number;
    }
}
