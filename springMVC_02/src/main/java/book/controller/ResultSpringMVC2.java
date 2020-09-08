package book.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//数据跳转方法三：通过SpringMVC来实现转发和重定向 - 有视图解析器
//重定向, 不需要视图解析器, 本质就是重新请求一个新地方嘛, 所以注意路径问题
public class ResultSpringMVC2 {
    @RequestMapping("/rsm2/t1")
    public String test1(){
        //转发
        return "test";
    }
    @RequestMapping("/rsm2/t2")
    public String test2(){
        return "redirect:/index.jsp";
    }
}
