package com.netinfo.emp.common;

/**
 * Web 请求的返回类型
 * <p>
 * Project emp-common
 * Package com.netinfo.emp.common
 * <p>
 * Created by Charley on 2017/3/9.
 */
public class WebReturn<T> {
    private boolean result;
    private int code;
    private String msg;
    private T data;

    /**
     * 获取操作结果
     *
     * @return 操作结果
     */
    public boolean isResult() {
        return result;
    }

    /**
     * 设置操作结果
     *
     * @param result 操作结果
     */
    public void setResult(boolean result) {
        this.result = result;
    }

    /**
     * 获取返回码
     *
     * @return 返回码
     */
    public int getCode() {
        return code;
    }

    /**
     * 设置返回码
     *
     * @param code 返回码
     */
    public void setCode(int code) {
        this.code = code;
    }

    /**
     * 获取错误消息
     *
     * @return 错误消息
     */
    public String getMsg() {
        return msg;
    }

    /**
     * 设置错误消息
     *
     * @param msg 错误消息
     */
    public void setMsg(String msg) {
        this.msg = msg;
    }

    /**
     * 获取返回数据
     *
     * @return 返回数据
     */
    public Object getData() {
        return data;
    }

    /**
     * 设置返回数据
     *
     * @param data 返回数据
     */
    public void setData(T data) {
        this.data = data;
    }

    public WebReturn() {
        result = true;
        code = 0;
        msg = "";
    }
}
