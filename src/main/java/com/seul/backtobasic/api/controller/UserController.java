package com.seul.backtobasic.api.controller;

import com.seul.backtobasic.api.domain.dto.GetUserResponse;
import com.seul.backtobasic.api.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/user")
@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/{userSeq}")
    public ResponseEntity<GetUserResponse> findAll(@PathVariable int userSeq) {
        return ResponseEntity.ok(userService.findUser(userSeq));
    }

}
