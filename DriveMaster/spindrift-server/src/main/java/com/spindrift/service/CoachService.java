package com.spindrift.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.spindrift.dto.CoachDTO;
import com.spindrift.dto.CoachPageQueryDTO;
import com.spindrift.entity.Coach;
import com.spindrift.entity.User;
import com.spindrift.result.PageResult;
import org.springframework.stereotype.Service;

/**
 * ClassName: CoachService
 * Package: com.spindrift.service
 * Description:
 *
 * @Author 闫其武
 * @Create 2024/6/17 17:45
 * @Version 1.0
 */
@Service
public interface CoachService extends IService<Coach> {

    PageResult<Coach> pageQuery(CoachPageQueryDTO coachPageQueryDTO);


    void modify(CoachDTO coachDTO);

    void getByName(String name);
}
