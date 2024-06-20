package com.spindrift.controller;

import cn.dev33.satoken.util.SaResult;
import com.spindrift.dto.*;
import com.spindrift.result.PageResult;
import com.spindrift.service.TrainService;
import com.spindrift.vo.BillVO;
import com.spindrift.vo.TrainVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * ClassName: TrainController
 * Package: com.spindrift.controller
 * Description:
 *
 * @Author 闫其武
 * @Create 2024/6/20 13:27
 * @Version 1.0
 */
@Tag(name = "训练管理相关接口")
@RestController
@Slf4j
@AllArgsConstructor
@RequestMapping("/admin/train")
public class TrainController {

    TrainService trainService;

    @Operation(summary = "根据学生编号新增训练")
    @PostMapping
    public SaResult add(@RequestBody TrainAddDTO trainAddDTO){
        log.info("trainAddDTO:{}",trainAddDTO);
        trainService.add(trainAddDTO);
        return SaResult.ok();
    }

    @Operation(summary = "删除训练")
    @DeleteMapping
    public SaResult delete(Long id){
        trainService.removeById(id);
        return SaResult.ok();
    }

    @Operation(summary = "根据训练id修改训练")
    @PutMapping
    public SaResult modify(@RequestBody TrainUpdateDTO trainUpdateDTO){
        trainService.updateRecord(trainUpdateDTO);
        return SaResult.ok();
    }

    @Operation(summary = "分页查询训练")
    @GetMapping("/page")
    public SaResult modify(PageQueryDTO pageQueryDTO){
        PageResult<TrainVO> page = trainService.pageQuery(pageQueryDTO);
        return SaResult.data(page);
    }

}
