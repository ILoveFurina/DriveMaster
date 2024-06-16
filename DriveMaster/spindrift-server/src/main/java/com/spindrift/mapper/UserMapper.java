package com.spindrift.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.spindrift.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
* @author 闫
* @description 针对表【user】的数据库操作Mapper
* @createDate 2024-06-16 11:03:36
* @Entity generator.entity.User
*/
@Mapper
public interface UserMapper extends BaseMapper<User> {

}




