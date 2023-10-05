package com.seul.backtobasic.api.repository.test;

import com.seul.backtobasic.api.domain.test.dto.AutoDebitInfo;

/**
 * 테스트 용
 * 자동 이체 정보의 DB 연동 처리
 */
public interface AutoDebitInfoRepository {
    void save(AutoDebitInfo info);
    AutoDebitInfo findOne(String userId);
}
