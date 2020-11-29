package operation;

import book.Book;
import book.BookList;

//显示所有图书
public class DisplayOperation implements IOperation {
    @Override
    public void work(BookList bookList, int pos) {
        System.out.println("显示所有图书");
        for (int i = 0; i <bookList.getUsedSize() ; i++) {
            Book book=bookList.getBooks(i);
            System.out.println(book);
        }
        System.out.println("显示成功!");
    }
}
