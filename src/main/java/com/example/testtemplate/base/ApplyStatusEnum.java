package com.example.testtemplate.base;

/**
 * @author: congcong
 * @email: congccoder@gmail.com
 * @date: 2023/3/6 11:43
 */
public enum ApplyStatusEnum implements CodeEnumMessage {

    /**
     * 申请成功
     */
    SUCCESS("S", "申请成功"),

    /**
     * 申请失败
     */
    FAIL("F", "申请失败"),

    /**
     * 申请异常，结果不确定
     */
    ERROR("E", "申请异常"),

    ;

    public static ApplyStatusEnum getCode(String code) {
        for (ApplyStatusEnum type : ApplyStatusEnum.values()) {
            if (type.getCode().equals(code)) {
                return type;
            }
        }
        return null;
    }


    private final String code;
    private final String message;

    ApplyStatusEnum(String code, String message) {
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
}
