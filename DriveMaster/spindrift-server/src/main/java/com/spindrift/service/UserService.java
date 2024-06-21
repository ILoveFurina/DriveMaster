package com.spindrift.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.spindrift.dto.UserLoginDTO;
import com.spindrift.dto.UserRegisterDTO;
import com.spindrift.entity.User;
import com.spindrift.vo.LoginVO;
import com.spindrift.dto.RecallPwdDTO;

/**
 * ClassName: UserService
 * Package: com.spindrift.service
 * Description:
 *
 * @Author 闫其武
 * @Create 2024/6/16 10:37
 * @Version 1.0
 */

public interface UserService extends IService<User> {

    /**
     * 用户登录
     * @param userLoginDTO
     */
    LoginVO login(UserLoginDTO userLoginDTO);

    /**
     * 用户注册
     * @param userRegisterDTO
     */
    void register(UserRegisterDTO userRegisterDTO);

    void recall(RecallPwdDTO recallPwdDTO);

    void checkUserExists(String user);

    void checkUsernameExists(String user);
}
