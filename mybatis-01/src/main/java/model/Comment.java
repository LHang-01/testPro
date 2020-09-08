package model;

public class Comment {
    //评论编号，自增
    private Long id;
    //父评论，即一级评论或二级评论所属的问题编号（question.id）
    private Long parentId;
    //评论类型，1表示一级评论（评论的问题），2表示二级评论（评论的一级评论）
    private Integer type;
    //本条评论的创建者
    private Long commentator;
    //创建时间
    private Long gmtCreator;
    //最后一次的修改时间
    private Long gmtModified;
    //点赞数量
    private Long likeCount;
    //评论内容
    private String content;
    //一级评论的评论数量，二级评论没有
    private Integer commentCount;

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", parentId=" + parentId +
                ", type=" + type +
                ", commentator=" + commentator +
                ", gmtCreator=" + gmtCreator +
                ", gmtModified=" + gmtModified +
                ", likeCount=" + likeCount +
                ", content='" + content + '\'' +
                ", commentCount=" + commentCount +
                '}';
    }

    public Comment(Long id, Long parentId, Integer type, Long commentator, Long gmtCreator, Long gmtModified, Long likeCount, String content, Integer commentCount) {
        this.id = id;
        this.parentId = parentId;
        this.type = type;
        this.commentator = commentator;
        this.gmtCreator = gmtCreator;
        this.gmtModified = gmtModified;
        this.likeCount = likeCount;
        this.content = content;
        this.commentCount = commentCount;
    }

    public Comment() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Long getCommentator() {
        return commentator;
    }

    public void setCommentator(Long commentator) {
        this.commentator = commentator;
    }

    public Long getGmtCreator() {
        return gmtCreator;
    }

    public void setGmtCreator(Long gmtCreator) {
        this.gmtCreator = gmtCreator;
    }

    public Long getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Long gmtModified) {
        this.gmtModified = gmtModified;
    }

    public Long getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(Long likeCount) {
        this.likeCount = likeCount;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }
}
