package net.schoolvery.schoolveryserver.domain.user.controller;

import lombok.RequiredArgsConstructor;
import net.schoolvery.schoolveryserver.domain.user.config.BaseResponse;
import net.schoolvery.schoolveryserver.domain.user.dto.request.UserCreateDto;
import net.schoolvery.schoolveryserver.domain.user.dto.request.UserUpdateDto;
import net.schoolvery.schoolveryserver.domain.user.dto.response.GetUserResponseDto;
import net.schoolvery.schoolveryserver.domain.user.dto.response.UserResponseDto;
import net.schoolvery.schoolveryserver.domain.user.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    // create user ( success )
    @ResponseBody
    @PostMapping("/sign-up")
    public BaseResponse<UserResponseDto> createUser(@RequestBody UserCreateDto userCreateDto) {
        UserResponseDto userResponseDto = userService.createUser(userCreateDto);

        return new BaseResponse<>(userResponseDto);
    }


    // read user ( succes )
    @ResponseBody
    @GetMapping("")
    public BaseResponse<List<GetUserResponseDto>> getUsers(@RequestParam(required = false) String nickname) {
        List<GetUserResponseDto> getUserResponseDtoList = userService.getUser();

        return new BaseResponse<>(getUserResponseDtoList);
    }


    // update user
    @ResponseBody
    @PostMapping("/{id}")
    public BaseResponse<String> modifyUser(@PathVariable("id") int id, UserUpdateDto userUpdateDto) {
        UserUpdateDto userUpdateDto1 = new UserUpdateDto(id, userUpdateDto.getNickname());
        userService.modifyUser(userUpdateDto1);

        String result = "회원 정보 수정완료";

        return new BaseResponse<>(result);

    }

    //delete user ( success )
    @ResponseBody
    @PostMapping("/delete/{id}")
    public BaseResponse<Integer> withdrawUser(@PathVariable("id") int id) {
        int user = userService.withdraw(id);

        return new BaseResponse<>(user);
    }
}
