import student.Student;
import student.StudentList;
import user.AdminUser;
import user.NormalUser;
import user.User;

import java.util.Scanner;

public class Main {
    public static User login(){
        System.out.println("请输入你的姓名");
        Scanner scanner=new Scanner(System.in);
        String name=scanner.next();
        System.out.println("请输入你的权限");
        System.out.println("0.普通学生 1.管理员");
        int n=scanner.nextInt();
        if(n==1){
         return new AdminUser(name);
        }
        return new NormalUser(name);
    }
    public static void main(String[] args) {
        StudentList studentList=new StudentList();
        User user=login();
        while (true){
          int choice=user.menu();
          user.DoOperation(choice,studentList);
        }
    }
}
