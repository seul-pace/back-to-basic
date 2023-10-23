package com.seul.backtobasic.study.lambda2;

public class ThreadExample {

    public static void main(String[] args) {
        /*
        기존 코드
         */
        // 스레드를 생성한다.
//        Thread thread = new Thread(new Runnable() {
//            // run 메서드를 구현한다.
//            @Override
//            public void run() {
//                System.out.println("Hello World");
//            }
//        });

        /*
        람다식으로 표현하기 위한 수정 코드

        1. 익명 클래스 선언 부분 제거
        - 이미 Thread 생성자의 인수는 Runnable 인터페이스가 유일함
        2. 메서드 선언 부분 제거
        - 메서드명, 리턴 타입 제거
        3. 람다 문법으로 정리
        - 파라미터 목록을 메서드의 본문으로 전달한다는 의미로 '->' 기호를 사용한다
         */
//        Thread thread = new Thread(() ->  System.out.println("Hello World"));

        /*
        만약 위의 표현식이 조금 길어지거나 람다 표현식 자체를 재상요할 필요가 있을 때 -> 활용성이 떨어진다
        하여 아래와 같이 분리하여 사용할 수도 있다
         */
//        Runnable runImpl = () -> System.out.println("Hello World");
//        Thread thread = new Thread(runImpl);

        /*
        이것을 한 번만 더 응용하기!
        메서드의 리턴 타입으로 함수형 인터페이스와 람다 표현식을 조합해서 사용할 수 있다
         */
        Runnable runImpl = getRunnable();
        Thread thread = new Thread(runImpl);

        thread.start();
    }

    public static Runnable getRunnable() {
        return () -> System.out.println("Hello world"); // Runnable 객체를 생성해서 리턴

        // 파라미터와 리턴 타입으로만 식별하는데 자바 컴파일러가 이를 인식하고 인터페이스의 구현체로 컴파일 할 수 있는 이유
        // 람다 표현식을 쓸 수 있는 인터페이스는 오직 'public 메서드 하나만 가지고 있는 인터페이스'여야 한다.
        // => 함수형 인터페이스, 함수형 인터페이스에서 제공하는 단 하나의 추상 메서드를 함수형 메서드라고 부른다.
    }
}
