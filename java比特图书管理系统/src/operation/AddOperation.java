package operation;

import book.Book;
import book.BookList;

import java.util.Scanner;

//新增图书
public class AddOperation implements IOperation {
    @Override
    public void work(BookList bookList,int pos) {
        System.out.println("新增图书");
        Scanner scanner=new Scanner(System.in);
        System.out.println("输入书名");
        String name=scanner.next();
        System.out.println("输入作者");
        String author=scanner.next();
        System.out.println("输入书的类型");
        String type=scanner.next();
        System.out.println( "输入书的价格");
        int price=scanner.nextInt();
        Book book=new Book(name,author,type,price);
        int countSize= bookList.getUsedSize();
        bookList.setBooks(countSize,book);
        bookList.setUsedSize(countSize+1);
        System.out.println("添加成功!");
    }
}
