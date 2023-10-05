package com.seul.backtobasic.chap07;

import com.seul.backtobasic.api.domain.test.WeakPasswordChecker;

public class StubWeakPasswordChecker implements WeakPasswordChecker {
    private boolean weak;

    public void setWeak(boolean weak) {
        this.weak = weak;
    }

    @Override
    public boolean checkPasswordWeak(String pw) {
        return weak;
    }
}
