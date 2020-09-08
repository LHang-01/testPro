package method2;

import org.aspectj.lang.JoinPoint;

public class DiyPointcut{
    //使用JoinPoint获取被通知方法的参数
    public void before(JoinPoint jp){
        System.out.println("----------before----------");
        System.out.print(jp.getSignature().getName()+"方法的参数是");
        Object[] args = jp.getArgs();
        for (Object arg : args) {
            System.out.print("参数：" + arg);
        }
        System.out.println();

    }

    //结合xml中配置returning="returnValue"，可获得返回值
    public void afterReturn(JoinPoint jp,Object returnValue){
        System.out.println("---------afterReturn-----------");
        System.out.println(jp.getSignature().getName()+"方法的执行结果是"+returnValue);
    }

    public void after(){
        System.out.println("after");
    }

}
