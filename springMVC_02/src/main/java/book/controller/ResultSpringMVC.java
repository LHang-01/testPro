package book.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//数据跳转方式二：通过SpringMVC来实现转发和重定向 - 无需视图解析器
//测试前，需要将视图解析器注释掉
public class ResultSpringMVC {
    @RequestMapping("rsm/t1")
    public String test1(){
        //请求转发
        return "/index.jsp";
    }
    @RequestMapping("rsm/t2")
    public String test2(){
        //转发二
        return "forward:/index.jsp";
    }
    @RequestMapping("rsm/t3")
    public String test3(){
        //转发二
        return "redirect:/index.jsp";
    }
}
