package com.spindrift.dto;

import lombok.Data;

/**
 * ClassName: PageQueryDTO
 * Package: com.spindrift.dto
 * Description:
 *
 * @Author 闫其武
 * @Create 2024/6/17 17:48
 * @Version 1.0
 */
@Data
public class CoachPageQueryDTO {

    //页码
    private int page;

    //每页记录数
    private int pageSize;

    //教练姓名
    private String name;

}
