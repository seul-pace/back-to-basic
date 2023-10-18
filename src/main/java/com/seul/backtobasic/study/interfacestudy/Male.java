package com.seul.backtobasic.study.interfacestudy;

public interface Male extends Human {
    public static String SEX = "male";

    // 상위 인터페이스 메서드를 default 메서드로 구현하였다.
    @Override
    default String getSex() {
        return Male.SEX;
    }
}