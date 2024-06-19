package com.spindrift.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.spindrift.dto.PageQueryDTO;
import com.spindrift.entity.Comment;
import com.spindrift.result.PageResult;

/**
 * @author 闫
 * @description 针对表【comment】的数据库操作Service
 * @createDate 2024-06-19 00:08:53
 */
public interface CommentService extends IService<Comment> {

    PageResult<Comment> pageQuery(PageQueryDTO pageQueryDTO);
}