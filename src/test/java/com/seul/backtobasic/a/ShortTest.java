package com.seul.backtobasic.a;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfSystemProperty;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShortTest {

    /*
    이 외에도
    @EnabledOnOs: 특정 운영체제
    @EnabledOnJre: 자바 버전에 따라 실행
    @EnabledIfEnvironmentVariable: 환경변수
     */
    @DisplayName("시스템 프로퍼티의 이름을 지정, matches: 값의 일치 여부를 검사할 때 사용할 정규식 (java.vm.name 시스템 프로퍼티 값이 OpenJDK를 포함하고 있으면 실행")
    @Test
    @EnabledIfSystemProperty(named = "java.vm.name", matches = ".*OpenJDK.*")
    void openJdk() {
        assertEquals(2, 1 + 1);
    }

    @Test
    void 테스트_메시지() {
        List<Integer> ret = getResults();
        List<Integer> expected = Arrays.asList(1, 2, 3);
        for (int i = 0; i < expected.size(); i++) {
            // 세 번째 인자는 테스트에 실패할 때 표시할 메시지로 사용된다.
            assertEquals(expected.get(i), ret.get(i), "ret[" + i + "]");
        }
    }

    private List<Integer> getResults() {
        return Arrays.asList(1, 2, 3); // 실패하는 거 보려면 값 바꾸기
    }
}
