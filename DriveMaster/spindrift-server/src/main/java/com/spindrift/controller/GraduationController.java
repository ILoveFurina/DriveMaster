package com.spindrift.controller;

import cn.dev33.satoken.util.SaResult;
import com.spindrift.dto.GraduationDTO;
import com.spindrift.dto.PageQueryDTO;
import com.spindrift.entity.Graduation;
import com.spindrift.result.PageResult;
import com.spindrift.service.GraduationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.Validate;
import org.springframework.web.bind.annotation.*;

/**
 * ClassName: GraduationController
 * Package: com.spindrift.controller
 * Description:
 *
 * @Author 闫其武
 * @Create 2024/6/19 16:12
 * @Version 1.0
 */
@Tag(name = "毕业信息相关接口")
@RestController
@Slf4j
@AllArgsConstructor
@RequestMapping("/admin/graduation")
public class GraduationController {

    GraduationService graduationService;

    @Operation(summary = "根据学员id添加毕业记录")
    @PostMapping("/{id}")
    public SaResult add(@PathVariable @Valid @NotNull Long id){
        graduationService.add(id);
        return SaResult.ok();
    }
    @Operation(summary = "根据id删除毕业记录")
    @DeleteMapping
    public SaResult delete(@Valid @NotNull Long id){
        graduationService.removeById(id);
        return SaResult.ok();
    }
    @Operation(summary = "修改学员毕业记录")
    @PutMapping
    public SaResult update(@RequestBody GraduationDTO graduationDTO){
        graduationService.updateRecord(graduationDTO);
        return SaResult.ok();
    }
    @Operation(summary = "分页查询毕业记录")
    @GetMapping("page")
    public SaResult pageQuery(PageQueryDTO pageQueryDTO){
        PageResult<Graduation> page = graduationService.pageQuery(pageQueryDTO);
        return SaResult.data(page);
    }
}
