package com.seul.backtobasic.d;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ShortTest {

    @Test
    void shortTest() {
        String id = "abc";

//        assertTrue(id.contains("a"));
        // 위와 같이 작성하면 예측이 true 인데 false다, 라는 말만 보여준다

        // 여기서 AssertJ를 사용한다
        assertThat(id).contains("a");
        /*
        틀렸을 때 아래와 같이 문구가 뜬다
        java.lang.AssertionError:
        Expecting actual:
          "bc"
        to contain:
          "a"
         */
    }

    @Test
    void sumTest() {
        int value = sum(2, 2);
        assertThat(value).isEqualTo(4);
    }

    private int sum(int a, int b) {
        return a + b;
    }

    @Test
    void shortTest2() {
        User user = new User();
        LocalDateTime regDt = user.getRegDt();
        assertThat(regDt).isAfter(LocalDateTime.of(2019, 1, 31, 23, 59, 59));
    }

    @DisplayName("여러 검증을 수행하고 싶을 때")
    @Test
    void shortTest3() {
//        SoftAssertions soft = new SoftAssertions();
//        soft.assertThat(1).isBetween(0, 2);
//        soft.assertThat(1).isGreaterThan(2);
//        soft.assertThat(1).isLessThan(0);
//        soft.assertAll(); // 저 위의 코드를 진행할 때는 에러가 발생하지 않다가 assertAll 실행하면서 발생한다

        SoftAssertions.assertSoftly(soft -> {
            soft.assertThat(1).isBetween(0, 2);
            soft.assertThat(1).isLessThan(2);
        });
    }

    @DisplayName("설명 달기")
    @Test
    void shortTest4() {
        String id = "abc";

        // 실패하면 설명이 나온다
        assertThat(id)
                .as("ID 검사: %s", id)
                .isEqualTo("abc");
    }

    @DisplayName("여러 개에 설명 달기")
    @Test
    void shortTest5() {
        List<Integer> ret = getResults();

        List<Integer> expected = Arrays.asList(1, 2, 3);
        SoftAssertions soft = new SoftAssertions();
        for (int i = 0; i < expected.size(); i++) {
            soft.assertThat(ret.get(i)).as("ret[%d]", i).isEqualTo(expected.get(i));
        }
        soft.assertAll();
    }

    private List<Integer> getResults() {
        return Arrays.asList(1, 2, 3);
    }
}
