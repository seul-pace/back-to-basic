package com.seul.backtobasic.study.interfacestudy;

// 가장 상위의 인터페이스
public interface Human {
    public int getAge();

    public String getName();

    public String getSex();

    default String getInformation() {
        return "Human";
    }
}
