package com.spindrift.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.spindrift.dto.UserLoginDTO;
import com.spindrift.dto.UserRegisterDTO;
import com.spindrift.entity.User;
import com.spindrift.exception.PasswordErrorException;
import com.spindrift.exception.UsernameExistsException;
import com.spindrift.exception.UsernameNotFoundException;
import com.spindrift.mapper.UserMapper;
import com.spindrift.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.time.LocalDateTime;

/**
 * ClassName: UserServiceImpl
 * Package: com.spindrift.service.impl
 * Description:
 *
 * @Author 闫其武
 * @Create 2024/6/16 10:37
 * @Version 1.0
 */

@Service
@AllArgsConstructor
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
        implements UserService {


    UserMapper userMapper;

    @Override
    public void login(UserLoginDTO userLoginDTO) {
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(User::getUsername,userLoginDTO.getUsername());

        User user = getOne(wrapper);
        if(user == null){
            throw new UsernameNotFoundException("用户名不存在");
        }
        String password = DigestUtils.md5DigestAsHex(userLoginDTO.getPassword().getBytes());
        if(!user.getPassword().equals(password)){
            throw new PasswordErrorException("密码错误");
        }
        StpUtil.login(user.getId());
    }

    @Override
    public void register(UserRegisterDTO userRegisterDTO) {
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(User::getUsername,userRegisterDTO.getUsername());

        User user = getOne(wrapper);
        if(user != null){
            throw new UsernameExistsException("该用户名已存在");
        }
        user = new User();
        userRegisterDTO.setPassword(DigestUtils.md5DigestAsHex(userRegisterDTO.getPassword().getBytes()));
        BeanUtils.copyProperties(userRegisterDTO,user);
        user.setCreateTime(LocalDateTime.now());
        userMapper.insert(user);
    }
}
