package com.seul.backtobasic.study;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CalculatorTestWithJUnit {

    /*
     TDD

     1. 각각의 테스트 메소드를 독립적으로 실행한다
     -> 내가 구현하고 있는 프로덕션 코드의 메소만 실행해볼 수 있다
     -> 다른 메소드에 영향을 받지 않는다

     2. 콘솔이 아닌 Assert 메소드를 이용하여 자동화 한다
     3. 테스트 코드 중복을 제거한다
     */

    private Calculator cal;

    @BeforeEach
    public void setup() {
        /*
        JUnit은 @RunWith, @Rule 같은 어노테이션을 사용해 기능을 확장할 수 있음
        @Before 안이어야만 @RunWith, @Rule에서 초기화된 객체에 접근할 수 있다

        근데 JUnit5라서 @Before는 안 먹히고 @BeforeEach가 먹히는 듯..하다
         */
        cal = new Calculator();
        System.out.println("before");
    }

    @Test
    public void add() {
        System.out.println("add");

        // 아래와 같이 콘솔로 출력해서 눈으로 보는 것이 아니라,
//        System.out.println(cal.add(6, 3));

        // 프로그램을 통해 자동화
        Assertions.assertEquals(9, cal.add(6, 3));
        // 첫 번째 인자: 기대하는 결과 값
        // 두 번째 인자: 프로덕션 코드의 메소드를 실행한 결과 값

        /*
        assertTrue, assertFalse: true/false 확인
        assertNull, assertNotNull: null 유무 판단
        assertArrayEquals: 배열 값이 같은지 검증
         */
    }

    @Test
    public void subtract() {
        System.out.println("subtract");
//        System.out.println(cal.subtract(6, 3));
        Assertions.assertEquals(3, cal.subtract(9, 6));
    }

    @AfterEach
    public void teardown() {
        System.out.println("teardown");
    }

}