package com.seul.backtobasic.study.lambda2;

import java.util.function.IntPredicate;

public class IntPredicateExample {
    // integer형만을 허용하는 Predicate 인터페이스로 정의
    public static boolean isPositive(int i, IntPredicate intPredicate) {
        return intPredicate.test(i);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 1_000_000; i++) {
            IntPredicateExample.isPositive(i, (int integerValue) -> integerValue > 0);
        }
    }
}
