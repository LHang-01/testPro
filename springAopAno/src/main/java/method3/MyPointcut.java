package method3;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component  //加入到IoC容器
@Aspect     //指定当前类为切面类
public class MyPointcut {

    @Pointcut("execution(* book.service.UserServiceImpl.*(..))")
    public void test() {}

    @Before(value = "test()")
    public void before(JoinPoint jp){
        System.out.println("----------before----------");
        System.out.print(jp.getSignature().getName()+"方法的参数是");
        Object[] args = jp.getArgs();
        for (Object arg : args) {
            System.out.print("参数：" + arg);
        }
        System.out.println();
    }

    @AfterReturning(pointcut = "test()", returning = "returnValue")
    public void afterReturn(JoinPoint jp,Object returnValue){
        System.out.println("---------afterReturn-----------");
        System.out.println(jp.getSignature().getName()+"方法的执行结果是"+returnValue);
    }

    @After(value = "test()")
    public void after(){
        System.out.println("after");
    }

}
