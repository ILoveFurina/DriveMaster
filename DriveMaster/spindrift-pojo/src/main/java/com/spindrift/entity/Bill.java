package com.spindrift.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.*;

/**
 * 账单实体类
 */
@TableName("bill") // 指定表名
@Data
public class Bill {

    /**
     * 账单主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * SJ开头的单号
     */
    @TableField("bill_id")
    private String billId;

    /**
     * 单据日期
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime billDate;

    /**
     * 学生的id
     */
    @TableField("student_id")
    private Long studentId;

    /**
     * 准驾车型
     */
    @TableField("car_type")
    private Integer carType;

    /**
     * 缴纳的费用类型
     */
    @TableField("expense_type")
    private Integer expenseType;

    /**
     * 套餐金额
     */
    @TableField("setmeal_amount")
    private BigDecimal setmealAmount;

    /**
     * 优惠金额
     */
    @TableField("discount_amount")
    private BigDecimal discountAmount;

    /**
     * 实际支付金额
     */
    @TableField("actual_payment")
    private BigDecimal actualPayment;

    /**
     * 操作人id
     */
    @TableField("create_user")
    private Long createUser;
}

