import book.service.UserService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AopTest {
    @Test
    public void testMethod1(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("springConfig.xml");
        UserService userServer = applicationContext.getBean("userServer", UserService.class);
        userServer.add();
        userServer.delete();
        userServer.update();
        userServer.select();
    }

    @Test
    public void testMethod2(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("springConfig.xml");
        UserService userServer = applicationContext.getBean("userServer", UserService.class);
        userServer.add();
        userServer.delete();
        userServer.update();
        userServer.select();

    }
}
