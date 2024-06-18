package com.spindrift.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.spindrift.dto.StudentDTO;
import com.spindrift.dto.StudentPageQueryDTO;
import com.spindrift.entity.Student;
import com.spindrift.mapper.StudentMapper;
import com.spindrift.result.PageResult;
import com.spindrift.service.StudentService;
import com.spindrift.vo.StudentVO;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

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
        Student student = new Student();
        BeanUtils.copyProperties(studentDTO,student);
        student.setCreateTime(LocalDateTime.now());

        Long maxId = studentMapper.selectMaxId();
        String studentId = generateStudentId(maxId);
        student.setStudentId(studentId);

        studentMapper.insert(student);
    }

    @Override
    public void delete(Long id) {
        studentMapper.deleteById(id);
    }

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

    public String generateStudentId(Long maxId) {

        if (maxId == null) {
            return "XY000001";
        }

        maxId++;
        String newId = String.format("XY%06d", maxId);

        return newId;
    }


}
