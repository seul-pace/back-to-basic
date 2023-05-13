package com.seul.backtobasic.api.domain.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class GetUserResponse {

    private int userSeq;

    private String userName;

    private int age;

    private String address;

    @Builder
    public GetUserResponse(int userSeq, String userName, int age, String address) {
        this.userSeq = userSeq;
        this.userName = userName;
        this.age = age;
        this.address = address;
    }
}
