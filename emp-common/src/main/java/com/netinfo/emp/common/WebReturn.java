package com.netinfo.emp.common;

/**
 * Web 请求的返回类型
 * <p>
 * Project emp-common
 * Package com.netinfo.emp.common
 * <p>
 * Created by Charley on 2017/3/9.
 */
public class WebReturn {
    private boolean result;
    private Integer code;
    private String msg;
    private Object data;

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
    public Integer getCode() {
        return code;
    }

    /**
     * 设置返回码
     *
     * @param code 返回码
     */
    public void setCode(Integer code) {
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
    public void setData(Object data) {
        this.data = data;
    }
}
