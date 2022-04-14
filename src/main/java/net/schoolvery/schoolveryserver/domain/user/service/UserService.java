package net.schoolvery.schoolveryserver.domain.user.service;

import net.schoolvery.schoolveryserver.domain.user.entity.User;
import net.schoolvery.schoolveryserver.domain.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public List<User> getAllUsers(){
        return userRepository.getAllUsers();
    }

    public User getUserByUserId(String userId){
        return userRepository.getUserByUserId(userId);
    }

    public User registerUser(User user){
        return userRepository.insertUser(user);
    }

    public void modifyUser(String userId, User user){
        userRepository.updateUser(userId, user);
    }

    public void removeUser(String userId){
        userRepository.deleteUser(userId);
    }
}
