package com.seul.backtobasic.study.interfacestudy;

/**
 * 집 주소 정보를 관리하기 위한 인터페이스
 */
public interface HouseAddress {
    public static final String DefaultCountry = "Korea";

    // 우편번호 리턴
    public String getPostCode();

    // 주소 정보 리턴
    public String getAddress();

    // 상세 정보 리턴
    public String getDetailAddress();

    // 기존 코드에서 국가 코드를 리턴할 일이 생겼다.
    /*
    default: 메서드를 직접 구현하겠다

    static, private은 아무런 키워드나 표시 없이 바로 메서드를 정의하고 구현해도 된다
    -> 인터페이스에 허용되지 않던 메서드 형태라서 컴파일러가 혼란을 일으키지 않는다

    default로 선언되는 메서드는 키워드를 제외하면 인터페이스의 추상 메서드와 일치하므로 컴파일러가 혼동을 일으킨다
     */
    default public String getCountryCode() {
        return HouseAddress.DefaultCountry;
    };

    // 기본 국가 코드를 리턴한다. 자바 9 이상에서 컴파일 된다.
    private String getDefaultCountryCode() {
        return HouseAddress.DefaultCountry;
    }
}
