package book.mapper;

import org.springframework.stereotype.Repository;
import book.pojo.User;

import java.util.List;

@Repository
public interface UserMapper {
    List<User> selectUser();

    void insert(User user);

    void update(User user);
}
