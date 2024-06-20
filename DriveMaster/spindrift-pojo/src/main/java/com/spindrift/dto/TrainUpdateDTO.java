package com.spindrift.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * ClassName: TrainUpdateDTO
 * Package: com.spindrift.dto
 * Description:
 *
 * @Author 闫其武
 * @Create 2024/6/20 13:40
 * @Version 1.0
 */
@Data
public class TrainUpdateDTO {

    /**
     * 训练主键
     */
    private Long id;
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
