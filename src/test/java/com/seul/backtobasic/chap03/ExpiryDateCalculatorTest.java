package com.seul.backtobasic.chap03;

import com.seul.backtobasic.api.domain.test.ExpiryDateCalculator;
import com.seul.backtobasic.api.domain.test.dto.PayData;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExpiryDateCalculatorTest {

    @Test
    void 만원_납부하면_한달_뒤가_만료일이_됨() {
        assertExpiryDate(
                PayData.builder()
                        .billingDate(LocalDate.of(2019, 3, 1))
                        .payAmount(10_000)
                        .build(),
                LocalDate.of(2019, 4, 1)
        );
        assertExpiryDate(
                PayData.builder()
                        .billingDate(LocalDate.of(2019, 5, 5))
                        .payAmount(10_000)
                        .build(),
                LocalDate.of(2019, 6, 5)
        );
    }

    @Test
    void 납부일과_한달_뒤_일자가_같지_않음() {
        assertExpiryDate(
                PayData.builder()
                        .payAmount(10_000)
                        .billingDate(LocalDate.of(2019, 1, 31))
                        .build(),
                LocalDate.of(2019, 2, 28)
        );
        assertExpiryDate(
                PayData.builder()
                        .billingDate(LocalDate.of(2019, 5, 31))
                        .payAmount(10_000)
                        .build(),
                LocalDate.of(2019, 6, 30)
        );
        assertExpiryDate(
                PayData.builder()
                        .billingDate(LocalDate.of(2020, 1, 31))
                        .payAmount(10_000)
                        .build(),
                LocalDate.of(2020, 2, 29)
        );
    }

    @Test
    void 첫_납부일과_만료일_일자가_다를_때_만원_납부() {
        PayData payData = PayData.builder()
                .firstBillingDate(LocalDate.of(2019, 1, 31))
                .billingDate(LocalDate.of(2019, 2, 28))
                .payAmount(10_000)
                .build();

        assertExpiryDate(payData, LocalDate.of(2019, 3, 31));

        PayData payData2 = PayData.builder()
                .firstBillingDate(LocalDate.of(2019, 1, 30))
                .billingDate(LocalDate.of(2019, 2, 28))
                .payAmount(10_000)
                .build();

        assertExpiryDate(payData2, LocalDate.of(2019, 3, 30));

        PayData payData3 = PayData.builder()
                .firstBillingDate(LocalDate.of(2019, 5, 31))
                .billingDate(LocalDate.of(2019, 6, 30))
                .payAmount(10_000)
                .build();

        assertExpiryDate(payData3, LocalDate.of(2019, 7, 31));
    }

    @Test
    void 이만원_이상_납부하면_비례해서_만료일_계산() {
        assertExpiryDate(
                PayData.builder()
                        .billingDate(LocalDate.of(2019, 3, 1))
                        .payAmount(20_000)
                        .build(),
                LocalDate.of(2019, 5, 1)
        );

        assertExpiryDate(
                PayData.builder()
                        .billingDate(LocalDate.of(2019, 3, 1))
                        .payAmount(30_000)
                        .build(),
                LocalDate.of(2019, 6, 1)
        );
    }

    @Test
    void 첫_납부일과_만료일_일자가_다를_떼_이만원_이상_납부() {
        assertExpiryDate(
                PayData.builder()
                        .firstBillingDate(LocalDate.of(2019, 1, 31))
                        .billingDate(LocalDate.of(2019, 2, 28))
                        .payAmount(20_000)
                        .build(),
                LocalDate.of(2019, 4, 30)
        );

        assertExpiryDate(
                PayData.builder()
                        .firstBillingDate(LocalDate.of(2019, 3, 31))
                        .billingDate(LocalDate.of(2019, 4, 30))
                        .payAmount(30_000)
                        .build(),
                LocalDate.of(2019, 7, 31)
        );
    }

    @Test
    void 십만원을_납부하면_1년_제공() {
        assertExpiryDate(
                PayData.builder()
                        .billingDate(LocalDate.of(2019, 1, 28))
                        .payAmount(100_000)
                        .build(),
                LocalDate.of(2020, 1, 28)
        );
    }

    // 리팩토링 후 주석 처리
//    private void assertExpiryDate(LocalDate billingDate, int payAmount, LocalDate expectedExpiryDate) {
//        ExpiryDateCalculator cal = new ExpiryDateCalculator();
//        LocalDate realExpiryDate = cal.calculateExpiryDate(PayData.builder()
//                .billingDate(billingDate)
//                .payAmount(payAmount)
//                .build());
//        assertEquals(expectedExpiryDate, realExpiryDate);
//    }

    private void assertExpiryDate(PayData payData, LocalDate expectedExpiryDate) {
        ExpiryDateCalculator cal = new ExpiryDateCalculator();
        LocalDate realExpiryDate = cal.calculateExpiryDate(payData);
        assertEquals(expectedExpiryDate, realExpiryDate);
    }
}
