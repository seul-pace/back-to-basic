package com.seul.backtobasic.api.controller;

import com.seul.backtobasic.api.domain.dto.GetUserResponse;
import com.seul.backtobasic.api.domain.dto.ModifyUserRequest;
import com.seul.backtobasic.api.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/user")
@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/{userSeq}")
    public ResponseEntity<GetUserResponse> findAll(@PathVariable int userSeq) {
        return ResponseEntity.ok(userService.findUser(userSeq));
    }

    @PutMapping("")
    public void modify(ModifyUserRequest request) {
        userService.modifyUser(request);
    }

}
