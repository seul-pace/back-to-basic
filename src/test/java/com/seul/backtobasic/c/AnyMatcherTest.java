package com.seul.backtobasic.c;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

@DisplayName("mockito 인자 매칭 처리")
public class AnyMatcherTest {

    @Test
    void anyMatchTest() {
        GameNumGen genMock = mock(GameNumGen.class);
        // ArgumentMatchers.any() - 모든 값에 일치하도록 스텁 설정
        // Mockito.any(), BDDMockito.any()를 사용해도 된다 (상속 중...)
        given(genMock.generate(any())).willReturn("456");

        String num = genMock.generate(GameLevel.EASY);
        assertEquals("456", num);

        String num2 = genMock.generate(GameLevel.NORMAL);
        assertEquals("456", num2);
    }

    @Test
    void mixAnyAndEq() {
        List<String> mockList = mock(List.class);

        given(mockList.set(anyInt(), eq("123"))).willReturn("456");
        // 첫 번째 인자: ArgumentMatcher.anyInt()를 통해 int 형이면 어떤 값이든
        // 두 번째 인자: ArguemntMatcher.eq()를 통해 해당 값에 일치하는 값

        String old = mockList.set(5, "123");
        assertEquals("456", old);
    }
}
