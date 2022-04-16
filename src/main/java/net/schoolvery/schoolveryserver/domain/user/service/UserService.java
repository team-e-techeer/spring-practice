package net.schoolvery.schoolveryserver.domain.user.service;

import net.schoolvery.schoolveryserver.domain.user.dto.request.UserCreateRequestDto;
import net.schoolvery.schoolveryserver.domain.user.dto.request.UserUpdateRequestDto;
import net.schoolvery.schoolveryserver.domain.user.dto.response.UserResponseDto;
import net.schoolvery.schoolveryserver.domain.user.entity.User;
import net.schoolvery.schoolveryserver.global.common.dto.PageRequestDto;
import net.schoolvery.schoolveryserver.global.common.dto.PageResultDto;

import java.util.List;

public interface UserService {
    default User dtoToEntity (UserCreateRequestDto dto) {
        User entity = User.builder()
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .build();
        return entity;
    }
    default UserResponseDto entityToDto (User entity) {
        UserResponseDto dto = UserResponseDto.builder()
                .firstName(entity.getFirstName())
                .lastName(entity.getLastName())
                .build();
        return dto;
    }

    UserResponseDto create(UserCreateRequestDto dto);
    PageResultDto<UserResponseDto, User> getAllUser(PageRequestDto requestDto);
    UserResponseDto getUser(Long id);
    void deleteUser(Long id);
    UserResponseDto updateUser(Long id, UserUpdateRequestDto dto);

}
