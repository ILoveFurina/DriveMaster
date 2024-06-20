package com.spindrift.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

import lombok.Builder;
import lombok.Data;

/**
 * 
 * @TableName bill
 */
@TableName(value ="bill")
@Data
public class Bill implements Serializable {
    /**
     * 账单主键
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * SJ开头的单号
     */
    private String billId;

    /**
     * 单据日期
     */
    private LocalDateTime billDate;

    /**
     * 学生的id
     */
    private Long studentId;

    /**
     * 缴纳的费用类型
     */
    private Integer expenseType;

    /**
     * 套餐金额
     */
    private BigDecimal setmealAmount;

    /**
     * 优惠金额
     */
    private BigDecimal discountAmount;

    /**
     * 实际支付金额
     */
    private BigDecimal actualPayment;

    /**
     * 操作人id
     */
    private String createUsername;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}