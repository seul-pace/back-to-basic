package com.seul.backtobasic.api.repository.test;

import com.seul.backtobasic.api.domain.test.dto.AutoDebitInfo;

import java.util.HashMap;
import java.util.Map;

/**
 * DB 대신 맵을 이용하여 자동 이체 정보 저장 (영속성을 제공하진 않음)
 */
public class MemoryAutoDebitInfoRepository implements AutoDebitInfoRepository {
    private Map<String, AutoDebitInfo> infos = new HashMap<>();


    @Override
    public void save(AutoDebitInfo info) {
        infos.put(info.getUserId(), info);
    }

    @Override
    public AutoDebitInfo findOne(String userId) {
        return infos.get(userId);
    }
}
