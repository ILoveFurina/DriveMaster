package com.spindrift.controller;

import cn.dev33.satoken.util.SaResult;
import com.spindrift.dto.StudentDTO;
import com.spindrift.dto.StudentPageQueryDTO;
import com.spindrift.entity.Student;
import com.spindrift.result.PageResult;
import com.spindrift.service.StudentService;
import com.spindrift.vo.StudentVO;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * ClassName: StudentController
 * Package: com.spindrift.controller
 * Description:
 *
 * @Author 闫其武
 * @Create 2024/6/18 15:56
 * @Version 1.0
 */
@Tag(name = "学生相关接口")
@RestController
@RequestMapping("/admin/student")
@AllArgsConstructor
@Slf4j
public class StudentController {

    StudentService studentService;

    @PostMapping
    public SaResult add(@RequestBody StudentDTO studentDTO) {
        log.info("添加学生信息:{}", studentDTO);
        studentService.add(studentDTO);
        return SaResult.ok();
    }

    @DeleteMapping
    public SaResult delete(Long id) {
        log.info("删除学生信息:{}", id);
        studentService.delete(id);
        return SaResult.ok();
    }

    @PutMapping
    public SaResult modify(@RequestBody StudentDTO studentDTO) {
        log.info("修改学生信息:{}", studentDTO);
        studentService.update(studentDTO);
        return SaResult.ok();
    }

    @GetMapping("/page")
    public SaResult  pageQuery(StudentPageQueryDTO studentPageQueryDTO) {
        log.info("分页查询学生信息:{}", studentPageQueryDTO);
        PageResult<Student> page = studentService.pageQuery(studentPageQueryDTO);
        return SaResult.data(page);
    }



}
