import model.Comment;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ModelTest {

    @Test
    public void test1(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("springConfig.xml");
        Comment comment = applicationContext.getBean("comment", Comment.class);
        Comment comment1 = applicationContext.getBean("comment", Comment.class);
        System.out.println(comment==comment1);

    }

}
