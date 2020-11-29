package user;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import operation.ExitOperation;
import operation.FindOperation;
import operation.IOpetation;

import java.util.Scanner;

public class NormalUser extends User{
    public NormalUser(String name) {
        super(name);
        this.iOpetations=new IOpetation[]{
                new ExitOperation(),
                new FindOperation()
        };
    }

    @Override
    public int menu() {
        System.out.println("hello  "+this.name+"欢迎来到图书管理系统");
        System.out.println("====================");
        System.out.println("0.退出系统");
        System.out.println("1.查找学生信息");
        Scanner scanner=new Scanner(System.in);
        int choice=scanner.nextInt();
        return choice;
    }
}
