package com.spindrift.exception;

/**
 * ClassName: UsernameExistsException
 * Package: com.spindrift.exception
 * Description:
 *
 * @Author 闫其武
 * @Create 2024/6/16 23:55
 * @Version 1.0
 */
public class UsernameExistsException extends BaseException {

    public UsernameExistsException() {
    }

    public UsernameExistsException(String msg) {
        super(msg);
    }

}