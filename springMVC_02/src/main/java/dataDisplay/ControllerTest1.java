package dataDisplay;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//数据显示到前端的三种方式
//Model 只有寥寥几个方法只适合用于储存数据，简化了新手对于Model对象的操作和理解；
//ModelMap 继承了 LinkedMap ，除了实现了自身的一些方法，同样的继承 LinkedMap 的方法和特性；
//ModelAndView 可以在储存数据的同时，可以进行设置返回的逻辑视图，进行控制展示层的跳转。
public class ControllerTest1 implements Controller {
    //一：通过ModelAndView
    @Override
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("msg","ControllerTest1");
        modelAndView.setViewName("test");
        return modelAndView;
    }
}
