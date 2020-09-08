import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import book.service.UserService;

public class AopTest {
    @Test
    public void testMethod3(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("springConfig.xml");
        UserService userServer = applicationContext.getBean("userServiceImpl", UserService.class);
        userServer.add();
        userServer.delete();
        userServer.update();
        userServer.select();
    }
}
