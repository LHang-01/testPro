package book.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
//数据跳转方式一：通过ServletAPI, 不需要视图解析器
public class ServletAPI {
    @RequestMapping("/result/t1")
    public void test1(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.getWriter().println("Hello,Spring BY servlet API");
    }
    @RequestMapping("/result/t2")
    public void test2(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //重定向
        response.sendRedirect("/index.jsp");
    }
    @RequestMapping("/result/t3")
    public void test3(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //请求转发
        request.setAttribute("msg", "/result/t3");
        request.getRequestDispatcher("/WEB-INF/jsp/test.jsp").forward(request,response);
    }
}
