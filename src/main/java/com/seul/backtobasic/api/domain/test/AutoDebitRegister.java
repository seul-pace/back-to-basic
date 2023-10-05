package com.seul.backtobasic.api.domain.test;

import com.seul.backtobasic.api.domain.test.dto.AutoDebitInfo;
import com.seul.backtobasic.api.domain.test.dto.AutoDebitReq;
import com.seul.backtobasic.api.domain.test.dto.RegisterResult;
import com.seul.backtobasic.api.enums.CardValidity;
import com.seul.backtobasic.api.repository.test.AutoDebitInfoRepository;

import java.time.LocalDateTime;

public class AutoDebitRegister {
    private CardNumberValidator validator;
    private AutoDebitInfoRepository repository;

    public AutoDebitRegister(CardNumberValidator validator, AutoDebitInfoRepository repository) {
        this.validator = validator;
        this.repository = repository;
    }

    public RegisterResult register(AutoDebitReq req) {
        // 카드 번호 검증
        CardValidity validity = validator.validate(req.getCardNumber());

        if (validity != CardValidity.VALID) {
            return RegisterResult.error(validity);
        }
        // 자동 이체 정보 조회
        AutoDebitInfo info = repository.findOne(req.getUserId());
        if (info != null) {
            // 카드 번호 변경
            info.changeCardNumber(req.getCardNumber());
        } else {
            // 신규 자동 이체 정보 저장
            AutoDebitInfo newInfo = new AutoDebitInfo(req.getUserId(), req.getCardNumber(), LocalDateTime.now());
            repository.save(newInfo);
        }
        return RegisterResult.success();
    }
}
