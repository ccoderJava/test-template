package com.example.testtemplate.base;

/**
 * @author: congcong
 * @email: congccoder@gmail.com
 * @date: 2023/3/6 11:44
 */
public enum CommonResponseCode implements CodeEnumMessage {

    UN_AUTHENTICATION("UN_AUTHENTICATION", "unAuthentication "),

    /**
     * 参数校验不通过
     */
    INVALID_PARAMETER("INVALID_PARAMETER", "invalid parameter"),

    /**
     * 业务校验失败
     */
    BIZ_CHECK_FAIL("BIZ_CHECK_FAIL", "business check fail"),

    /**
     * 数据不存在
     */
    NOT_EXIST("NOT_EXIST", "data not found"),

    /**
     * 系统错误
     */
    SYSTEM_ERROR("SYSTEM_ERROR", "system error"),

    /**
     * 配置错误
     */
    CONFIG_ERROR("CONFIG_ERROR", "config error"),

    ;

    private final String code;
    private final String message;

    CommonResponseCode(String code, String message) {
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

    public static CommonResponseCode getCode(String code) {
        for (CommonResponseCode type : CommonResponseCode.values()) {
            if (type.getCode().equals(code)) {
                return type;
            }
        }
        return null;
    }
}
