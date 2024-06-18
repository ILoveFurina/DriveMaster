package com.spindrift.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.spindrift.dto.CoachDTO;
import com.spindrift.dto.CoachPageQueryDTO;
import com.spindrift.entity.Coach;
import com.spindrift.entity.User;
import com.spindrift.exception.CoachNotExistsException;
import com.spindrift.mapper.CoachMapper;
import com.spindrift.mapper.UserMapper;
import com.spindrift.result.PageResult;
import com.spindrift.service.CoachService;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * ClassName: CoachServiceImpl
 * Package: com.spindrift.service.impl
 * Description:
 *
 * @Author 闫其武
 * @Create 2024/6/17 17:45
 * @Version 1.0
 */
@Service
@AllArgsConstructor
public class CoachServiceImpl extends ServiceImpl<CoachMapper, Coach>  implements CoachService {

    CoachMapper coachMapper;

    @Override
    public PageResult<Coach> pageQuery(CoachPageQueryDTO pageQueryDTO) {

        Page<Coach> page = new Page<>(pageQueryDTO.getPage(), pageQueryDTO.getPageSize());
        if(pageQueryDTO.getName() == null){
            pageQueryDTO.setName("");
        }
        Page<Coach> pageInfo = coachMapper.selectPage(page, new QueryWrapper<Coach>().like("name", pageQueryDTO.getName()));
        return new PageResult<>(pageInfo.getTotal(), pageInfo.getRecords());
    }

    @Override
    public void modify(CoachDTO coachDTO) {

        Coach coach = coachMapper.selectById(coachDTO.getId());
        BeanUtils.copyProperties(coachDTO, coach);
        coach.setUpdateTime(LocalDateTime.now());
        coachMapper.updateById(coach);
    }

    @Override
    public void getByName(String name) {

        List<Coach> coachList = coachMapper.selectList(new QueryWrapper<Coach>().like("name", name));
        if(coachList==null || coachList.size()==0){
            throw new CoachNotExistsException();
        }
    }
}
