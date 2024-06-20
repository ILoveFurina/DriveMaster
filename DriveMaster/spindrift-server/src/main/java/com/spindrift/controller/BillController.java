package com.spindrift.controller;

import cn.dev33.satoken.util.SaResult;
import com.spindrift.dto.BillAddDTO;
import com.spindrift.dto.BillUpdateDTO;
import com.spindrift.dto.PageQueryDTO;
import com.spindrift.result.PageResult;
import com.spindrift.service.BillService;
import com.spindrift.vo.BillVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * ClassName: BillController
 * Package: com.spindrift.controller
 * Description:
 *
 * @Author 闫其武
 * @Create 2024/6/19 20:00
 * @Version 1.0
 */
@Tag(name = "账单信息相关接口")
@RestController
@Slf4j
@AllArgsConstructor
@RequestMapping("/admin/bill")
public class BillController {

    BillService billService;

    @Operation(summary = "根据学生编号新增账单")
    @PostMapping
    public SaResult add(@RequestBody BillAddDTO billAddDTO){
        log.info("billAddDTO:{}",billAddDTO);
        billService.add(billAddDTO);
        return SaResult.ok();
    }

    @Operation(summary = "删除账单")
    @DeleteMapping
    public SaResult delete(Long id){
        billService.removeById(id);
        return SaResult.ok();
    }

    @Operation(summary = "根据账单id修改账单")
    @PutMapping
    public SaResult modify(@RequestBody BillUpdateDTO billDTO){
        billService.updateRecord(billDTO);
        return SaResult.ok();
    }

    @Operation(summary = "分页查询账单")
    @GetMapping("/page")
    public SaResult modify(PageQueryDTO pageQueryDTO){
        PageResult<BillVO> page = billService.pageQuery(pageQueryDTO);
        return SaResult.data(page);
    }
}
