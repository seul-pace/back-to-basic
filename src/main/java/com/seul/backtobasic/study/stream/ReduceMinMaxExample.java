package com.seul.backtobasic.study.stream;

import java.util.Arrays;
import java.util.List;

/**
 * reduce의 주된 기능: x값과 y값을 계산하고 그 결과를 다음 x로 넘기는 역할
 */
public class ReduceMinMaxExample {

    public static void main(String[] args) {
        List<Integer> intList = Arrays.asList(4, 2, 8, 1, 9, 6, 7, 3, 5);

        // 최댓값 구하기
        Integer max = intList.stream().reduce(0, Integer::max);
        System.out.printf("최댓값 : %s\n", max);

        // 최솟값 구하기
        Integer min = intList.stream().reduce(max, Integer::min); // 예제에서는 0이라고 되어있지만 그럼 0 나온다... 장난하나
        System.out.printf("최솟값 : %s\n", min);
    }
}
