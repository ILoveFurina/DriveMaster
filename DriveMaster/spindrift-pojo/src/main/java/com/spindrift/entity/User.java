package com.spindrift.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.*;

import java.time.LocalDateTime;

/**
 * 用户实体类
 */
@TableName("user") // 指定数据库中的表名
@Data
public class User {

    /**
     * 主键ID
     */
    @TableId(value = "id", type = IdType.AUTO) // 标识主键字段，类型为自动增长
    private Long id;

    /**
     * 用户姓名
     */
    @TableField("name")
    private String name;

    /**
     * 用户名
     */
    @TableField("username")
    private String username;

    /**
     * 密码
     */
    @TableField("password")
    private String password;

    /**
     * 手机号码
     */
    @TableField("phone")
    private String phone;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT) // 插入时自动填充
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE) // 插入和更新时自动填充
    private LocalDateTime updateTime;
}
