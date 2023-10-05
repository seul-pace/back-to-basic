package com.seul.backtobasic.c;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.mockito.BDDMockito.willThrow;
import static org.mockito.Mockito.mock;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class VoidMethodStubTest {

    @Test
    void voidMethodWillThrowTest() {
        List<String> mockList = mock(List.class);
        willThrow(UnsupportedOperationException.class) // 발생할 익셉션 타입 또는 익셉션 객체를 인자로 받는다
                .given(mockList) // 모의 객체 전달 (인자로 전달 받은 모의 객체 자신을 리턴)
                .clear();

        assertThrows(
                UnsupportedOperationException.class,
                () -> mockList.clear()
        );
    }
}
