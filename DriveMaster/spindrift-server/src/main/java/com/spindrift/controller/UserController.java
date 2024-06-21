package com.spindrift.controller;

import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.spindrift.dto.UserLoginDTO;
import com.spindrift.dto.UserRegisterDTO;
import com.spindrift.entity.User;
import com.spindrift.service.UserService;
import com.spindrift.vo.LoginVO;
import com.spindrift.dto.RecallPwdDTO;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class UserController {


    public final UserService userService;

    @PostMapping("login")
    public SaResult login (@RequestBody UserLoginDTO userLoginDTO){
        log.info("用户登录:{}", userLoginDTO);
        LoginVO loginVO = userService.login(userLoginDTO);
        return SaResult.get(200, "登录成功",loginVO);
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

    @GetMapping()
    public SaResult getByUsername(String username){
        User user = userService.getOne(new QueryWrapper<User>().eq("username", username));
        Map<String, String> map = new HashMap();
        map.put("user", user.getUsername());
        return SaResult.data(map);
    }

    @GetMapping("/userExists")
    public SaResult checkUserExists(String user){
        log.info("用户是否存在:{}",user);
        userService.checkUserExists(user);
        return SaResult.ok();
    }

    @GetMapping("/usernameExists")
    public SaResult checkUsernameExists(String username){
        log.info("账号是否存在:{}",username);
        userService.checkUsernameExists(username);
        return SaResult.ok();
    }

    @GetMapping("/logout")
    public SaResult logout(){
        StpUtil.logout();
        return SaResult.ok();
    }

    @PutMapping("/recall")
    public SaResult recall(@RequestBody RecallPwdDTO recallPwdDTO){
        log.info("用户重置密码:{}",recallPwdDTO);
        userService.recall(recallPwdDTO);
        return SaResult.ok();
    }

}
