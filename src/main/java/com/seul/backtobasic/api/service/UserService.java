package com.seul.backtobasic.api.service;

import com.seul.backtobasic.api.domain.dto.GetUserResponse;
import com.seul.backtobasic.api.domain.mapper.UserMapper;
import com.seul.backtobasic.api.entity.User;
import com.seul.backtobasic.api.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private final UserMapper userMapper;

    public GetUserResponse findUser(int userSeq) {
        Optional<User> optionalUser = userRepository.findById(userSeq);

        if (optionalUser.isEmpty()) {
            throw new RuntimeException("회원이 없습니다.");
        }

        User user = optionalUser.get();

        // 매핑 작업 필요

        return userMapper.toResponse(user);
    }
}
