package com.zh.constant;

import lombok.Getter;

/**
 * @Author zh2683
 */
@Getter
public class ResultMessageConsts {
    @Getter
    public enum ResultMessageEnum {
        success(200, "成功"),
        failure(500, "失败"),
        ;

        private Integer code;
        private String msg;

        ResultMessageEnum(Integer code, String msg) {
            this.code = code;
            this.msg = msg;
        }
    }
}
