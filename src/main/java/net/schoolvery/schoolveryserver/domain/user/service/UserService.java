package net.schoolvery.schoolveryserver.domain.user.service;

import lombok.RequiredArgsConstructor;
import net.schoolvery.schoolveryserver.domain.user.dto.request.UserCreateDto;
import net.schoolvery.schoolveryserver.domain.user.dto.request.UserUpdateDto;
import net.schoolvery.schoolveryserver.domain.user.dto.response.GetUserResponseDto;
import net.schoolvery.schoolveryserver.domain.user.dto.response.UserResponseDto;
import net.schoolvery.schoolveryserver.domain.user.entity.User;
import net.schoolvery.schoolveryserver.domain.user.exception.UserNotFoundException;
import net.schoolvery.schoolveryserver.domain.user.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    // User create
    public UserResponseDto createUser(UserCreateDto userCreateDto) throws UserNotFoundException{

        int id = userRepository.createUser(userCreateDto);
        return new UserResponseDto(id);

    }

    // User update
    public int modifyUser(UserUpdateDto userUpdateDto) {
        int result = userRepository.modifyUserName(userUpdateDto);

        return result;
    }


    // User read
    public List<GetUserResponseDto> getUser() {
        List<GetUserResponseDto> getUserResponseDtoList = userRepository.getUser();

        return getUserResponseDtoList;
    }

    // User delete
    public int withdraw(int id) throws UserNotFoundException {
        int withdrawUserCnt = userRepository.deleteUser(id);

        return withdrawUserCnt;
    }


}
