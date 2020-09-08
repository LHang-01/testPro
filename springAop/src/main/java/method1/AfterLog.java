package method1;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;
//后置通知
public class AfterLog implements AfterReturningAdvice {
    /**
     *
     * @param returnValue 返回值
     * @param method 被调用的方法
     * @param args 被调用方法的参数
     * @param target 被调用的目标对象
     * @throws Throwable
     */
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        System.out.println(target.getClass().getName()+"的"+method.getName()+"方法的执行结果是"+returnValue);
    }
}
