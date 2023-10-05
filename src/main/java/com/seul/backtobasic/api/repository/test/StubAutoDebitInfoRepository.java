package com.seul.backtobasic.api.repository.test;

import com.seul.backtobasic.api.domain.test.dto.AutoDebitInfo;

public class StubAutoDebitInfoRepository implements AutoDebitInfoRepository {
    @Override
    public void save(AutoDebitInfo info) {

    }

    @Override
    public AutoDebitInfo findOne(String userId) {
        return null;
    }
}
