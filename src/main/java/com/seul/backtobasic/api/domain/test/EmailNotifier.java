package com.seul.backtobasic.api.domain.test;

/**
 * 이메일 발송 기능을 제공한다.
 */
public interface EmailNotifier {
    void sendRegisterEmail(String email);
}
