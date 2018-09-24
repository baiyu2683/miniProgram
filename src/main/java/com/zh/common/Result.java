package com.zh.common;

import lombok.Data;

/**
 * 接口响应结果
 *
 * @Author zh2683
 */
@Data
public class Result<T> {
    // 结果编码
    private Integer code;
    // 信息
    private String msg;
    // 具体值
    private T value;

}
