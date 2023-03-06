package com.example.testtemplate.exception;

import com.example.testtemplate.base.CodeEnum;
import com.example.testtemplate.base.CodeEnumMessage;

import java.io.Serializable;

/**
 * @author: congcong
 * @email: congccoder@gmail.com
 * @date: 2023/3/6 11:46
 */
public class FailException extends RuntimeException {
    private final String code;

    public FailException(CodeEnum code, String message) {
        super(message);
        this.code = code.getCode();
    }

    public FailException(CodeEnumMessage message) {
        super(message.getMessage());
        this.code = message.getCode();
    }

    public FailException(String code, String message) {
        super(message);
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
