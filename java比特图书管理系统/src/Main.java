import book.BookList;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import user.AdminUser;
import user.NormalUser;
import user.User;

import java.util.Scanner;

public class Main {
    public static User login(){
        System.out.println("请输入你的姓名");
        Scanner scanner=new Scanner(System.in);
        String name=scanner.next();
        System.out.println("请输入你的身份 0.普通用户  1.管理员");
        int n=scanner.nextInt();
        if(n==1){
            return new AdminUser(name);
        }else{
            return new NormalUser(name);
        }
    }


    public static void main(String[] args) {
       BookList bookList=new BookList();
        User user=login();
        while (true){
         int choice=user.menu();
         user.DoOperation(choice,bookList);
  }
    }
}
