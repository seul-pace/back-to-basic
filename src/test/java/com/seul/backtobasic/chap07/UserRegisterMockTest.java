package com.seul.backtobasic.chap07;

import com.seul.backtobasic.api.domain.test.EmailNotifier;
import com.seul.backtobasic.api.domain.test.UserRegister;
import com.seul.backtobasic.api.domain.test.WeakPasswordChecker;
import com.seul.backtobasic.exception.WeakPasswordException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.BDDMockito;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("모의 객체로 스텁과 스파이 대체")
public class UserRegisterMockTest {
    private UserRegister userRegister;
    // 모의 객체 생성
    private WeakPasswordChecker mockPasswordChecker = Mockito.mock(WeakPasswordChecker.class);
    private MemoryUserRepository fakeRepository = new MemoryUserRepository();
    private EmailNotifier mockEmailNotifier = Mockito.mock(EmailNotifier.class);

    @BeforeEach
    @Test
    void setUp() {
        userRegister = new UserRegister(mockPasswordChecker, fakeRepository, mockEmailNotifier);
    }

    @DisplayName("약한 암호면 가입 실패")
    @Test
    void weakPassword() {
        // 스텁 대신
        BDDMockito
                .given(mockPasswordChecker.checkPasswordWeak("pw")) // "pw" 인자를 사용해서 모의 객체의 checkPasswordWeak 메서드를 호출하면
                .willReturn(true); // 결과로 true를 리턴하라

        assertThrows(WeakPasswordException.class, () -> {
            userRegister.register("id", "pw", "email");
        });
    }

    @DisplayName("회원 가입 시 암호 검사 수행함")
    @Test
    void checkPassword() {
        userRegister.register("id", "pw", "email");

        BDDMockito.then(mockPasswordChecker) // 인자로 전달한 모의 객체의
                .should() // 특정 메서드가 호출됐는지 검증하는데
                .checkPasswordWeak(BDDMockito.anyString()); // 임의의 String 타입 인자를 이용해서 checkPasswordWeak() 메서드 호출 여부를 확인한다
    }

    @DisplayName("가입하면 메일을 전송함")
    @Test
    void whenRegisterThenSendMail() {
        userRegister.register("id", "pw", "email@email.com");

        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        BDDMockito.then(mockEmailNotifier)
                .should().sendRegisterEmail(captor.capture());

        String realEmail = captor.getValue();
        assertEquals("email@email.com", realEmail);
    }
}
