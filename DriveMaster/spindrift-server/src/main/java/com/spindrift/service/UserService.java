package com.spindrift.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.spindrift.dto.UserLoginDTO;
import com.spindrift.entity.User;
import org.springframework.stereotype.Service;

/**
 * ClassName: UserService
 * Package: com.spindrift.service
 * Description:
 *
 * @Author 闫其武
 * @Create 2024/6/16 10:37
 * @Version 1.0
 */
@Service
public interface UserService extends IService<User> {


    void login(UserLoginDTO userLoginDTO);
}
