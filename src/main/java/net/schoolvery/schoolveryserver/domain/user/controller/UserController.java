package net.schoolvery.schoolveryserver.domain.user.controller;

import lombok.RequiredArgsConstructor;
import net.schoolvery.schoolveryserver.domain.user.dto.request.UserCreateRequestDto;
import net.schoolvery.schoolveryserver.domain.user.dto.request.UserUpdateRequestDto;
import net.schoolvery.schoolveryserver.domain.user.dto.response.UserResponseDto;
import net.schoolvery.schoolveryserver.domain.user.entity.User;
import net.schoolvery.schoolveryserver.domain.user.service.UserService;
import net.schoolvery.schoolveryserver.global.common.dto.PageRequestDto;
import net.schoolvery.schoolveryserver.global.common.dto.PageResultDto;
import org.apache.coyote.Response;
import org.springframework.data.querydsl.QPageRequest;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "api/v1/users")
@RequiredArgsConstructor
public class UserController<c> {
    private final UserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public ResponseEntity<UserResponseDto> create (@Valid @RequestBody UserCreateRequestDto dto) {
        UserResponseDto result = userService.create(dto);
        return ResponseEntity.created(
                WebMvcLinkBuilder
                .linkTo(UserController.class)
                .slash(result.getFirstName())
                .toUri()
        )
        .body(result);
    }

    @GetMapping
    public ResponseEntity<PageResultDto> userList(PageRequestDto pageRequestDto) {
//        List<UserResponseDto> dtoList = userService.getAllUser();
//        return ResponseEntity.ok()
//                .body(dtoList);
        PageResultDto result = userService.getAllUser(pageRequestDto);
        return ResponseEntity.ok()
                .body(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> getUserById(@PathVariable Long id) {
        UserResponseDto dto = userService.getUser(id);
        return ResponseEntity.ok()
                .body(dto);
    }
//
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.ok()
                .body(null);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponseDto> updateUser(@PathVariable Long id, @RequestBody UserUpdateRequestDto  dto) {
        UserResponseDto updatedDto = userService.updateUser(id, dto);
        return ResponseEntity.ok()
                .body(updatedDto);
    }

}
