package com.seul.backtobasic.study.lambda2;

import java.util.function.Predicate;

public class PredicateExample {
    public static boolean isValid(String name, Predicate<String> predicate) {
        return predicate.test(name);
    }

    public static void main(String[] args) {
        boolean valid = PredicateExample.isValid("", (String name) -> !name.isEmpty());
        System.out.println(valid);
    }
}
