package operation;

import book.Book;
import book.BookList;

import java.util.Scanner;

//归还图书
public class RuturnOperation implements  IOperation{
    @Override
    public void work(BookList bookList, int pos) {
        System.out.println("归还图书");
        Scanner scanner=new Scanner(System.in);
        System.out.println("输入你要归还书的名称");
        String name=scanner.next();
        for (int i = 0; i <bookList.getUsedSize() ; i++) {
            Book book=bookList.getBooks(i);
            if(book.getName().equals(name)){
                book.setBorrowed(false);
                System.out.println("归还成功");
                return;
            }
            System.out.println("没有这本书，归还失败!");
        }
    }
}
