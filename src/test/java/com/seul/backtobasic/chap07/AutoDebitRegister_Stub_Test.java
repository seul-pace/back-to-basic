package com.seul.backtobasic.chap07;

import com.seul.backtobasic.api.domain.test.AutoDebitRegister;
import com.seul.backtobasic.api.domain.test.StubCardNumberValidator;
import com.seul.backtobasic.api.domain.test.dto.AutoDebitReq;
import com.seul.backtobasic.api.domain.test.dto.RegisterResult;
import com.seul.backtobasic.api.enums.CardValidity;
import com.seul.backtobasic.api.repository.test.StubAutoDebitInfoRepository;
import org.junit.jupiter.api.Test;

import static com.seul.backtobasic.api.enums.CardValidity.INVALID;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AutoDebitRegister_Stub_Test {
    private AutoDebitRegister register;
    private StubCardNumberValidator stubValidator;
    private StubAutoDebitInfoRepository stubRepository;

    @Test
    void setUp() {
        stubValidator = new StubCardNumberValidator("");
        stubRepository = new StubAutoDebitInfoRepository();
        register = new AutoDebitRegister(stubValidator, stubRepository);
    }

    @Test
    void invalidCard() {
        stubValidator.setInvalidNo("111122223333");

        AutoDebitReq req = new AutoDebitReq("user1", "111122223333");
        RegisterResult result = register.register(req);

        assertEquals(INVALID, result.getValidity());
    }

    @Test
    void theftCard() {
        stubValidator.setTheftNo("1234567890123456");

        AutoDebitReq req = new AutoDebitReq("user1", "1234567890123456");
        RegisterResult result = this.register.register(req);

        assertEquals(CardValidity.THEFT, result.getValidity());
    }
}
