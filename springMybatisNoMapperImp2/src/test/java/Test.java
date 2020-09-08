import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import book.pojo.User;
import book.service.UserServiceImp;

public class Test {
    @org.junit.Test
    public void test2(){
//        ResourceLoader resourceLoader = new DefaultResourceLoader();
//        org.springframework.core.io.Resource re = resourceLoader.getResource("db.properties");

//        System.out.println(re);
        ApplicationContext context = new ClassPathXmlApplicationContext("spring_mybatis.xml");
        UserServiceImp userServiceImp = context.getBean("userServiceImp", UserServiceImp.class);
        User user1 = context.getBean("user1", User.class);
        User user2 = context.getBean("user2", User.class);
        userServiceImp.operation(user1,user2);
    }
}
