package com.seul.backtobasic.api.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ModifyUserRequest {

    private final int userSeq;

    private final String userName;

    private final int userAge;

    private final String userAddress;

}
