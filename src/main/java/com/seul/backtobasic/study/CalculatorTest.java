package com.seul.backtobasic.study;

/*
테스트용
Calculator 내부에 구현 로직과 테스트 코드가 같은 위치에 있어서 분리함
 */
public class CalculatorTest {

    public static void main(String[] args) {
        Calculator cal = new Calculator();

        /*
        아래와 같이 하면 여러 메소드를 동시에 테스트 하고
        => 프로덕션 코드 복잡도가 증가하면 -> main 복잡도 증가 -> 유지 부담
         */
//        System.out.println(cal.add(3, 4));
//        System.out.println(cal.subtract(5, 4));
//        System.out.println(cal.multiply(2, 6));
//        System.out.println(cal.divide(8, 4));

        // 아래와 같이 분리
        add(cal);
        subtract(cal);
        multiply(cal);
        divide(cal);

        // 이렇게 하면 모든 메소드를 테스트
        // 콘솔 값 수동 테스트 필요
        // -> JUnit 사용
    }

    private static void divide(Calculator cal) {
        System.out.println(cal.divide(9, 3));
    }

    private static void multiply(Calculator cal) {
        System.out.println(cal.multiply(9, 3));
    }

    private static void subtract(Calculator cal) {
        System.out.println(cal.subtract(9, 3));
    }

    private static void add(Calculator cal) {
        System.out.println(cal.add(9, 3));
    }
}
