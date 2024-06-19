package com.spindrift.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.spindrift.dto.GraduationDTO;
import com.spindrift.dto.PageQueryDTO;
import com.spindrift.entity.Graduation;
import com.spindrift.result.PageResult;

/**
* @author 闫
* @description 针对表【graduation】的数据库操作Service
* @createDate 2024-06-19 16:09:40
*/
public interface GraduationService extends IService<Graduation> {

    void add(Long id);

    void delete(Long id);

    void updateRecord(GraduationDTO graduationDTO);

    PageResult<Graduation> pageQuery(PageQueryDTO pageQueryDTO);
}
