package com.seul.backtobasic.a;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;

public class TempDirTest {

    // 테스트 메서드를 실행하기 전에 임시 폴더를 생성하고 그 폴더 정보를 tempFolder 필드에 할당한다
    // 만약 특정 테스트 메서드에서만 사용하고 싶다면 테스트 메서드의 파라미터에 적용한다
    // 테스트 클래스 단위로 하려면 정적 필드에 어노테이션을 적용한다 -> 모든 테스트 메서드 실행이 끝나면 삭제된다
    @TempDir
    File tempFolder;

    @Test
    void fileTest() {
        System.out.println("test");
    }
}
