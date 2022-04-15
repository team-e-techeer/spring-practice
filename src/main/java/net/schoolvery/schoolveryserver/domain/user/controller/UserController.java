package net.schoolvery.schoolveryserver.domain.user.controller;

import net.schoolvery.schoolveryserver.domain.user.dto.response.UserResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @GetMapping()
    public ResponseEntity<UserResponseDto> getHello() {
        UserResponseDto response = UserResponseDto.builder()
                .result("Hello")
                .build();

        return ResponseEntity.ok()
                .body(response);
    }
}
