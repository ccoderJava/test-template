package com.example.testtemplate.request;

/**
 * @author: congcong
 * @email: congccoder@gmail.com
 * @date: 2023/3/6 12:32
 */
public class UserLoginRequest extends AbstractRequest{

    String userType;

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }
}
