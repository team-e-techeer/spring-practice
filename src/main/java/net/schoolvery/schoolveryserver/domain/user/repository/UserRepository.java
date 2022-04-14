package net.schoolvery.schoolveryserver.domain.user.repository;

import net.schoolvery.schoolveryserver.domain.user.entity.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {
    public static List<User> users;

    // 임시 데이터
    static {
        users=new ArrayList<>();
        users.add(new User(1, "한승욱", "seungwook", "1234"));
        users.add(new User(2, "테스트1", "test1", "1234"));
        users.add(new User(3, "테스트3", "test2", "1234"));
    }

    // Select all user
    public List<User> getAllUsers() {
        return users;
    }

    // Select one user by userId
    public User getUserByUserId(String userId){
        return users
                .stream()
                .filter(user -> user.getUserId().equals(userId))
                .findAny()
                .orElse(new User(-1, "", "", ""));
    }

    // Insert User
    public User insertUser(User user){
        users.add(user);
        return user;
    }

    // Modify User
    public void updateUser(String userId, User user) {
        users.stream()
                .filter(curUser -> curUser.getUserId().equals(userId))
                .findAny()
                .orElse(new User(-1, "", "", ""))
                .setUserName(user.getUserName());
    }

    // Delete User
    public void deleteUser(String userId){
        users.removeIf(user -> user.getUserId().equals(userId));
    }

}
