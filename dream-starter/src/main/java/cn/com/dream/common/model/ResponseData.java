package cn.com.dream.common.model;

import cn.hutool.http.HttpStatus;
import lombok.Data;

import java.io.Serializable;

@Data
public class ResponseData<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer code;


    private String msg;

    private T data;

    public ResponseData(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
        this.data = null;
    }

    public ResponseData(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static <T> ResponseData<T> buildSuccess(T data) {
        return new ResponseData<>(0, "成功", data);
    }

    public static <T> ResponseData<T> buildSuccess() {
        return new ResponseData<>(0, "成功", null);
    }

    public static <T> ResponseData<T> buildError(Integer code, String msg) {
        return new ResponseData<>(code, msg, null);
    }

    public static <T> ResponseData<T> buildError(String msg) {
        return new ResponseData<>(HttpStatus.HTTP_INTERNAL_ERROR, msg, null);
    }

}
