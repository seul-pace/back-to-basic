package com.seul.backtobasic.study.stream;

import java.util.Arrays;
import java.util.List;

public class StreamFlatMapExample {
    // 다중 배열 처리 예
    public static void main(String[] args) {
        String[][] rawData = new String[][] {
                {"a","b"}, {"c","d"}, {"e","a"}, {"a","h"}, {"i","j"}
        };

        List<String[]> rawList = Arrays.asList(rawData);

        // 2차원 배열 중 a 찾기
        rawList.stream()
                .filter(array -> "a".equals(array[0].toString()) || "a".equals(array[1].toString()))
                .forEach(array -> System.out.println("{" + array[0] + ", " + array[1] + "}"));

        System.out.println();
        System.out.println("flatMap을 이용한 평면화");

        rawList.stream()
                .flatMap(array -> Arrays.stream(array))
                .filter(data -> "a".equals(data.toString()))
                .forEach(data -> System.out.println(data));
    }
}
