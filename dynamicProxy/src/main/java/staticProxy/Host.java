package staticProxy;

//真实角色
public class Host implements Rent {
    public void rent() {
        System.out.println("房屋出租");
    }
}
