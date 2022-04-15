package net.schoolvery.schoolveryserver.domain.user.controller;

import lombok.RequiredArgsConstructor;
import net.schoolvery.schoolveryserver.domain.user.dto.UserDto;
import net.schoolvery.schoolveryserver.domain.user.entity.User;
import net.schoolvery.schoolveryserver.domain.user.service.UserService;
import org.apache.coyote.Response;
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
    public ResponseEntity<UserDto> create (@Valid @RequestBody UserDto dto) {
        User entity = userService.create(dto);
        return ResponseEntity.created(
                WebMvcLinkBuilder
                .linkTo(UserController.class)
                .slash(entity.getId())
                .toUri()
        )
        .body(dto);
    }

    @GetMapping
    public ResponseEntity<List<User>> userList() {
        List<User> dtoList = userService.getAllUser();
        return ResponseEntity.ok()
                .body(dtoList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Long id) {
        UserDto dto = userService.getUser(id);
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
    public ResponseEntity<UserDto> updateUser(@PathVariable Long id, @RequestBody UserDto  dto) {
        UserDto updatedDto = userService.updateUser(id, dto);
        return ResponseEntity.ok()
                .body(updatedDto);
    }

}
