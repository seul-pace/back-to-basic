package com.seul.backtobasic.chap01;

import com.seul.backtobasic.study.Calculator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {

    @Test
    void plus() {
        /*
        Caculator 가 없는 클래스였다면,
        1. 메서드 명
        2. 메서드의 파라미터 개수, 타입, 반환 값
        3. 정적과 인스턴스 중 선택
        4. 클래스 명
        등에 대해 고민할 수 있다.
         */
        int result = Calculator.add(1, 2);
        assertEquals(3, result);
        assertEquals(5, Calculator.add(4, 1));
    }
}
