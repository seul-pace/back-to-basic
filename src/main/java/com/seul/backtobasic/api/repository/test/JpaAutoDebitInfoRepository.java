package com.seul.backtobasic.api.repository.test;

import com.seul.backtobasic.api.domain.test.dto.AutoDebitInfo;

/**
 * 테스트용
 * 자동 이체 정보를 DB로 저장 (비어있음)
 */
public class JpaAutoDebitInfoRepository implements AutoDebitInfoRepository{
    @Override
    public void save(AutoDebitInfo info) {

    }

    @Override
    public AutoDebitInfo findOne(String userId) {
        return null;
    }
}
