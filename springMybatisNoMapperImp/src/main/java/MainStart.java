import book.mapper.UserMapper;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.ResourceLoader;
import book.pojo.User;

import java.util.List;

public class MainStart {

    public static void main(String[] args) {


        ResourceLoader resourceLoader = new DefaultResourceLoader();
        org.springframework.core.io.Resource re = resourceLoader.getResource("db.properties");



        System.out.println(re);
        ApplicationContext context = new ClassPathXmlApplicationContext("spring_mybatis.xml");
        UserMapper mapper = (UserMapper) context.getBean("userMapper");
        List<User> user = mapper.selectUser();
        System.out.println(user);
    }

}
