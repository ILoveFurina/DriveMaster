package com.spindrift.exception;

/**
 * 密码错误异常
 */
public class CoachNotExistsException extends BaseException {

    public CoachNotExistsException() {
    }

    public CoachNotExistsException(String msg) {
        super(msg);
    }

}
