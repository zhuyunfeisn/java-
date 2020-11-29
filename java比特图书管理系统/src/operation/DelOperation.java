package operation;

import book.Book;
import book.BookList;

import java.util.Scanner;

//删除图书
public class DelOperation implements  IOperation {
    @Override
    public void work(BookList bookList, int pos) {
        System.out.println("删除图书");
        Scanner scanner=new Scanner(System.in);
        System.out.println("输入需要删除书籍的名称");
        String name=scanner.next();
        int i=0;
        pos=0;
        for ( i = 0; i <bookList.getUsedSize() ; i++) {
            Book book=bookList.getBooks(i);
            if(book.getName().equals(name)){
                pos=i;
                break;
            }
        }
        if(i>=bookList.getUsedSize()){
            System.out.println("没有这本书");
            return;
        }
        for (int j= pos; j <bookList.getUsedSize()-1 ; j++) {
           Book book=bookList.getBooks(j+1);
           bookList.setBooks(j,book);
        }
        System.out.println("删除成功!");
    }
}
