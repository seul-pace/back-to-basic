package com.seul.backtobasic.c;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.BDDMockito.given;

public class GameGenMockTest {
    // Mockito.mock() : 특정 타입의 모의 객체 생성
    // BDDMockito: 모의 객체에 스텁 구성
    // BDDMockito.given(): 모의 객체의 메서드가 특정 값을 리턴하도록 설정

    @Test
    void mockTest() {
        GameNumGen genMock = mock(GameNumGen.class);
        // 스텁 설정 - getMock.generate(GameLevel.EASY) 메서드가 불리면 "123"을 리턴하라
        given(genMock.generate(GameLevel.EASY)).willReturn("123");

        String num = genMock.generate(GameLevel.EASY);
        assertEquals("123", num);
    }

    @Test
    void mockThrowTest() {
        GameNumGen genMock = mock(GameNumGen.class);
        given(genMock.generate(null)).willThrow(IllegalArgumentException.class);
        // 여기서 타입 대신에 객체를 인자로 받는 willThrow() 메서드를 사용해도 된다 (ex. new IllegalArgumentException())

        assertThrows(IllegalArgumentException.class, () -> {
            genMock.generate(null);
        });
    }
}
