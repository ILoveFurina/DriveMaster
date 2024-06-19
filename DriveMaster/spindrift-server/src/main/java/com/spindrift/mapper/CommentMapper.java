package com.spindrift.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.spindrift.entity.Comment;
import org.apache.ibatis.annotations.Mapper;

/**
* @author 闫
* @description 针对表【comment】的数据库操作Mapper
* @createDate 2024-06-19 09:09:20
* @Entity .Comment
*/
@Mapper
public interface CommentMapper extends BaseMapper<Comment> {

}




