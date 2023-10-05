package com.seul.backtobasic.c;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class JUnit5ExtensionTest {

    @Mock // 해당 어노테이션을 붙인 필드에 대해 자동으로 모의 객체 생성
    private GameNumGen genMock;
}
