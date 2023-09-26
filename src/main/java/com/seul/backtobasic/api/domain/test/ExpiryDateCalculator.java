package com.seul.backtobasic.api.domain.test;

import com.seul.backtobasic.api.domain.test.dto.PayData;

import java.time.LocalDate;
import java.time.YearMonth;

public class ExpiryDateCalculator {
//    public LocalDate calculateExpiryDate(LocalDate billingDate, int payAmount) {
//        return billingDate.plusMonths(1);
//    }

    public LocalDate calculateExpiryDate(PayData payData) {
        int addedMonths = payData.getPayAmount() == 100_000 ? 12 : payData.getPayAmount() / 10_000;

        if (payData.getFirstBillingDate() != null) {
            return expiryDateUsingFirstBillingDate(payData, addedMonths);
        } else {
            return payData.getBillingDate().plusMonths(addedMonths);
        }
    }

    private LocalDate expiryDateUsingFirstBillingDate(PayData payData, int addedMonths) {
        LocalDate candidateExp = payData.getBillingDate().plusMonths(addedMonths);

        // 첫 납부일의 일자와 후보 만료일의 일자가 다르면 첫 납부일의 일자를 후보 만료일의 일자로 사용
        if (isSameDayOfMonth(payData.getFirstBillingDate(), candidateExp)) {
            // 후보 만료일이 속한 월의 마지막 일자
            final int dayLenOfCandiMon = lastDayOfMonth(candidateExp);
            // 첫 납부일의 일자
            final int dayOfFirstBilling = payData.getFirstBillingDate().getDayOfMonth();

            // 후보 만료일이 포함된 달의 마지막 날 < 첫 납부일의 일자 => 후보 만료일을 그 달의 마지막 날로 조
            if (dayLenOfCandiMon < dayOfFirstBilling) {
                return candidateExp.withDayOfMonth(dayLenOfCandiMon);
            }
            return candidateExp.withDayOfMonth(dayOfFirstBilling);
        } else {
            return candidateExp;
        }
    }

    private boolean isSameDayOfMonth(LocalDate date1, LocalDate date2) {
        return date1.getDayOfMonth() != date2.getDayOfMonth();
    }

    private int lastDayOfMonth(LocalDate date) {
        return YearMonth.from(date).lengthOfMonth();
    }
}
