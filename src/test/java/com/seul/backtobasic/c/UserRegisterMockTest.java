package com.seul.backtobasic.c;

import com.seul.backtobasic.api.domain.test.EmailNotifier;
import com.seul.backtobasic.api.domain.test.UserRegister;
import com.seul.backtobasic.chap07.MemoryUserRepository;
import com.seul.backtobasic.chap07.StubWeakPasswordChecker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.mock;

public class UserRegisterMockTest {
    private UserRegister userRegister;
    private EmailNotifier mockEmailNotifier = mock(EmailNotifier.class);
    private StubWeakPasswordChecker stubWeakPasswordChecker = new StubWeakPasswordChecker();
    private MemoryUserRepository memoryUserRepository = new MemoryUserRepository();

    @BeforeEach
    void setUp() {
        this.userRegister = new UserRegister(stubWeakPasswordChecker, memoryUserRepository, mockEmailNotifier);
    }

    @DisplayName("가입하면 메일을 전송함")
    @Test
    void whenRegisterThenSenMail() {
        userRegister.register("id", "pw", "email@email.com");

        // String 타입의 인자를 보관할 수 있는 ArgumentCaptor 생성
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        then(mockEmailNotifier)
                .should().sendRegisterEmail(captor.capture());

        String realEmail = captor.getValue();
        assertEquals("email@email.com", realEmail);
    }
}
