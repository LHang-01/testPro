package model;

public class Notification {
    //编号，自增
    private Long id;
    //通知者，谁评论的，就是通知者
    private Long notifier;
    //接受者question.creator，评论的谁，就是接受者
    private Long receiver;
    //关联question.id，表示这条通知是因为哪一个评论而触发的
    private Long outerid;
    //通知类型，与outerid一起作为判断：是评论问题而产生通知还是评论一级评论而产生的通知
    private Integer type;
    //通知的创建时间
    private Long gmtCreate;
    //通知的状态（已读还是未读）
    private Integer status;
    //通知者名字commentator.name
    private String notifierName;
    //大纲question.title
    private String outerTitle;
}
