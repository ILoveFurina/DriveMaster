package com.spindrift.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * ClassName: LoginVO
 * Package: com.spindrift.vo
 * Description:
 *
 * @Author 闫其武
 * @Create 2024/6/21 11:41
 * @Version 1.0
 */
@Data
public class LoginVO {

    Long id;

    String name;

    String username;

    String phone;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    LocalDateTime createTime;
}
