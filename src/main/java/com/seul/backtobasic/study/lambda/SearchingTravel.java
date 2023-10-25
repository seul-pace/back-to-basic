package com.seul.backtobasic.study.lambda;

import java.util.ArrayList;
import java.util.List;

public class SearchingTravel {
    public static final String COUNTRY_VIETNAM = "vietnam";
    public static final String COUNTRY_PHILIPPINE = "philippine";
    public static final String COUNTRY_THAILAND = "thailand";

    // 여행 상품 저장
    private List<TravelInfo> travelInfoList = new ArrayList<>();

    public SearchingTravel() {
        initializeProduct();
    }

    public List<TravelInfo> getTravelInfoList() {
        return this.travelInfoList;
    }

    // 데이터를 초기화하여 외부에서 호출하지 못하도록 private으로 선언
    private void initializeProduct() {
        TravelInfo cebu = new TravelInfo();
        cebu.setName("Cebu Travel");
        cebu.setCountry(COUNTRY_PHILIPPINE);
        cebu.setCity("cebu");
        cebu.setDays(5);
        cebu.setNights(3);
        travelInfoList.add(cebu);

        TravelInfo boracay = new TravelInfo();
        boracay.setName("Boracay Travel");
        boracay.setCountry(COUNTRY_PHILIPPINE);
        boracay.setCity("boracay");
        boracay.setDays(5);
        boracay.setNights(3);
        travelInfoList.add(boracay);

        TravelInfo hanoi = new TravelInfo();
        hanoi.setName("Hanoi Travel");
        hanoi.setCountry(COUNTRY_VIETNAM);
        hanoi.setCity("hanoi");
        hanoi.setDays(3);
        hanoi.setNights(2);
        travelInfoList.add(hanoi);

        TravelInfo danang = new TravelInfo();
        danang.setName("Danang Travel");
        danang.setCountry(COUNTRY_VIETNAM);
        danang.setCity("danang");
        danang.setDays(6);
        danang.setNights(4);
        travelInfoList.add(danang);

        TravelInfo bankok = new TravelInfo();
        bankok.setName("Bankok Travel");
        bankok.setCountry(COUNTRY_THAILAND);
        bankok.setCity("bankok");
        bankok.setDays(5);
        bankok.setNights(3);
        travelInfoList.add(bankok);
    }

    // 국가 정보에 기반해서 여행 상품을 조회한다.
    public List<TravelInfo> searchTravelInfo(String country) {
        List<TravelInfo> returnValue = new ArrayList<>();

        for (TravelInfo travelInfo : travelInfoList) {
            if (country.equals(travelInfo.getCountry())) {
                returnValue.add(travelInfo);
            }
        }

        return returnValue;
    }

    /**
     * SearchingTravel 클래스를 사용하는 예제
     */
    public static void main(String[] args) {
        SearchingTravel travelSearch = new SearchingTravel();

        List<TravelInfo> searchList = travelSearch.searchTravelInfo(SearchingTravel.COUNTRY_VIETNAM);

        for (TravelInfo travelInfo : searchList) {
            System.out.println(travelInfo);
        }
    }
}
