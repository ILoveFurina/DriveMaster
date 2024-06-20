package com.spindrift.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * ClassName: TrainAddDTO
 * Package: com.spindrift.dto
 * Description:
 *
 * @Author 闫其武
 * @Create 2024/6/20 13:32
 * @Version 1.0
 */
@Data
public class TrainAddDTO {

    /**
     *学生编号
     */
    private String studentId;

    /**
     * 项目类型
     */
    private Integer subjectType;


    /**
     * 学时
     */
    private Integer period;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime trainDate;

}
