package com.spindrift.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * ClassName: StudentVO
 * Package: com.spindrift.vo
 * Description:
 *
 * @Author 闫其武
 * @Create 2024/6/18 16:13
 * @Version 1.0
 */
@Data
public class StudentVO {


    /**
     * 学员主键
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


}
