package com.seul.backtobasic.api.repository.test;

import com.seul.backtobasic.api.entity.test.User;

/**
 * 회원 정보를 저장하고 조회하는 기능을 제공한다.
 */
public interface UserRepository {
    void save(User user);

    User findById(String id);
}
