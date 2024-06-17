package com.spindrift.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * ClassName: UserRegisterDTO
 * Package: com.spindrift.dto
 * Description:
 *
 * @Author 闫其武
 * @Create 2024/6/16 17:36
 * @Version 1.0
 */
@Data
public class UserRegisterDTO {

    @Schema(description = "用户名")
    String name;

    @Schema(description = "账号")
    String username;

    @Schema(description = "密码")
    String password;

}
