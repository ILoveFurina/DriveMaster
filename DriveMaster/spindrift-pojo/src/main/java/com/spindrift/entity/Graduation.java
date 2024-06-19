package com.spindrift.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.time.LocalDateTime;

import lombok.*;

/**
 * 毕业信息实体类
 */
@TableName("graduation") // 指定表名
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Graduation {

    /**
     * 主键ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 学生ID
     */
    @TableField("student_id")
    private Long studentId;

    /**
     * 学生姓名
     */
    @TableField("student_name")
    private String studentName;

    /**
     * 驾照类型
     */
    @TableField("license_type")
    private Integer licenseType;

    /**
     * 毕业时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime graduateTime;
}

