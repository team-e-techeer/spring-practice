package net.schoolvery.schoolveryserver.domain.user.entity;

public class User {
    private int userPk;
    private String userName;
    private String userId;
    private String userPassword;

    public User() {
    }

    public User(int userPk, String userName, String userId, String userPassword) {
        this.userPk = userPk;
        this.userName = userName;
        this.userId = userId;
        this.userPassword = userPassword;
    }

    public int getUserPk() {
        return userPk;
    }

    public void setUserPk(int userPk) {
        this.userPk = userPk;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }


};
