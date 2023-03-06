package com.example.testtemplate.service.processor;

import com.example.testtemplate.request.CreateUserRequest;
import com.example.testtemplate.response.CommonResponse;
import com.example.testtemplate.service.UserService;
import com.example.testtemplate.template.AbstractProcessTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author: congcong
 * @email: congccoder@gmail.com
 * @date: 2023/3/6 11:59
 */
@Component
public class CreateUserProcessor extends AbstractProcessTemplate<CreateUserRequest, CommonResponse> {
    @Autowired
    private UserService userService;

    @Override
    protected String getServiceName() {
        return "创建用户";
    }

    @Override
    protected CommonResponse createEmptyResponse() {
        return new CommonResponse();
    }

    @Override
    protected void validate(CreateUserRequest request) {
        //参数校验
        //幂等校验
        //业务校验
    }

    @Override
    protected void process(CreateUserRequest request, CommonResponse response) {
        //创建用户业务逻辑
        response.success();
    }
}
