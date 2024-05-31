package com.seul.backtobasic.study.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 리듀스
 * 데이터를 최종적으로 다 확인해서 결괏값을 도출하는 최종 연산
 * reduce 메서드 자체를 의미하는 경우가 많다
 */
public class ReducePracticeExample {
    // 배열에 담겨있는 숫자들의 총합을 구할 때
    public static void main(String[] args) {
        List<Integer> intList = Arrays.asList(1,2,3,4,5,6,7,8,9);

        // sum 과 count를 구할 때
        int sum = 0;
        int count = 0;

        // error -> 로컬 변수를 람다에서 쓰려면 final이어야 한다
//        intList.stream().forEach(value -> { sum+= value; count++; });

        // error -> final 변수는 초기화 된 뒤로 변경 불가능
        final int sum2 = 0;
//        intList.stream().forEach(value -> { sum2 += value; });

        int sum3[] = {0};
        // 이렇게 하면 뭔가 어거지 같음
        intList.stream().forEach(value -> sum3[0] += value);

        // 이렇게 쓰는 방법도 있지만!!
        intList.stream().mapToInt(Integer::intValue).sum();

        /////////////// reduce 이용

        Integer sum4 = intList.stream().reduce(0, Integer::sum);
        // 람다 표현식으로 정의
        Integer sum5 = intList.stream().reduce(0, (x, y) -> x + y);
    }
}
