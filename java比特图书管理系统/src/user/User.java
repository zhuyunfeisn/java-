package user;

import book.Book;
import book.BookList;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import operation.IOperation;

public  abstract class User {
    String name;
    IOperation iOperations[];
    public User(String name) {
        this.name = name;
    }

    public abstract int menu();
    public void DoOperation(int choice, BookList bookList){
        this.iOperations[choice].work(bookList,choice);
    }

}
