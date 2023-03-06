package com.example.testtemplate.exception.fail;

import com.example.testtemplate.base.CodeEnumMessage;
import com.example.testtemplate.base.CommonResponseCode;
import com.example.testtemplate.exception.FailException;

/**
 * @author: congcong
 * @email: congccoder@gmail.com
 * @date: 2023/3/6 11:52
 */
public class UnAuthenticationException extends FailException {

    public UnAuthenticationException(CodeEnumMessage message) {
        super(CommonResponseCode.UN_AUTHENTICATION);
    }
}
