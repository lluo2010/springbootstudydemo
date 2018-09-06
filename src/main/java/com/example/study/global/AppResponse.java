package com.example.study.global;

import java.io.Serializable;

/**
 * Created by louis on 2018/9/6.
 */
public class AppResponse<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    private T data;
    private int errorCode;
    private String errorMsg;


    public AppResponse(){

    }

    public AppResponse(int errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public AppResponse(int errorCode, String errorMsg, T data) {
        this.data = data;
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    @Override
    public String toString() {
        return "AppResponse{" +
                "data=" + data +
                ", errorCode=" + errorCode +
                ", errorMsg='" + errorMsg + '\'' +
                '}';
    }
}
