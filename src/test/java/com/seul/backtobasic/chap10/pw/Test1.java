package com.seul.backtobasic.chap10.pw;

import com.seul.backtobasic.api.domain.test.EmailNotifier;
import com.seul.backtobasic.api.domain.test.UserRegister;
import com.seul.backtobasic.api.domain.test.WeakPasswordChecker;
import com.seul.backtobasic.chap07.MemoryUserRepository;
import com.seul.backtobasic.chap07.SpyEmailNotifier;
import com.seul.backtobasic.exception.WeakPasswordException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("정확하게 일치하는 값으로 모의 객체 설정하지 않기")
public class Test1 {

    private UserRegister userRegister;
    private WeakPasswordChecker mockPasswordChecker = Mockito.mock(WeakPasswordChecker.class);
    private MemoryUserRepository fakeRepository = new MemoryUserRepository();
    private EmailNotifier spyEmailNotifier = new SpyEmailNotifier();

    @BeforeEach
    @Test
    void setUp() {
        userRegister = new UserRegister(mockPasswordChecker, fakeRepository, spyEmailNotifier);
    }

    @DisplayName("약한 암호면 가입 실패")
    @Test
    void weakPassword() {

//        BDDMockito.given(mockPasswordChecker.checkPasswordWeak("pw")).willReturn(true);
        // 이와 같이 작성하면 pw -> pwa 로 변경 시 오류가 발생한다
        // 어차피 코드는 약한 암호를 확인하는 테스트 코드가 아니다
        // 즉 모의 객체는 임의의 문자열에 대해 true를 리턴해도 테스트 의도에 문제가 되지 않는다

        BDDMockito.given(mockPasswordChecker.checkPasswordWeak(Mockito.anyString()))
                .willReturn(true);

        assertThrows(WeakPasswordException.class, () -> {
            userRegister.register("id", "pw", "email");
        });
    }
}
