package net.schoolvery.schoolveryserver.domain.user.controller;

import net.schoolvery.schoolveryserver.domain.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("")
    public String test(){
        return "root url call";
    }

    @GetMapping("/test")
    public Map<String, String> testMethod() {
        Map<String, String> res = this.userService.getTest();

        return res;
    }

}
