package dataProcessing;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import book.pojo.User;

@Controller
//提交普通数据
public class dataProcess {

    //提交的域名称和处理方法的参数名一致,例如: http://localhost:8080/dataProcess1?name=liuhang
    @RequestMapping("/dataProcess1")
    public String hello1(String name){
        System.out.println(name);
        return "hello";
    }

    //提交的域名称和处理方法的参数名不一致,例如: http://localhost:8080/dataProcess2?username=liuhang
    @RequestMapping("/dataProcess2")
    public String hello2(@RequestParam("username") String name){
        System.out.println(name);
        return "hello";
    }

    //提交的是一个对象, 要求提交的表单域和对象的属性名一致, 参数使用对象即可 ,例如：http://localhost:8080/dataProcess3?name=liuhang&id=1&age=15
    @RequestMapping("/dataProcess3")
    public String user(User user){
        System.out.println(user);
        return "hello";
    }

}
