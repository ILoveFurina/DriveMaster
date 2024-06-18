package com.spindrift.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * ClassName: StudentDTO
 * Package: com.spindrift.dto
 * Description:
 *
 * @Author 闫其武
 * @Create 2024/6/18 16:04
 * @Version 1.0
 */
@Data
public class StudentDTO {

    /**
     * 学员主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;


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
     * 教练姓名
     */
    @TableField("coach_name")
    private String coachName;

}
