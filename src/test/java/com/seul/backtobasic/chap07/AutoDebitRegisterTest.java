package com.seul.backtobasic.chap07;

import com.seul.backtobasic.api.domain.test.AutoDebitRegister;
import com.seul.backtobasic.api.domain.test.CardNumberValidator;
import com.seul.backtobasic.api.domain.test.dto.AutoDebitReq;
import com.seul.backtobasic.api.domain.test.dto.RegisterResult;
import com.seul.backtobasic.api.repository.test.AutoDebitInfoRepository;
import com.seul.backtobasic.api.repository.test.JpaAutoDebitInfoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static com.seul.backtobasic.api.enums.CardValidity.THEFT;
import static com.seul.backtobasic.api.enums.CardValidity.VALID;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AutoDebitRegisterTest {
    private AutoDebitRegister register;

    @BeforeEach
    void setUp() {
        CardNumberValidator validator = new CardNumberValidator("");
        AutoDebitInfoRepository repository = new JpaAutoDebitInfoRepository();
        register = new AutoDebitRegister(validator, repository);
    }

    @Test
    void validCard() {
        // 업체에서 받은 테스트용 유효한 카드번호 사용
        AutoDebitReq req = new AutoDebitReq("user1", "1234123412341234");
        RegisterResult result = this.register.register(req);
        assertEquals(VALID, result.getValidity());
    }

    @Test
    void theftCard() {
        // 업체에서 받은 도난 테스트용 카드번호 사용
        AutoDebitReq req = new AutoDebitReq("user1", "1234567890123456");
        RegisterResult result = this.register.register(req);
        assertEquals(THEFT, result.getValidity());
    }
}
