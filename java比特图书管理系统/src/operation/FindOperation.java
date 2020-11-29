package operation;

import book.Book;
import book.BookList;

import java.util.Scanner;

//查找图书
public class FindOperation implements  IOperation{
    @Override
    public void work(BookList bookList, int pos) {
        System.out.println("查找图书");
        System.out.println("请输入你要查找书的书名");
        Scanner scanner=new Scanner(System.in);
        String name=scanner.next();
        for (int i = 0; i <bookList.getUsedSize() ; i++) {
            Book book=bookList.getBooks(i);
            if(book.getName().equals(name)) {//字符串比较要调用equals
                System.out.println("查找成功");
                System.out.println(book);
                return;
            }
            }
        System.out.println("查找失败");
        }

    }

