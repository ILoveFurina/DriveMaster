package com.spindrift.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * ClassName: TrainVO
 * Package: com.spindrift.vo
 * Description:
 *
 * @Author 闫其武
 * @Create 2024/6/20 13:52
 * @Version 1.0
 */
@Data
public class TrainVO {

    private Long id;

    /**
     *学生编号！！
     */
    private String studentId;

    /**
     *
     */
    private String studentName;

    /**
     * 项目类型
     */
    private Integer subjectType;

    /**
     * 训练日期
     */
    private LocalDateTime trainDate;

    /**
     * 学时
     */
    private Integer period;

}
