package com.spindrift.handler;

import cn.dev33.satoken.util.SaResult;
import com.spindrift.exception.BaseException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * ClassName: GlobalExceptionHandler
 * Package: com.spindrift.handler
 * Description:
 *
 * @Author 闫其武
 * @Create 2024/6/16 13:41
 * @Version 1.0
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {



    @ExceptionHandler
    public SaResult exceptionHandler(BaseException e) {
        log.error("异常信息：{}", e.getMessage());
        return SaResult.error(e.getMessage());
    }

}
