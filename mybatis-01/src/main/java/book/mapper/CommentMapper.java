package book.mapper;

import model.Comment;

import java.util.List;

public interface CommentMapper {
    //根据parent_id和评论类型查询出所有同级评论，并按照创建时间降序排列
    List<Comment> selectByExample(Comment comment);

    //插入一条评论
    void insert(Comment comment);

    //查询出指定id的评论
    Comment selectByPrimaryKey(Long parentId);

    //评论数量+1
    void incCommentCount(Comment parentComment);
}
