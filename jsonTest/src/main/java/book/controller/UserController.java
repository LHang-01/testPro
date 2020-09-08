package book.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import book.pojo.User;
import utils.JsonUtils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

//在类上直接使用@RestController，则该类所有方法都只会返回json字符串了，不用在每一个方法上都添加@ResponseBody！
//在前后端分离开发中，一般都使用 @RestController ，十分便捷！
@Controller
@RestController
public class UserController {
    @RequestMapping(value = "/json1", produces = "application/json;charset=utf-8")
    @ResponseBody
    public String json1() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        User user = new User("刘航",2,"女");
        //JSON与对象间的转换依赖于属性的set和get方法
        String string = mapper.writeValueAsString(user);
        //由于@ResponseBody注解，这里会将str转成json格式返回；十分方便
        return string;
    }

    @RequestMapping(value = "/json2")
    @ResponseBody
    public String json2() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        //创建一个对象
        User user1 = new User("刘航1", 3, "女");
        User user2 = new User("刘航2", 3, "女");
        User user3 = new User("刘航3", 3, "女");
        User user4 = new User("刘航4", 3, "女");
        ArrayList<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);

        String string = objectMapper.writeValueAsString(users);
        return string;
    }

    @RequestMapping("/json3")
    public String json3() throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();

        //创建时间一个对象，java.util.Date
        Date date = new Date();
        //将我们的对象解析成为json格式
        String str = mapper.writeValueAsString(date);//Jackson 默认是会把时间转成timestamps形式:变成一个数字，是1970年1月1日到当前日期的毫秒数
        return str;
    }

    @RequestMapping("/json4")
    public String json4() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        //不使用时间戳的方式
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        //自定义日期格式对象
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //指定日期格式
        mapper.setDateFormat(sdf);

        Date date = new Date();
        String str = mapper.writeValueAsString(date);

        return str;
    }

    @RequestMapping("/json5")
    public String json5() throws JsonProcessingException {
        Date date = new Date();
        String json = JsonUtils.getJson(date);
        return json;
    }
}
