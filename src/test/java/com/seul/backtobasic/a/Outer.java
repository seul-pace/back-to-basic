package com.seul.backtobasic.a;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class Outer {

    @BeforeEach
    void outerBefore() {
    }

    @Test
    void outer() {}

    @AfterEach
    void outerAfter() {}

    @Nested
    class NestedA {

        @BeforeEach
        void nestedBefore() {}

        @Test
        void nested1() {}

        @AfterEach
        void nestedAfter() {}
    }
}

/*
nested1() 실행 순서

1. Outer 객체 생성
2. NestedA 객체 생성
3. outerBefore() 메서드 실행
4. nestedBefore() 메서드 실행
5. nested1() 테스트 실행
6. nestedAfter() 메서드 실행
7. outerAfter() 메서드 실행
 */
