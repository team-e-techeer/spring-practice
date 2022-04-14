package net.schoolvery.schoolveryserver.domain.user.controller;

import net.schoolvery.schoolveryserver.domain.user.dto.request.UserCreateDto;
import net.schoolvery.schoolveryserver.domain.user.entity.User;
import net.schoolvery.schoolveryserver.domain.user.repository.UserRopository;
import net.schoolvery.schoolveryserver.domain.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;
    private final UserRopository userRopository;

    @Autowired
    public UserController(UserService userService, UserRopository userRopository) {
        this.userService = userService;
        this.userRopository = userRopository;
    }

    // Create
    @ResponseBody
    @PostMapping("/signup")
    public ResponseEntity<Void> CreateUser(@RequestBody UserCreateDto userCreateDto) {

    }


    // Read
    @ResponseBody
    @GetMapping("")
    public List<User> ReadUser(UserService userService) {

        return userRopository.findAll();

    }

    // Update
    @ResponseBody
    @PatchMapping("/{user-id}")
    public String UpdateUser(@PathVariable("user-id") UUID userId) {

        return "수정되었습니다.";
    }


    //Delete
    @ResponseBody
    @DeleteMapping("/{user-id}")
    public String DeleteUser(@PathVariable("user-id") UUID userId) {


        return "삭제되었습니다.";

    }



}
