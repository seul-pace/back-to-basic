package com.seul.backtobasic.api.domain.test;

/**
 * 암호가 약한지 검사한다.
 */
public interface WeakPasswordChecker {
    boolean checkPasswordWeak(String pw);
}
