package user;

import operation.*;

import java.util.Scanner;

public class AdminUser extends User {
    public AdminUser(String name) {
        super(name);
        this.iOpetations=new IOpetation[]{
                new ExitOperation(),
                new FindOperation(),
                new AddOperation(),
                new DisplayOperation(),
                new ModifyOperation(),
                new DelOperation()
        };
    }

    @Override
    public int  menu() {
        System.out.println("hallo  "+this.name+"  欢迎来到学生信息管理系统");
        System.out.println("==============================");
        System.out.println("  0.退出系统");
        System.out.println("  1.查找学生信息");
        System.out.println("  2.增加学生信息");
        System.out.println("  3.显示学生信息");
        System.out.println("  4.修改学生信息");
        System.out.println("  5.删除学生信息");
        Scanner scanner=new Scanner(System.in);
        int choice=scanner.nextInt();
        return choice;
    }
}
