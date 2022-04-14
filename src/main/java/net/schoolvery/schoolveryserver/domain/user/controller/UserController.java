package net.schoolvery.schoolveryserver.domain.user.controller;

import net.schoolvery.schoolveryserver.domain.user.entity.User;
import net.schoolvery.schoolveryserver.domain.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/{userid}")
    public User getUserByUserId(@PathVariable String userid){
        return userService.getUserByUserId(userid);
    }

    @PostMapping("")
    public User registerUser(@RequestBody User user){
        return userService.registerUser(user);
    }

    @PutMapping("/{userid}")
    public void modifyUser(@PathVariable String userid, @RequestBody User user){
        userService.modifyUser(userid, user);
    }

    @DeleteMapping("/{userid}")
    public void removeUser(@PathVariable String userid){
        userService.removeUser(userid);
    }

}
