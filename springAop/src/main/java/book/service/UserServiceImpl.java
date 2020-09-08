package book.service;

public class UserServiceImpl implements UserService {
    public int add() {
        System.out.println("增加操作");
        return 0;
    }

    public int delete() {
        System.out.println("删除操作");
        return 1;
    }

    public int update() {
        System.out.println("更新操作");
        return 2;
    }

    public int select() {
        System.out.println("查询操作");
        return 3;
    }
}
