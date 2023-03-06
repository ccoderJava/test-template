package com.example.testtemplate.handler.strategy;

import com.example.testtemplate.handler.UserLogin;
import com.example.testtemplate.handler.UserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author: congcong
 * @email: congccoder@gmail.com
 * @date: 2023/3/6 12:50
 */
@Component
public class PersonalUserLoginImpl implements UserLogin {
    protected Logger log = LoggerFactory.getLogger(getClass());

    @Override
    public void login() {
        log.info("{}-正在登录", UserType.PERSONAL.getMessage());
    }

    @Override
    public String getServiceCode() {
        return UserType.PERSONAL.getCode();
    }
}
