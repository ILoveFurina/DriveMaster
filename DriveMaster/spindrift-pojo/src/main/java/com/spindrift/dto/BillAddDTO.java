package com.spindrift.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * ClassName: BillDTO
 * Package: com.spindrift.dto
 * Description:
 *
 * @Author 闫其武
 * @Create 2024/6/19 20:02
 * @Version 1.0
 */
@Data
public class BillAddDTO {

    //学生编号
    private String studentId;

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
     * 操作人名称
     */
    private String createUsername;

}
