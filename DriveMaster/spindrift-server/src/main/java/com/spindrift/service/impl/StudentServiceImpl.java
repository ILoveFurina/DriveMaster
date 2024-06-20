package com.spindrift.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.spindrift.dto.StudentDTO;
import com.spindrift.dto.StudentPageQueryDTO;
import com.spindrift.entity.Student;
import com.spindrift.exception.StudentNotFoundException;
import com.spindrift.mapper.StudentMapper;
import com.spindrift.result.PageResult;
import com.spindrift.service.StudentService;
import com.spindrift.utils.IdUtils;
import com.spindrift.vo.StudentVO;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

/**
 * ClassName: StudentServiceImpl
 * Package: com.spindrift.service.impl
 * Description:
 *
 * @Author 闫其武
 * @Create 2024/6/18 15:57
 * @Version 1.0
 */
@Service
@AllArgsConstructor
public class StudentServiceImpl  extends ServiceImpl<StudentMapper, Student> implements StudentService {

    StudentMapper studentMapper;

    StudentMapper coachMapper;

    @Override
    public void add(StudentDTO studentDTO) {
        //先插入不带有学员编号的student
        Student student = new Student();
        BeanUtils.copyProperties(studentDTO,student);
        student.setCreateTime(LocalDateTime.now());
        studentMapper.insert(student);
        //插入之后，mybatis-plus会自动回显主键，给原来的实体类！！
        String studentId = IdUtils.generateStudentId(student.getId());
        student.setStudentId(studentId);
        studentMapper.updateById(student);

    }

    @Override
    public void delete(Long id) {
        studentMapper.deleteById(id);
    }

    @Transactional
    @Override
    public void update(StudentDTO studentDTO) {
        Student student = studentMapper.selectById(studentDTO.getId());
        student.setUpdateTime(LocalDateTime.now());
        BeanUtils.copyProperties(studentDTO,student);
        studentMapper.deleteById(student);
        studentMapper.insert(student);
    }

    @Override
    public PageResult<Student> pageQuery(StudentPageQueryDTO studentPageQueryDTO) {
        Page<Student> page = new Page<>(studentPageQueryDTO.getPage(), studentPageQueryDTO.getPageSize());
        Page<Student> studentPage = studentMapper.selectPage(page, null);
        return new PageResult<>(studentPage.getTotal(), studentPage.getRecords());
    }

    @Override
    public void isStudentExists(String studentId) {
        Long id = IdUtils.extractStudentId(studentId);
        if (studentMapper.selectById(id) == null) {
            throw new StudentNotFoundException("该学员不存在,请确认学员编号");
        }
    }

}
