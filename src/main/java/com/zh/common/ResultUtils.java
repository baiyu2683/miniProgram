package com.zh.common;

import com.zh.constant.ResultMessageConsts;

/**
 * 构建接口返回信息
 *
 * @Author zh2683
 */
public class ResultUtils {

    private static  <T> Result<T> newResult(ResultMessageConsts.ResultMessageEnum resultMessageEnum) {
        Result<T> result = new Result<>();
        result.setCode(resultMessageEnum.getCode());
        result.setMsg(resultMessageEnum.getMsg());
        return result;
    }

    public static  <T> Result<T> success() {
        return newResult(ResultMessageConsts.ResultMessageEnum.success);
    }

    public static <T> Result<T> success(String msg) {
        Result<T> result = success();
        result.setMsg(msg);
        return result;
    }

    public static <T> Result<T> success(String msg, T value) {
        Result<T> result = success(msg);
        result.setValue(value);
        return result;
    }

    public static <T> Result<T> failure() {
        return newResult(ResultMessageConsts.ResultMessageEnum.failure);
    }

    public static <T> Result<T> failure(String msg) {
        Result<T> result = failure();
        result.setMsg(msg);
        return result;
    }

    public static <T> Result<T> failure(String msg, T value) {
        Result<T> result = failure(msg);
        result.setValue(value);
        return result;
    }

}
