package com.example.testtemplate.handler;

import com.example.testtemplate.template.AbstractCodeServiceFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author: congcong
 * @email: congccoder@gmail.com
 * @date: 2023/3/6 12:47
 */
@Component
public class UserLoginFactory extends AbstractCodeServiceFactory<UserLogin> {
    public UserLoginFactory(List<UserLogin> userLogins) {
        super(userLogins);
    }

    @Override
    protected String getFactoryName() {
        return "用户登录工厂";
    }
}
