package com.spindrift.controller;
import cn.dev33.satoken.util.SaResult;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.spindrift.dto.CoachDTO;
import com.spindrift.dto.CoachPageQueryDTO;
import com.spindrift.entity.Coach;
import com.spindrift.result.PageResult;
import com.spindrift.service.CoachService;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Map;

/**
 * ClassName: CoachController
 * Package: com.spindrift.controller
 * Description:
 *
 * @Author 闫其武
 * @Create 2024/6/17 17:42
 * @Version 1.0
 */
@RestController
@Slf4j
@AllArgsConstructor
@RequestMapping("/admin/coach")
public class CoachController {

    CoachService coachService;

    @GetMapping("/page")
    public SaResult pageQuery(CoachPageQueryDTO coachPageQueryDTO) {
        log.info("分页查询: {}", coachPageQueryDTO);
        PageResult<Coach> pageResult = coachService.pageQuery(coachPageQueryDTO);
        return SaResult.data(pageResult);
    }

    @GetMapping()
    public SaResult getByName(@NotNull String name){
        log.info("查询教练,id:{}",name);
        coachService.getByName(name);
        return SaResult.ok();
    }


    @DeleteMapping
    public SaResult delete(Long id){
        log.info("删除教练,id:{}",id);
        coachService.removeById(id);
        return SaResult.ok();
    }

    @PutMapping
    public SaResult modify(@RequestBody CoachDTO coachDTO){
        log.info("更新教练:{}",coachDTO);
        coachService.modify(coachDTO);
        return SaResult.ok();
    }

    @PostMapping
    public SaResult add(@RequestBody CoachDTO coachDTO){
        log.info("新增教练:{}",coachDTO);
        Coach coach = new Coach();
        BeanUtils.copyProperties(coachDTO,coach);
        coach.setCreateTime(LocalDateTime.now());
        coachService.save(coach);
        return SaResult.ok();
    }
}
