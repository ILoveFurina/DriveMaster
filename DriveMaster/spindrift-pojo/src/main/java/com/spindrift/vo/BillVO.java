package com.spindrift.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * ClassName: BillVO
 * Package: com.spindrift.vo
 * Description:
 *
 * @Author 闫其武
 * @Create 2024/6/19 20:23
 * @Version 1.0
 */
@Data
public class BillVO {
    private Long id;

    private String billId;

    private LocalDateTime billDate;

    private String studentId;

    private String name;

    private String idCard;

    private String phone;

    /**
     * 准驾车型
     */
    private Integer applyType;
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
