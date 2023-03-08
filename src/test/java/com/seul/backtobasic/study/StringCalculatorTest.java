package com.seul.backtobasic.study;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StringCalculatorTest {

    private StringCalculator cal;

    @BeforeEach
    public void setup() {
        System.out.println("setup");
        cal = new StringCalculator();
    }

    /*
    곧바로 구현하지 않고 요구사항을 더 작은 단위로 나눠 테스트할 경우의 수를 분리
    1. 일반: 그냥 넣었을 때 합 반환
    1-1. 구분자가 없을 때
    1-2. 구분자가 섞여있을 때

    2. 커스텀 구분자를 넣었을 때 반환
    2-1. 커스텀 구분자가 두 개의 사이에 위치하지 않을 때?

    3. 음수를 전달했을 때

    책에서 알려주는 것들
    1. 빈 문자열 또는 null 값을 입력할 경우 0을 반환해야 한다
    2. 숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다
    3. 숫자 두 개를 쉼표 구분자로 입력할 경우 두 숫자의 합을 반환한다
    4. 구분자를 쉼표 이외에 콜론을 사용할 수 있다
    5. "//"와 "\n" 문자 사이에 커스텀 구분자를 지정할 수 있다
    6. 문자열 계산기에 음수를 전달하는 경우 RuntimeException 예외 처리를 한다

    뭐가 다르지..?

     */

    @Test
    public void test1() {
        Assertions.assertEquals(0, cal.add(""));
    }

    @Test
    public void test1_1() {
        Assertions.assertEquals(0, cal.add(null));
    }

    @Test
    public void test2() {
        Assertions.assertEquals(1, cal.add("1"));
    }

    @Test
    public void test3() {
        Assertions.assertEquals(6, cal.add("1,2:3"));
    }

    @Test
    public void test4() {
        Assertions.assertEquals(6, cal.add("//;\n1;2;3"));
    }

    @Test // 원래는 여기에 expected = RuntimeException.class를 붙였음 (JUnit4)
    public void test5() {
        assertThrows(RuntimeException.class, () -> {
            cal.add("-1,2,3");
        });
    }
}