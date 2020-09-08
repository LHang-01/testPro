package book.mapper;

import model.Notification;

import java.util.List;
import java.util.Map;

public interface NotificationMapper {
    //查询 接收通知者 需要接收的 通知数量
    Integer countByExample(Notification notification);

    //创建一个通知
    int insert(Notification record);

    //根据id取出通知
    Notification selectByPrimaryKey(Long id);

    //更新通知的状态（未读->已读）
    int updateByPrimaryKey(Notification record);

    //取出接收者需要接收的所有通知，按照创建时间降序排列，并分页
    List<Notification> selectByExampleWithRowbounds(Map param);

    //查询出该接受者所有已读或者未读的通知
    Long unreadCount(Notification notification);
}
