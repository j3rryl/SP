package com.example.sp1.Models;

public class UserModel {
    private String userId, first_name,last_name,user_email,user_password;

    public UserModel(String userId, String first_name, String last_name, String user_email, String user_password) {
        this.userId = userId;
        this.first_name = first_name;
        this.last_name = last_name;
        this.user_email = user_email;
        this.user_password = user_password;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }
}
