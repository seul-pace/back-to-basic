package com.seul.backtobasic.study.stream;

public class Person implements Comparable<Person> {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Name : " + name + ", Age : " + age;
    }


    // for distinct
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        // age 속성과 name 속성이 모두 동일해야 같은 값으로 판단한다.
        if (obj instanceof Person) {
            Person p1 = (Person) obj;

            if (p1.getName().equals(this.getName()) && p1.getAge() == this.getAge()) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    // for distinct
    @Override
    public int hashCode() {
        return (name + age).hashCode();
    }

    // for sorted
    @Override
    public int compareTo(Person person) {
        return (name + age).compareTo(person.getName() + person.getAge());
    }
}
