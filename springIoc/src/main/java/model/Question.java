package model;

public class Question {

    //问题编号
    private Long id;
    //问题标题
    private String title;
    //创建时间
    private Long gmtCreate;
    //修改时间
    private Long gmtModified;
    //发布人（User）的id
    private Long creator;
    //评论数量，初始化为0
    private Integer commentCount;
    //浏览数，初始化为0
    private Integer viewCount;
    //点赞数，初始化为0
    private Integer likeCount;
    //标签，只能选择，并且多个标签用“，”相隔存入存入数据库中。当从数据库中取出时需要用“，”切分取出各个标签，展示到页面
    private String tag;
    //问题描述（内容）
    private String description;

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", gmtCreate=" + gmtCreate +
                ", gmtModified=" + gmtModified +
                ", creator=" + creator +
                ", commentCount=" + commentCount +
                ", viewCount=" + viewCount +
                ", likeCount=" + likeCount +
                ", tag='" + tag + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public Question(Long id, String title, Long gmtCreate, Long gmtModified, Long creator, Integer commentCount, Integer viewCount, Integer likeCount, String tag, String description) {
        this.id = id;
        this.title = title;
        this.gmtCreate = gmtCreate;
        this.gmtModified = gmtModified;
        this.creator = creator;
        this.commentCount = commentCount;
        this.viewCount = viewCount;
        this.likeCount = likeCount;
        this.tag = tag;
        this.description = description;
    }

    public Question() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Long gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Long getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Long gmtModified) {
        this.gmtModified = gmtModified;
    }

    public Long getCreator() {
        return creator;
    }

    public void setCreator(Long creator) {
        this.creator = creator;
    }

    public Integer getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }

    public Integer getViewCount() {
        return viewCount;
    }

    public void setViewCount(Integer viewCount) {
        this.viewCount = viewCount;
    }

    public Integer getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(Integer likeCount) {
        this.likeCount = likeCount;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
