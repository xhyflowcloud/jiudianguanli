package com.ccnu.xiahongyun.stmanagementsystem.enums;

public enum XHttpStatus {

    HTTP_SUCCESS(200, "连接服务器成功"),
    HTTP_REFUSE(661, "拒绝访问"),
    HTTP_AUTHORITY(662, "无权限访问"),
    HTTP_VERIFICATION(663, "验证失败"),
    HTTP_EXCEPTION(664, "访问异常");

    private Integer code;
    private String message;

    XHttpStatus(Integer code, String message){
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
