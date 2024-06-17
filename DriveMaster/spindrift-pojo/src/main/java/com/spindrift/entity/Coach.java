package com.spindrift.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDateTime;

import lombok.*;

/**
 * 教练实体类
 */
@TableName("coach") // 指定表名
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Coach {

    /**
     * 教练编号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 教练姓名
     */
    @TableField("name")
    private String name;

    /**
     * 手机号
     */
    @TableField("phone")
    private String phone;

    /**
     * 身份证
     */
    @TableField("id_card")
    private String idCard;

    /**
     * 教练车牌
     */
    @TableField("car_id")
    private String carId;

    /**
     * 车辆型号
     */
    @TableField("car_type")
    private Integer carType;

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

