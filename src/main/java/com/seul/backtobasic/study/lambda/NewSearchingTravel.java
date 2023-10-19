package com.seul.backtobasic.study.lambda;

import java.util.ArrayList;
import java.util.List;

public class NewSearchingTravel {
    public static final String COUNTRY_VIETNAM = "vietnam";
    public static final String COUNTRY_PHILIPPINE = "philippine";
    public static final String COUNTRY_THAILAND = "thailand";

    private List<TravelInfoVO> travelInfoList = new ArrayList<>();

    public NewSearchingTravel() {
        initializeProduct();
    }

    private void initializeProduct() {
        TravelInfoVO cebu = new TravelInfoVO();
        cebu.setName("Cebu Travel");
        cebu.setCountry(COUNTRY_PHILIPPINE);
        cebu.setCity("cebu");
        cebu.setDays(5);
        cebu.setNights(3);
        travelInfoList.add(cebu);

        TravelInfoVO boracay = new TravelInfoVO();
        boracay.setName("Boracay Travel");
        boracay.setCountry(COUNTRY_PHILIPPINE);
        boracay.setCity("boracay");
        boracay.setDays(5);
        boracay.setNights(3);
        travelInfoList.add(boracay);

        TravelInfoVO hanoi = new TravelInfoVO();
        hanoi.setName("Hanoi Travel");
        hanoi.setCountry(COUNTRY_VIETNAM);
        hanoi.setCity("hanoi");
        hanoi.setDays(3);
        hanoi.setNights(2);
        travelInfoList.add(hanoi);

        TravelInfoVO danang = new TravelInfoVO();
        danang.setName("Danang Travel");
        danang.setCountry(COUNTRY_VIETNAM);
        danang.setCity("danang");
        danang.setDays(6);
        danang.setNights(4);
        travelInfoList.add(danang);

        TravelInfoVO bankok = new TravelInfoVO();
        bankok.setName("Bankok Travel");
        bankok.setCountry(COUNTRY_THAILAND);
        bankok.setCity("bankok");
        bankok.setDays(5);
        bankok.setNights(3);
        travelInfoList.add(bankok);
    }

    // 외부에서 전달된 조건으로 검색
    public List<TravelInfoVO> searchTravelInfo(TravelInfoFilter searchCondition) {
        List<TravelInfoVO> returnValue = new ArrayList<>();

        for (TravelInfoVO travelInfo : travelInfoList) {
            if (searchCondition.isMatched(travelInfo)) {
                returnValue.add(travelInfo);
            }
        }
        return returnValue;
    }

    public static boolean isVietnam(TravelInfoVO travelInfo) {
        if (travelInfo.getCountry().equals("vietnam")) {
            return true;
        }
        return false;
    }

    /**
     * 새로 작성한 NewSearchingTravel 클래스를 실행하기 위한 예제 코드
     */
    public static void main(String[] args) {
        NewSearchingTravel travelSearch = new NewSearchingTravel();

        // 조회 조건을 외부로 분리
        List<TravelInfoVO> searchTravel = travelSearch.searchTravelInfo(new TravelInfoFilter() {
            @Override
            public boolean isMatched(TravelInfoVO travelInfo) {
                if (travelInfo.getCountry().equals("vietnam")) {
                    return true;
                } else {
                    return false;
                }
            }
        });

        for (TravelInfoVO travelInfo : searchTravel) {
            System.out.println(travelInfo);
        }

//        List<TravelInfoVO> searchTravelByCountry =
//                travelSearch.searchTravelInfo(
//                        (TravelInfoVO travelInfo) -> travelInfo.getCountry().equals("vietnam"));
//
//        for (TravelInfoVO travelInfo : searchTravelByCountry) {
//            System.out.println(travelInfo);
//        }
//
//        List<TravelInfoVO> searchTravelByCity =
//                travelSearch.searchTravelInfo(
//                        (TravelInfoVO travelInfo) -> travelInfo.getCity().equals("hanoi"));
//
//        for (TravelInfoVO travelInfo : searchTravelByCity) {
//            System.out.println(travelInfo);
//        }

        // 위에 작서한 것처럼 람다 표현식을 쓰면 소스 코드 중복성은 해결할 수 있지만,
        // 소스 코드의 재사용성이라는 측면에서는 활용도가 떨어진다.
        // 하여 아래와 같이 하나의 함수로 선언한 것을 활용한다.
        List<TravelInfoVO> searchTravel2 = travelSearch.searchTravelInfo(NewSearchingTravel::isVietnam);
        for (TravelInfoVO t : searchTravel2) {
            System.out.println(t);
        }
    }
}
