package com.seul.backtobasic.chap10.bulk;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("실행 환경이 다르다고 실패하지 않기")
public class BulkLoaderTest {
    // 절대 경로 사용 ㄴㄴ
    // 프로젝트 폴더를 기준으로 상대 경로를 사용한다
    private String bulkFilePath = "src/test/resources/bulk.txt";

    @Disabled // 상대 경로 사용하라는 말만,, 할 거라
    @Test
    void load() {
//        BulkLoader loader = new BulkLoader();
//        loader.load(bulkFilePath);
    }
}
