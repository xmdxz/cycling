package com.cycling.service.impl;

import com.cycling.dao.CommentDao;
import com.cycling.pojo.Comment;
import com.cycling.service.CommentService;
import com.cycling.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import java.sql.Timestamp;
import java.util.List;

/**
 * @ClassName: CommentServiceImpl
 * @Author: RainGoal
 * @Description: TODO
 * @Date: 2021/10/29 7:22 下午
 */

public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentDao commentDao;

    @Override
    public ResponseResult findCommentByDynamic(Integer id) {
        List<Comment> commentByDynamic = commentDao.findCommentByDynamic(id);
        return ResponseResult.ok(commentByDynamic);
    }

    @Override
    public ResponseResult addComment(Comment comment) {
        comment.setTime(new Timestamp(System.currentTimeMillis()));
        int i = commentDao.addComment(comment);
        if (i != 0) {
            ResponseResult.ok();
        }
        return ResponseResult.error("评论失败", HttpStatus.BAD_REQUEST.value());
    }

    @Override
    public ResponseResult deleteComment(Integer id) {
        int i = commentDao.deleteComment(id);
        if (i != 0) {
            ResponseResult.ok();
        }
        return ResponseResult.error("删除失败", HttpStatus.BAD_REQUEST.value());
    }
}
