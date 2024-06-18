package com.spindrift.dto;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * ClassName: CoachDTO
 * Package: com.spindrift.dto
 * Description:
 *
 * @Author 闫其武
 * @Create 2024/6/18 10:12
 * @Version 1.0
 */
@Data
public class CoachDTO {

    private Long id;

    private String name;

    private String phone;

    private String idCard;

    private String carId;

    private Integer carType;

}
