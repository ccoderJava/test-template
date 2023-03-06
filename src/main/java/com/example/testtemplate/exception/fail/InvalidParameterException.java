package com.example.testtemplate.exception.fail;

import com.example.testtemplate.base.CommonResponseCode;
import com.example.testtemplate.exception.FailException;

/**
 * @author: congcong
 * @email: congccoder@gmail.com
 * @date: 2023/3/6 11:51
 */
public class InvalidParameterException extends FailException {
    public InvalidParameterException(String message) {
        super(CommonResponseCode.INVALID_PARAMETER, message);
    }
}
