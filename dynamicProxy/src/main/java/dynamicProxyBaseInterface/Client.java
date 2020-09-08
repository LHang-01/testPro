package dynamicProxyBaseInterface;

public class Client {
    public static void main(String[] args) {
        //房东租房(真实角色)
        Rent host = (Rent) new Host();
        //代理实例的调用处理程序
        ProxyInvocationHandler handler = new ProxyInvocationHandler();
        //将真实角色放置进去！
        handler.setRent(host);
        //动态生成对应的代理类！
        Rent proxy = (Rent)handler.getProxy();
        //租房子
        proxy.rent();
    }
}
