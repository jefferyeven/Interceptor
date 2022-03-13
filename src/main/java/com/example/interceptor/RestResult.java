package com.example.interceptor;

import java.io.Serializable;

/**
 * @author nandao
 * Created on 2021/1/12-21:47.
 * 统一返回Rest风格的数据结构
 */
public class RestResult<T>  implements Serializable {

    /**
     * 成功的code码
     */
    private String code = "2000";
    /**
     * 成功时返回的数据，失败时返回具体的异常信息
     */
    private T data;
    /**
     * 请求失败返回的提示信息，给前端进行页面展示的信息
     */
    private String message ;

    public RestResult() {
    }

    @Override
    public String toString() {

        return "RestResult{" +
                "code='" + code + '\'' +
                ", data=" + data +
                ", message=" + message +
                '}';
    }

    public RestResult(String code, T data, String message) {
        this.code = code;
        this.data = data;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
