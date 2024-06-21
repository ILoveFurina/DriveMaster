package com.spindrift.dto;

import lombok.Data;

/**
 * ClassName: RecallPwdDTO
 * Package: com.spindrift.vo
 * Description:
 *
 * @Author 闫其武
 * @Create 2024/6/21 12:01
 * @Version 1.0
 */
@Data
public class RecallPwdDTO {

    String id;

    String oldPassword;

    String newPassword;

}
