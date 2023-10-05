package com.seul.backtobasic.c;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.mock;

public class GameTest {

    @DisplayName("mockito 행위 검증")
    @Test
    void init() {
        GameNumGen genMock = mock(GameNumGen.class);
        Game game = new Game(genMock);
        game.init(GameLevel.EASY);

        // BDDMockito.then(): 메서드 호출 여부를 검증할 모의 객체 전달
        // BDDMockito.should(): 모의 객체의 메서드가 불려야 한다는 것을 설정, 다음에 실제로 불려야 할 메서드 지정
        // 정확하게 한 번만 호출된 것을 검증하고 싶다면 should() 메서드에 Mockito.only() 인자 전달
        then(genMock).should().generate(GameLevel.EASY);
    }
}
