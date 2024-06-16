package com.spindrift.handler;

import cn.dev33.satoken.util.SaResult;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * ClassName: GlobalExceptionHandler
 * Package: com.spindrift.handler
 * Description:
 *
 * @Author 闫其武
 * @Create 2024/6/16 13:41
 * @Version 1.0
 */

public class GlobalExceptionHandler {



    @ExceptionHandler
    public SaResult exceptionHandler(Exception e) {
        e.printStackTrace();
        return SaResult.error(e.getMessage());
    }

}
