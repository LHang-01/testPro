package book.mapper;

import model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    //增
    void insert(User user);

    //改
    void update(User user);

    //查
    //根据一个id查一个用户
    User selectByPrimaryKey(@Param("id") Long id);

    //根据ID集合查多个用户
    List<User> selectByPrimaryKeys(@Param("ids") List<Long> ids);

    //根据token查找用户
    List<User> findByToken(@Param("token") String token);

    //根据用户id查找用户
    List<User> findByAccountId(@Param("accountId") String accountId);

}
