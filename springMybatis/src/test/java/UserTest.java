import book.mapper.UserMapper;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import book.pojo.User;

import java.io.IOException;
import java.util.List;

public class UserTest {
    @Test
    public void test1() throws IOException {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        UserMapper mapper = (UserMapper) context.getBean("userDao");
        List<User> user = mapper.selectUser();
        System.out.println(user);
    }
}
