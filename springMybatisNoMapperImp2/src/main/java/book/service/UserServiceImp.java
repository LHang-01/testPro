package book.service;

import book.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import book.pojo.User;

@Service()
public class UserServiceImp implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public void operation(User user1, User user2) {
        userMapper.insert(user1);
        userMapper.update(user2);
    }
}
