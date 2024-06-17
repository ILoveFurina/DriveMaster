package com.spindrift.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableField;
import java.time.LocalDateTime;

import lombok.*;

/**
 * 训练记录实体类
 */
@TableName("train") // 指定表名
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TrainRecord {

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
     * 项目类型
     */
    @TableField("subject_type")
    private Integer subjectType;

    /**
     * 训练日期
     */
    @TableField("train_date")
    private LocalDateTime trainDate;

    /**
     * 学时
     */
    @TableField("period")
    private Integer period;
}

