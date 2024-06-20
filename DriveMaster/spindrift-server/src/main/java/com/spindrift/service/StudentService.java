package com.spindrift.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.spindrift.dto.StudentDTO;
import com.spindrift.dto.StudentPageQueryDTO;
import com.spindrift.entity.Student;
import com.spindrift.result.PageResult;
import com.spindrift.vo.StudentVO;

/**
 * ClassName: StudentService
 * Package: com.spindrift.service.impl
 * Description:
 *
 * @Author 闫其武
 * @Create 2024/6/18 15:57
 * @Version 1.0
 */
public interface StudentService extends IService<Student> {

    /**
     * 新增学生
     * @param studentDTO
     */
    void add(StudentDTO studentDTO);

    /**
     * 删除学生
     * @param id
     */
    void delete(Long id);

    /**
     * 更新学生
     * @param studentDTO
     */
    void update(StudentDTO studentDTO);

    /**
     * 分页查询
     * @param studentPageQueryDTO
     * @return
     */
    PageResult<Student> pageQuery(StudentPageQueryDTO studentPageQueryDTO);

    void isStudentExists(String studentId);
}
