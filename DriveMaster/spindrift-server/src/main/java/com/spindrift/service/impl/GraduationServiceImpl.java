package com.spindrift.service.impl;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.spindrift.dto.GraduationDTO;
import com.spindrift.dto.PageQueryDTO;
import com.spindrift.entity.Graduation;
import com.spindrift.entity.Student;
import com.spindrift.mapper.GraduationMapper;
import com.spindrift.mapper.StudentMapper;
import com.spindrift.result.PageResult;
import com.spindrift.service.GraduationService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
* @author 闫
* @description 针对表【graduation】的数据库操作Service实现
* @createDate 2024-06-19 16:09:40
*/
@Service
@AllArgsConstructor
public class GraduationServiceImpl extends ServiceImpl<GraduationMapper, Graduation>
    implements GraduationService {

    StudentMapper studentMapper;

    GraduationMapper graduationMapper;

    @Override
    public void add(Long id) {
        Student student = studentMapper.selectById(id);
        Graduation graduation = Graduation.builder().studentId(id)
                .graduateTime(LocalDateTime.now())
                .licenseType(student.getApplyType())
                .studentName(student.getName())
                .build();

        save(graduation);
    }

    @Override
    public void delete(Long id) {
        graduationMapper.delete(new QueryWrapper<Graduation>().eq("id","student_id"));
    }

    @Override
    public void updateRecord(GraduationDTO graduationDTO) {
        Graduation graduation = getById(graduationDTO.getId());
        graduation.setLicenseType(graduationDTO.getLicenseType());
        graduation.setGraduateTime(graduationDTO.getGraduateTime());
        graduationMapper.deleteById(graduation.getId());
        graduationMapper.insert(graduation);
    }

    @Override
    public PageResult<Graduation> pageQuery(PageQueryDTO pageQueryDTO) {
        Page<Graduation> page = new Page<>(pageQueryDTO.getPage(), pageQueryDTO.getPageSize());
        Page<Graduation> graduationPage = graduationMapper.selectPage(page, null);
        return new PageResult<>(graduationPage.getTotal(), graduationPage.getRecords());
    }

}




