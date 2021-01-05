package com.antoniopeng.hello.ssm.common;

import java.io.Serializable;

/**
 * 自定义返回结果
 *
 * @author Antonio
 */
public class ResponseResult implements Serializable {
    public static final int STATUS_SUCCESS = 200;
    public static final int STATUS_FAIL = 500;

    private int status;
    private String message;
    private Object data;

    public static ResponseResult success() {
        return ResponseResult.customizeResult(STATUS_SUCCESS, "请求成功", null);
    }

    public static ResponseResult success(String message) {
        return ResponseResult.customizeResult(STATUS_SUCCESS, message, null);
    }

    public static ResponseResult success(String message, Object data) {
        return ResponseResult.customizeResult(STATUS_SUCCESS, message, data);
    }

    public static ResponseResult fail() {
        return ResponseResult.customizeResult(STATUS_FAIL, "请求失败", null);
    }

    public static ResponseResult fail(String message) {
        return ResponseResult.customizeResult(STATUS_FAIL, message, null);
    }

    public static ResponseResult fail(int status, String message) {
        return ResponseResult.customizeResult(status, message, null);
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    private static ResponseResult customizeResult(int status, String message, Object data) {
        ResponseResult baseResult = new ResponseResult();
        baseResult.setStatus(status);
        baseResult.setMessage(message);
        baseResult.setData(data);
        return baseResult;
    }
}
