package cn.com.dream.common.exception;

import cn.com.dream.common.model.ResponseData;
import cn.hutool.http.HttpStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 异常处理类
 *
 * @Author yangjun
 * @Date 2020/1/19
 **/
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 异常处理
     *
     * @param exception 异常
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    public ResponseData exceptionHandler(Exception exception) {
        log.error("系统异常", exception);
        return ResponseData.buildError(HttpStatus.HTTP_INTERNAL_ERROR, "系统异常");
    }

    /**
     * 自定义异常
     *
     * @param exception
     * @return
     */
    @ExceptionHandler(value = BaseException.class)
    public ResponseData baseExceptionHandler(BaseException exception) {
        log.error(exception.getMsg(), exception);
        return ResponseData.buildError(exception.getCode(), exception.getMsg());
    }

}
