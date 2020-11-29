package operation;

import book.Book;
import book.BookList;

import java.util.Scanner;

//借阅图书
public class BorrowOperation implements IOperation {
    @Override
    public void work(BookList bookList, int pos) {
        System.out.println("借阅图书");
        Scanner scanner=new Scanner(System.in);
        System.out.println("输入你要借阅的书籍");
        String name=scanner.next();
        for (int i = 0; i <bookList.getUsedSize() ; i++) {
            Book book=bookList.getBooks(i);
            if(book.getName().equals(name)){
                book.setBorrowed(true);
                System.out.println("借阅成功");
                return;
            }
            System.out.println("没有这本书");
        }
    }
}
