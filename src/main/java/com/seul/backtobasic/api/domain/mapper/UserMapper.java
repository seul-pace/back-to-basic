package com.seul.backtobasic.api.domain.mapper;

import com.seul.backtobasic.api.domain.dto.GetUserResponse;
import com.seul.backtobasic.api.entity.User;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

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
}
