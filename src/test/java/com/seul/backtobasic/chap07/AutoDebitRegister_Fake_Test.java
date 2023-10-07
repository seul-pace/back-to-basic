package com.seul.backtobasic.chap07;

import com.seul.backtobasic.api.domain.test.AutoDebitRegister;
import com.seul.backtobasic.api.domain.test.StubCardNumberValidator;
import com.seul.backtobasic.api.domain.test.dto.AutoDebitInfo;
import com.seul.backtobasic.api.domain.test.dto.AutoDebitReq;
import com.seul.backtobasic.api.domain.test.dto.RegisterResult;
import com.seul.backtobasic.api.repository.test.MemoryAutoDebitInfoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AutoDebitRegister_Fake_Test {
    private AutoDebitRegister register;
    private StubCardNumberValidator cardNumberValidator;
    private MemoryAutoDebitInfoRepository repository;

    @BeforeEach
    void setUp() {
        cardNumberValidator = new StubCardNumberValidator("");
        repository = new MemoryAutoDebitInfoRepository();
        register = new AutoDebitRegister(cardNumberValidator, repository);
    }

    @Test
    void alreadyRegistered_InfoUpdated() {
        // 미리 하나 저장을 하고
        repository.save(
                new AutoDebitInfo("user1", "111222333444", LocalDateTime.now())
        );

        // 새로 request 생성
        AutoDebitReq req = new AutoDebitReq("user1", "123456789012");
        // 저장 (하면 아마 카드 번호 업데이트 됨)
        RegisterResult result = this.register.register(req);

        AutoDebitInfo saved = repository.findOne("user1");
        assertEquals("123456789012", saved.getCardNumber());
    }

    @Test
    void notYetRegistered_newInfoRegistered() {
        AutoDebitReq req = new AutoDebitReq("user1", "1234123412341234");
        RegisterResult result = this.register.register(req);

        AutoDebitInfo saved = repository.findOne("user1");
        assertEquals("1234123412341234", saved.getCardNumber());
    }
}
