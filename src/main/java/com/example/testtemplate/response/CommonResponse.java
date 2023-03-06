package com.example.testtemplate.response;

import com.example.testtemplate.base.ApplyStatusEnum;
import com.example.testtemplate.base.CodeEnum;
import com.example.testtemplate.base.CodeEnumMessage;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

/**
 * @author: congcong
 * @email: congccoder@gmail.com
 * @date: 2023/3/6 11:40
 */
public class CommonResponse implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 是否成功
     */
    protected ApplyStatusEnum applyStatus;

    /**
     * 返回码
     */
    protected String code;

    /**
     * 返回信息
     */
    protected String message;

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }


    public CommonResponse code(String code) {
        this.code = code;
        return this;
    }

    public CommonResponse message(String message) {
        this.message = message;
        return this;
    }

    public CommonResponse codeMessage(CodeEnumMessage codeMessage) {
        this.message = codeMessage.getMessage();
        this.code = codeMessage.getCode();
        return this;
    }

    public CommonResponse codeMessage(CodeEnum codeEnum, String message) {
        this.code = codeEnum.getCode();
        this.message = message;
        return this;
    }

    public CommonResponse success() {
        this.applyStatus = ApplyStatusEnum.SUCCESS;
        return this;
    }

    public CommonResponse success(CodeEnumMessage codeMessage) {
        return success().codeMessage(codeMessage);
    }

    public CommonResponse success(CodeEnum code, String message) {
        return success().codeMessage(code, message);
    }

    public CommonResponse success(String code, String message) {
        return success().code(code).message(message);
    }

    public CommonResponse success(String message) {
        return success().message(message);
    }


    protected CommonResponse fail() {
        this.applyStatus = ApplyStatusEnum.FAIL;
        return this;
    }

    public CommonResponse fail(CodeEnumMessage codeMessage) {
        return fail().codeMessage(codeMessage);
    }

    public CommonResponse fail(CodeEnum code, String message) {
        return fail().codeMessage(code, message);
    }

    public CommonResponse fail(String code, String message) {
        return fail().code(code).message(message);
    }


    protected CommonResponse error() {
        this.applyStatus = ApplyStatusEnum.ERROR;
        return this;
    }

    public CommonResponse error(CodeEnumMessage codeMessage) {
        return error().codeMessage(codeMessage);
    }

    public CommonResponse error(CodeEnum code, String message) {
        return error().codeMessage(code, message);
    }

    public CommonResponse error(String code, String message) {
        return error().code(code).message(message);
    }


    public static CommonResponse buildSuccess() {
        return new CommonResponse().success();
    }

    public static CommonResponse buildSuccess(CodeEnumMessage codeMessage) {
        return new CommonResponse().success(codeMessage);
    }

    public static CommonResponse buildSuccess(CodeEnum code, String message) {
        return new CommonResponse().success(code, message);
    }

    public static CommonResponse buildSuccess(String code, String message) {
        return new CommonResponse().success(code, message);
    }

    public static CommonResponse buildSuccess(String message) {
        return new CommonResponse().success(message);
    }


    public static CommonResponse buildFail(CodeEnumMessage codeMessage) {
        return new CommonResponse().fail(codeMessage);
    }

    public static CommonResponse buildFail(CodeEnum code, String message) {
        return new CommonResponse().fail(code, message);
    }

    public static CommonResponse buildFail(String code, String message) {
        return new CommonResponse().fail(code, message);
    }

    public static CommonResponse buildError(CodeEnumMessage codeMessage) {
        return new CommonResponse().error(codeMessage);
    }

    public static CommonResponse buildError(CodeEnum code, String message) {
        return new CommonResponse().error(code, message);
    }

    public static CommonResponse buildError(String code, String message) {
        return new CommonResponse().error(code, message);
    }

    public ApplyStatusEnum getApplyStatus() {
        return applyStatus;
    }

    public void setApplyStatus(ApplyStatusEnum applyStatus) {
        this.applyStatus = applyStatus;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
