package com.seul.backtobasic.chap10.bulk;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ExporterTest {

    @Disabled
    @DisplayName("임시 폴더 경로 사용")
    @Test
    void export() {
        String folder = System.getProperty("java.io.tmpdir"); // 시스템이 제공하는 임시 폴더 경로를 사용한 테스트
//        Exporter exporter = new Exporter(folder);
//        exporter.export("file.txt");
//
//        Path path = Paths.get(folder, "file.txt");
//        assertTrue(Files.exists(path));
    }

    @DisplayName("특정 OS에서만 실행해야 할 때")
    @Test
    @EnabledOnOs({OS.LINUX, OS.MAC})
    void callBash() {
        //
    }

    @DisplayName("이건 사용 못 하게 하는 거")
    @Test
    @DisabledOnOs(OS.WINDOWS)
    void changeMode() {
        //
    }
}
