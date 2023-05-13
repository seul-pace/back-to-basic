package com.seul.backtobasic.api.domain.mapper;

import com.seul.backtobasic.api.domain.dto.GetUserResponse;
import com.seul.backtobasic.api.domain.dto.ModifyUserRequest;
import com.seul.backtobasic.api.entity.User;
import org.mapstruct.*;

@Mapper(
        componentModel = "spring",
        injectionStrategy = InjectionStrategy.FIELD
)
public interface UserMapper {

    @Mappings({
            @Mapping(source = "id", target = "userSeq"),
            @Mapping(source = "name", target = "userName")
    })
    GetUserResponse toResponse(User user);

    @Mappings({
            @Mapping(source = "userSeq", target = "id"),
            @Mapping(source = "userName", target = "name"),
            @Mapping(source = "userAge", target = "age"),
            @Mapping(source = "userAddress", target = "address")
    })
    void updateUser(ModifyUserRequest request, @MappingTarget User user);
}
