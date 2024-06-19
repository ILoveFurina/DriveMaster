package com.spindrift.dto;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * ClassName: GraduationDTO
 * Package: com.spindrift.dto
 * Description:
 *
 * @Author 闫其武
 * @Create 2024/6/19 16:20
 * @Version 1.0
 */
@Data
public class GraduationDTO {

    /**
     * 主键ID
     */
    private Long id;

    /**
     * 驾照类型
     */
    private Integer licenseType;

    /**
     * 毕业时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime graduateTime;

}
