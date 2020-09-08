package dto;

import book.mapper.UserMapper;
import model.User;
import org.apache.log4j.Logger;
import org.junit.Test;
import util.MybatisUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

public class SingleMybatisTest {
    //注意导包：org.apache.log4j.Logger
    static Logger logger = Logger.getLogger(SingleMybatisTest.class);
    static UserMapper userMapper = MybatisUtils.getSession().getMapper(UserMapper.class);
    @Test
    public void userInsertTest(){
        User user = new User();
        user.setToken(UUID.randomUUID().toString());
        user.setName("xiaoming");
        user.setAccountId(UUID.randomUUID().toString());
        user.setAvatarUrl("githubUser.getAvatarUrl()");
        user.setGmtCreate(System.currentTimeMillis());
        user.setGmtModified(user.getGmtCreate());
        userMapper.insert(user);
    }

    @Test
    public void userUpdateTest(){
        User user = new User();
        user.setId((long) 1);
        user.setToken(UUID.randomUUID().toString());
        user.setName("xiaohong");
        user.setAccountId(UUID.randomUUID().toString());
        user.setAvatarUrl("githubGetAvatarUrl()");
        user.setGmtCreate(System.currentTimeMillis());
        user.setGmtModified(user.getGmtCreate());
        userMapper.update(user);
    }

    @Test
    public void selectByPrimaryKeyTest(){
        User user = userMapper.selectByPrimaryKey((long) 1);
        System.out.println(user);
    }

    @Test
    public void selectByPrimaryKeysTest(){
        ArrayList<Long> list = new ArrayList<Long>();
        list.add((long) 1);
        list.add((long) 3);
        List<User> users = userMapper.selectByPrimaryKeys(list);
        myPrint(users);
    }

    @Test
    public void findByTokenTest(){
        List<User> users = userMapper.findByToken("e9fc7196-2853-49b8-840d-e34fcd5021e7");
        myPrint(users);
    }


    @Test
    public void findByAccountIdTest(){
        List<User> users = userMapper.findByAccountId("498f1c26-551b-4171-8e1f-9ba613bd37df");
        myPrint(users);
    }

    public void myPrint(Collection<User> users) {
        for (User user:users){
            System.out.println(user);
        }
    }
}
