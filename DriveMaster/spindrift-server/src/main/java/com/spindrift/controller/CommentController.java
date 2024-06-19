package com.spindrift.controller;

import cn.dev33.satoken.util.SaResult;
import com.spindrift.dto.CommentDTO;
import com.spindrift.dto.PageQueryDTO;
import com.spindrift.entity.Comment;
import com.spindrift.result.PageResult;
import com.spindrift.service.CommentService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

/**
 * ClassName: CommentController
 * Package: com.spindrift.controller
 * Description:
 *
 * @Author 闫其武
 * @Create 2024/6/19 10:10
 * @Version 1.0
 */
@RestController
@Slf4j
@AllArgsConstructor
@RequestMapping("/admin/comment")
public class CommentController {

    CommentService commentService;

    @GetMapping("/page")
    public SaResult pageQuery(PageQueryDTO pageQueryDTO){
        log.info("pageResult:{}", pageQueryDTO);
        PageResult<Comment> pageResult = commentService.pageQuery(pageQueryDTO);
        return SaResult.data(pageResult);
    }

    @PostMapping
    public SaResult add(@RequestBody CommentDTO commentDTO){
        log.info("commentDTO:{}", commentDTO);
        Comment comment = new Comment();
        BeanUtils.copyProperties(commentDTO, comment);
        comment.setCreateTime(LocalDateTime.now());
        commentService.save(comment);

        return SaResult.ok();
    }
}
