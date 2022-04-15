package net.schoolvery.schoolveryserver.domain.user.service;

import net.schoolvery.schoolveryserver.domain.user.dto.UserDto;
import net.schoolvery.schoolveryserver.domain.user.entity.User;

import java.util.List;

public interface UserService {
    default User dtoToEntity (UserDto dto) {
        User entity = User.builder()
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .build();
        return entity;
    }
    default UserDto entityToDto (User entity) {
        UserDto dto = UserDto.builder()
                .firstName(entity.getFirstName())
                .lastName(entity.getLastName())
                .build();
        return dto;
    }

    User create(UserDto dto);
    List<User> getAllUser();
    UserDto getUser(Long id);
    void deleteUser(Long id);
    UserDto updateUser(Long id, UserDto dto);

}
