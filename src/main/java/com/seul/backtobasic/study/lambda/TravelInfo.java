package com.seul.backtobasic.study.lambda;

public class TravelInfo {

    private String name;
    private String country;
    private String city;
    private int days;
    private int nights;

    public void setName(String name) {
        this.name = name;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public void setNights(int nights) {
        this.nights = nights;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public int getDays() {
        return days;
    }

    public int getNights() {
        return nights;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(name).append(" : ")
                .append(country).append(", ")
                .append(city).append(", ")
                .append(nights).append("박 ")
                .append(days).append("일");
        return builder.toString();
    }
}
