package cn.com.dream.common.exception;

import cn.hutool.http.HttpStatus;
import lombok.Data;

/**
 * 自定义异常
 *
 * @Author yangjun
 * @Date 2020/1/19
 **/

@Data
public class BaseException extends RuntimeException {

    /**
     * 异常编码
     */
    private Integer code;

    /**
     * 异常信息
     */
    private String msg;

    public BaseException(Integer code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }

    public BaseException(String msg) {
        this(HttpStatus.HTTP_INTERNAL_ERROR, msg);
    }

}
