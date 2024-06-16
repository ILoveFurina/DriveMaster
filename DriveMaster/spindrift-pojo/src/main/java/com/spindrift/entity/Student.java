package com.spindrift.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDateTime;

import lombok.*;

/**
 * 学员实体类
 */
@TableName("student") // 指定表名
@Data
public class Student {

    /**
     * 学员编号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 以XY开头的学员编号
     */
    @TableField("student_id")
    private String studentId;

    /**
     * 学员姓名
     */
    @TableField("name")
    private String name;

    /**
     * 身份证号
     */
    @TableField("id_card")
    private String idCard;

    /**
     * 身份证图片地址
     */
    @TableField("id_card_image")
    private String idCardImage;

    /**
     * 手机号
     */
    @TableField("phone")
    private String phone;

    /**
     * 地址
     */
    @TableField("address")
    private String address;

    /**
     * 申请类型
     */
    @TableField("apply_type")
    private Integer applyType;

    /**
     * 教练ID
     */
    @TableField("coach_id")
    private Long coachId;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;
}

