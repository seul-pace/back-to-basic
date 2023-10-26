package com.seul.backtobasic.study.stream;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MapIteratorExample {
    // Map 인터페이스의 forEach 메서드 사용 예
    public static void main(String[] args) {
        HashMap<String, Person> map = new HashMap<>();
        map.put("1", new Person("장윤기", 45));
        map.put("2", new Person("장해라", 18));
        map.put("3", new Person("장해윤", 14));
        map.put("4", new Person("장윤기", 45));

        // Iterator를 이용해서 처리
        System.out.println("## Iterator 방식");
        Iterator<String> keys = map.keySet().iterator();
        while (keys.hasNext()) {
            String key = keys.next();
            System.out.println(String.format("Key : %s, Value : %s", key, map.get(key)));
        }

        // Map의 Entry를 이용해서 처리
        System.out.println("## Map Entry 방식");
        for (Map.Entry<String, Person> element : map.entrySet()) {
            System.out.println(String.format("Key : %s, Value : %s", element.getKey(), element.getValue()));
        }

        // Map의 KeySet을 이용해서 처리
        System.out.println("## Key Set 방식");
        for (String key : map.keySet()) {
            System.out.println(String.format("Key : %s, Value : %s", key, map.get(key)));
        }

        // forEach 이용 자바 8 이상
        System.out.println("## forEach 방식");
        map.forEach((key, value) -> System.out.println( String.format("Key : %s, Value : %s", key, value)));
    }
}
