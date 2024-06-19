package com.spindrift.service.impl;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.spindrift.dto.PageQueryDTO;
import com.spindrift.entity.Comment;
import com.spindrift.mapper.CommentMapper;
import com.spindrift.result.PageResult;
import com.spindrift.service.CommentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author 闫
 * @description 针对表【comment】的数据库操作Service实现
 * @createDate 2024-06-19 00:08:53
 */
@Service
@AllArgsConstructor
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment>
        implements CommentService {

    CommentMapper commentMapper;

    @Override
    public PageResult<Comment> pageQuery(PageQueryDTO pageQueryDTO) {
        Page<Comment> page = new Page<>(pageQueryDTO.getPage(), pageQueryDTO.getPageSize());
        Page<Comment> commonList = commentMapper.selectPage(page, null);
        return new PageResult<>(commonList.getTotal(), commonList.getRecords());
    }
}