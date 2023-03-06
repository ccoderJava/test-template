package com.example.testtemplate.controller;

import com.example.testtemplate.base.ApplyStatusEnum;
import com.example.testtemplate.request.CreateUserRequest;
import com.example.testtemplate.request.UserLoginRequest;
import com.example.testtemplate.response.CommonResponse;
import com.example.testtemplate.response.UserLoginResponse;
import com.example.testtemplate.service.processor.CreateUserProcessor;
import com.example.testtemplate.service.processor.UserLoginProcessor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: congcong
 * @email: congccoder@gmail.com
 * @date: 2023/3/6 11:57
 */
@RestController
@RequestMapping("/user")
public class UserController {
    private final CreateUserProcessor createUserProcessor;

    private final UserLoginProcessor userLoginProcessor;

    public UserController(CreateUserProcessor createUserProcessor, UserLoginProcessor userLoginProcessor) {
        this.createUserProcessor = createUserProcessor;
        this.userLoginProcessor = userLoginProcessor;
    }

    @PostMapping("/create")
    public CommonResponse createUser(CreateUserRequest request) {
        //上下层使用统一返回结构体
        return createUserProcessor.process(request);
    }

    @PostMapping("/login/{userType}")
    public ResponseEntity<String> userLogin(@PathVariable(value = "userType") String userType, UserLoginRequest userLoginRequest) {
        userLoginRequest.setUserType(userType);
        UserLoginResponse loginResponse = userLoginProcessor.process(userLoginRequest);
        //对于底层统一返回结构体 转化为前端统一格式
        return loginResponse.getApplyStatus().equals(ApplyStatusEnum.SUCCESS) ?
                ResponseEntity.ok(loginResponse.getMessage()) :
                ResponseEntity.badRequest().body(loginResponse.getMessage());
    }


}
