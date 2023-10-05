package com.seul.backtobasic.api.domain.test;

import com.seul.backtobasic.api.entity.test.User;
import com.seul.backtobasic.api.repository.test.UserRepository;
import com.seul.backtobasic.exception.DupIdException;
import com.seul.backtobasic.exception.WeakPasswordException;

/**
 * 회원 가입에 대한 핵심 로직을 수행한다.
 */
public class UserRegister {
    private WeakPasswordChecker passwordChecker;
    private UserRepository userRepository;
    private EmailNotifier emailNotifier;

    public UserRegister(WeakPasswordChecker weakPasswordChecker, UserRepository userRepository, EmailNotifier emailNotifier) {
        this.passwordChecker = weakPasswordChecker;
        this.userRepository = userRepository;
        this.emailNotifier = emailNotifier;
    }

    public void register(String id, String pw, String email) {
        if (passwordChecker.checkPasswordWeak(pw)) {
            throw new WeakPasswordException();
        }
        User user = userRepository.findById(id);
        if (user != null) {
            throw new DupIdException();
        }
        userRepository.save(new User(id, pw, email));

        emailNotifier.sendRegisterEmail(email);
    }
}
