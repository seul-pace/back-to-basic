package com.seul.backtobasic.study.interfacestudy;

public class Worker implements Female, Male {
    public static final String MALE = "male";
    public static final String FEMALE = "female";

    private int age;
    private String name;
    private String sex;

    public Worker(String name, int age, String sex) {
        this.age = age;
        this.name = name;
        this.sex = sex;
    }

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getInformation() {
        return "Name : " + name + " is " + age + " years old";
    }

    // Worker 클래스에서 중복된 default 메서드를 정의한다
    @Override
    public String getSex() {
        String returnValue = null;

        if (sex != null && "male".equals(sex)) {
//            returnValue = Worker.MALE;
            // 인터페이스의 default 메서드 호출, static 메서드를 부르는 것과 유사함
            // 이렇게 부르려면 해당 인터페이스가 클래스 선언 시 implements 키워드에 추가되어야 한다
            returnValue = Male.super.getSex();
        } else if (sex != null && "female".equals(sex)) {
//            returnValue = Worker.FEMALE;
            returnValue = Female.super.getSex();
        } else {
            returnValue = "N/A";
        }
        return returnValue;
    }

    // abstract 클래스로 변경하고 + Worker에서 Male을 extends 하면
    // Worker 클래스에 getSex 메서드를 오버라이드 하지 않아도 컴파일 에러가 발생하지 않는다
    // 클래스의 public 메서드와 인터페이스의 default 메서드가 동일한데..
    // 이유: 자바의 기본적인 클래스와 인터페이스 규칙을 훼손하지 않음

    // 1. 클래스가 인터페이스에 대해 우선순위를 가진다.
    // 2. 상속 관계에 있을 경우 하위 클래스/인터페이스가 상위 클래스/인터페이스보다 우선 호출된다.
    // 3. 위의 두 가지를 제외하고 컴파일 에러 가능성 있음, 호출하고자 하는 것을 명확하게 지정
}
