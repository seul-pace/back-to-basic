package com.seul.backtobasic.study.methodReference;

import java.util.ArrayList;
import java.util.List;

public class MethodReferenceExample {
    public static MethodReferenceExample of() {
        return new MethodReferenceExample();
    }

    // 데이터 처리 로직 영역
    public static void executeMethod(String entity) {
        if (entity != null && !"".equals(entity)) {
            System.out.println("Contents : " + entity);
            System.out.println("Length : " + entity.length());
        }
    }

    // 대문자로 변경하는 코드
    public void toUpperCase(String entity) {
        System.out.println(entity.toUpperCase());
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("a");
        list.add("b");
        list.add("c");

        // 정적 메소드 참조 (클래스명::메서드명)
        list.stream()
                .forEach(MethodReferenceExample::executeMethod);

        // 한정적 메소드 참조
        list.stream()
                .forEach(MethodReferenceExample.of()::toUpperCase);
        // 참조하는 메서드가 특정 객체의 변수로 제한된다.
        //

        // 비한정적 메소드 참조
        list.stream()
                .map(String::toUpperCase)
                .forEach(System.out::println);
        // 비한정적 메소드: 특정한 객체를 참조하기 위한 변수를 지정하지 않는다.
        // 주로 매핑과 필터에 사용됨
    }
}
