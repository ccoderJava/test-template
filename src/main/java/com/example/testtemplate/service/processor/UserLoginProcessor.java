package com.example.testtemplate.service.processor;

import com.example.testtemplate.base.CommonResponseCode;
import com.example.testtemplate.exception.FailException;
import com.example.testtemplate.handler.UserLoginFactory;
import com.example.testtemplate.handler.UserType;
import com.example.testtemplate.request.UserLoginRequest;
import com.example.testtemplate.response.UserLoginResponse;
import com.example.testtemplate.template.AbstractProcessTemplate;
import org.springframework.stereotype.Component;

/**
 * @author: congcong
 * @email: congccoder@gmail.com
 * @date: 2023/3/6 11:59
 */
@Component
public class UserLoginProcessor extends AbstractProcessTemplate<UserLoginRequest, UserLoginResponse> {
    private final UserLoginFactory userLoginFactory;

    public UserLoginProcessor(UserLoginFactory userLoginFactory) {
        this.userLoginFactory = userLoginFactory;
    }

    @Override
    protected String getServiceName() {
        return "用户登录";
    }

    @Override
    protected UserLoginResponse createEmptyResponse() {
        return new UserLoginResponse();
    }

    @Override
    protected void validate(UserLoginRequest request) {
        //参数校验


        //业务校验示例
        if (!UserType.isExists(request.getUserType())) {
            String message = String.format("%s 参数错误", request.getUserType());
            throw new FailException(CommonResponseCode.INVALID_PARAMETER, message);
        }
    }

    @Override
    protected void process(UserLoginRequest request, UserLoginResponse response) {
        //TODO: 2023/3/6 核心业务逻辑
        userLoginFactory.getService(request.getUserType()).login();
        response.success();
    }
}
