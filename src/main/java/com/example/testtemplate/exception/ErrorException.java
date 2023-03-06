package com.example.testtemplate.exception;

import com.example.testtemplate.base.CodeEnum;
import com.example.testtemplate.base.CodeEnumMessage;
import com.example.testtemplate.base.CommonResponseCode;

/**
 * @author: congcong
 * @email: congccoder@gmail.com
 * @date: 2023/3/6 11:45
 */
public class ErrorException extends RuntimeException {

    private final String code;

    public ErrorException(String message) {
        this(message, CommonResponseCode.SYSTEM_ERROR);
    }

    public ErrorException(String message, String code) {
        super(message);
        this.code = code;
    }

    public ErrorException(String message, CodeEnum code) {
        super(message);
        this.code = code.getCode();
    }

    public ErrorException(CodeEnumMessage code) {
        super(code.getMessage());
        this.code = code.getCode();
    }

    public ErrorException(Throwable e) {
        this(CommonResponseCode.SYSTEM_ERROR, e);
    }

    public ErrorException(String message, Throwable e) {
        this(CommonResponseCode.SYSTEM_ERROR, message, e);
    }

    public ErrorException(String code, String message, Throwable e) {
        super(message, e);
        this.code = code;
    }

    public ErrorException(CodeEnum code, String message, Throwable e) {
        super(message, e);
        this.code = code.getCode();
    }

    public ErrorException(CodeEnumMessage code, Throwable e) {
        super(code.getMessage(), e);
        this.code = code.getCode();
    }

    public String getCode() {
        return code;
    }
}
