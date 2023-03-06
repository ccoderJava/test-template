package com.example.testtemplate.handler;

import com.example.testtemplate.base.CodeEnumMessage;

/**
 * @author: congcong
 * @email: congccoder@gmail.com
 * @date: 2023/3/6 12:45
 */
public enum UserType implements CodeEnumMessage {


    PERSONAL("personal", "个人"),
    MERCHANT("merchant", "商户");


    private final String code;
    private final String message;

    UserType(String code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public static boolean isExists(String code) {
        for (UserType value : UserType.values()) {
            if (value.getCode().equalsIgnoreCase(code)) {
                return true;
            }
        }
        return false;
    }
}
