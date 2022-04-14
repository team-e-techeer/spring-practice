package net.schoolvery.schoolveryserver.domain.user.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {

    public Map<String, String> getTest() {
        Map<String, String> res = new HashMap<>();
        res.put("test", "hi");

        return res;
    }
}
