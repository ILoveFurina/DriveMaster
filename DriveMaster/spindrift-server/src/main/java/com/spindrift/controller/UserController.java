package com.spindrift.controller;

import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import com.spindrift.dto.UserLoginDTO;
import com.spindrift.dto.UserRegisterDTO;
import com.spindrift.service.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: UserController
 * Package: com.spindrift.controller
 * Description:
 *
 * @Author 闫其武
 * @Create 2024/6/15 19:04
 * @Version 1.0
 */
@Tag(name = "用户管理")
@RequestMapping("admin/user")
@RestController
@AllArgsConstructor
@CrossOrigin
@Slf4j
public class UserController {


    public final UserService userService;

    @PostMapping("login")
    public SaResult login (@RequestBody UserLoginDTO userLoginDTO){
        log.info("用户登录:{}", userLoginDTO);
        userService.login(userLoginDTO);
        return SaResult.ok("登录成功");
    }

    @PostMapping("/register")
    public SaResult register(@RequestBody UserRegisterDTO userRegisterDTO){
        log.info("用户注册:{}",userRegisterDTO);
        userService.register(userRegisterDTO);
        return SaResult.ok("注册成功");
    }
    // http://localhost:8080/admin/user/isLogin
    @GetMapping("/isLogin")
    public SaResult isLogin(){
        Map<String, Object> data = new HashMap<>();
        data.put("status", StpUtil.isLogin());
        return SaResult.data(data);
    }
}
