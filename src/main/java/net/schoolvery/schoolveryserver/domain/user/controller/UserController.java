package net.schoolvery.schoolveryserver.domain.user.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import net.schoolvery.schoolveryserver.domain.user.config.BaseResponse;
import net.schoolvery.schoolveryserver.domain.user.dto.request.PostUserDto;
import net.schoolvery.schoolveryserver.domain.user.dto.request.UserCreateDto;
import net.schoolvery.schoolveryserver.domain.user.dto.request.UserUpdateDto;
import net.schoolvery.schoolveryserver.domain.user.dto.response.GetUserResponseDto;
import net.schoolvery.schoolveryserver.domain.user.dto.response.UserResponseDto;
import net.schoolvery.schoolveryserver.domain.user.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.Join;
import java.util.List;

// http://localhost:9000/swagger-ui/index.html#/  Swagger

@RestController
@RequestMapping("/api/v1/users")
@Tag(name = "users" , description = "유저 예시 API ")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    // create user ( success )
    @Operation(summary = "Create user", description = "유저 정보 생성")
    @ResponseBody
    @PostMapping("")
    public BaseResponse<UserResponseDto> createUser(@RequestBody UserCreateDto userCreateDto) {
        UserResponseDto userResponseDto = userService.createUser(userCreateDto);

        return new BaseResponse<>(userResponseDto);
    }


    // read user ( succes )
    @Operation(summary = "Read user", description = "유저 정보 읽기")
    @ResponseBody
    @GetMapping("")
    public BaseResponse<List<GetUserResponseDto>> getUsers(@RequestParam(required = false) String nickname) {
        List<GetUserResponseDto> getUserResponseDtoList = userService.getUser();

        return new BaseResponse<>(getUserResponseDtoList);
    }


    // update user
    @Operation(summary = "Update user", description = "유저 정보 업데이트")
    @ResponseBody
    @PutMapping("/{id}")
    public BaseResponse<String> modifyUser(@PathVariable("id") int id, PostUserDto postUserDto) {
        UserUpdateDto userUpdateDto = new UserUpdateDto(id, postUserDto.getNickname());
        userService.modifyUser(userUpdateDto);

        String result = "회원 정보 수정완료";

        return new BaseResponse<>(result);

    }

    //delete user ( success )
    @Operation(summary = "delete user", description = "유저 정보 삭제")
    @ResponseBody
    @DeleteMapping("/{id}")
    public BaseResponse<Integer> withdrawUser(@PathVariable("id") int id) {
        int user = userService.withdraw(id);

        return new BaseResponse<>(user);
    }
}
