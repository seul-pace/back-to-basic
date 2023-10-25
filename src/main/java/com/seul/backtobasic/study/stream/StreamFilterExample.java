package com.seul.backtobasic.study.stream;

import com.seul.backtobasic.study.lambda.SearchingTravel;
import com.seul.backtobasic.study.lambda.TravelInfo;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * 데이터 필터링
 * 원천 데이터 중 불필요한 데이터 없애고 원하는 데이터 확인
 * 스트림 가장 첫 부분에 위치
 */
public class StreamFilterExample {
    public static void main(String[] args) {
        SearchingTravel searchingTravel = new SearchingTravel();
        List<TravelInfo> travelList = searchingTravel.getTravelInfoList();
        Stream<TravelInfo> travelStream = travelList.stream();

//        travelStream.filter(new Predicate<TravelInfo>() {
//            @Override
//            public boolean test(TravelInfo travelInfo) {
//                return SearchingTravel.COUNTRY_PHILIPPINE.equals(travelInfo.getCountry());
//            }
//        }).forEach(System.out::println);
        // 스트림에서 filter 메서드를 호출하면
        // 스트림에 포함되어 있는 항목들을 filter 메서드의 인자로 전달 받은 Predicate 인터페이스의 test 메서드를 호출해서 일치 여부 확인
        // true면 새로운 스트림에 포함시키고 false면 제외

        // 파이프라인으로 연결했다, 라고 표현함
        travelStream
                .filter((TravelInfo t) -> SearchingTravel.COUNTRY_PHILIPPINE.equals(t.getCountry()))
                .forEach(System.out::println);
    }
}
