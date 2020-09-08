package staticProxy;

public class Client {
    public static void main(String[] args) {
        //房东租房
        Rent host = new Host();
        //中介帮助房东
        Proxy proxy = new Proxy(host);
        //租房子
        proxy.rent();
    }
}
