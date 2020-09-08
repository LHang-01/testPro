package staticProxy;

//代理角色
public class Proxy implements Rent{

    private Rent rent;

    public Proxy(Rent rent) {
        this.rent = rent;
    }

    public void rent() {
        seeHouse();
        rent.rent();
        fare();
    }

    private void fare() {
        System.out.println("收取中介费");
    }

    private void seeHouse() {
        System.out.println("带房客看房");
    }

}
