package book;

public class BookList {
    private Book []books=new Book[10];
    private int usedSize;

    public BookList() {
        books[0]=new Book("三国演义","罗贯中","小说",12);
        books[1]=new Book("西游记","吴承恩","小说",32);
        books[2]=new Book("水浒传","施耐庵","小说",18);
        this.usedSize=3;
    }

    public Book getBooks(int pos) {
       return books[pos];
    }

    public void setBooks(int pos,Book book) {
        this.books[pos]=book;
    }

    public int getUsedSize() {
        return usedSize;
    }

    public void setUsedSize(int usedSize) {
        this.usedSize = usedSize;
    }
}
