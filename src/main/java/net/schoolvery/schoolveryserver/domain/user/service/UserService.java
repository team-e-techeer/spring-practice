package net.schoolvery.schoolveryserver.domain.user.service;

import lombok.RequiredArgsConstructor;
import net.schoolvery.schoolveryserver.domain.user.dto.request.UserCreateDto;
import net.schoolvery.schoolveryserver.domain.user.dto.response.UserResponseDto;
import net.schoolvery.schoolveryserver.domain.user.entity.User;
import net.schoolvery.schoolveryserver.domain.user.exception.UserNotFoundException;
import net.schoolvery.schoolveryserver.domain.user.repository.UserRopository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.UUID;


@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRopository userRopository;

    // User create
    @Transactional
    public String CreateUser(UserCreateDto userCreateDto) throws UserNotFoundException {
        User user = new User(userCreateDto.getName(), userCreateDto.getNickname(),
                userCreateDto.getPhone(), userCreateDto.getStudent_id(),
                userCreateDto.getSchool(), userCreateDto.getEmail(),
                userCreateDto.getPassword());

        User savedUser = userRopository.save(user);
        return "저장되었습니다.";
    }



}
