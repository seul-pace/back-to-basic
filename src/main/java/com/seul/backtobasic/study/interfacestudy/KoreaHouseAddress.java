package com.seul.backtobasic.study.interfacestudy;

public class KoreaHouseAddress implements HouseAddress{
    private String postCode;
    private String address;
    private String detailAddress;

    public KoreaHouseAddress(String postCode, String address, String detailAddress) {
        this.postCode = postCode;
        this.address = address;
        this.detailAddress = detailAddress;

        System.out.println(postCode + " " + address + " " + detailAddress);
    }

    @Override
    public String getPostCode() {
        return postCode;
    }

    @Override
    public String getAddress() {
        return address;
    }

    @Override
    public String getDetailAddress() {
        return detailAddress;
    }

    @Override
    public String getCountryCode() {
        // Object 클래스를 상속 받았기 때문에 그냥 super 키워드를 사용하면 안 보인다
        // 인터페이스는 객체화 해서 호출할 수도 없다
        // 자바 8에서 추가된 것으로, 인터페이스 이름에 super 키워드를 사용하면 default 메서드를 호출할 수 있다
        return HouseAddress.super.getCountryCode();
    }
}
