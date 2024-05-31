package com.seul.backtobasic.study.lambda;

public interface TravelInfoFilter {
    // 여행 상품을 처리
    // 함수형 인터페이스: 인터페이스에 하나의 메서드만 정의한 것
    public boolean isMatched(TravelInfoVO travelInfo);
}
