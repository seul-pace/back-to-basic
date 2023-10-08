package com.seul.backtobasic.chap10;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Chap10PracticeTest {

    @DisplayName("변수나 필드를 사용해서 기댓값 표현하지 않기")
    @Test
    void dateFormat() {
        LocalDate date = LocalDate.of(1945, 8, 15);
        String dateStr = format(date);
        // 이렇게 하니까 문자열 연결이 있어 코드가 복잡하고, 실수했을 떼 테스트가 깨져야 실수를 알아챈다
//        assertEquals(date.getYear() + "년 " + date.getMonthValue() + "월 " + date.getDayOfMonth() + "일", dateStr);
        // 이렇게 하면 메서드를 잘못 사용할 일도 없다
        assertEquals("1945년 8월 15일", dateStr);
    }

    private String format(LocalDate date) {
        return "1945년 8월 15일";
    }
}
