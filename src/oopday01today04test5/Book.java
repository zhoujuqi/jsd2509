package oopday01today04test5;

public class Book {
    private String title;      // 书名
    private String author;     // 作者
    private String publisher;  // 出版社
    private String isbn;       // ISBN

    // 构造方法
    public Book(String title, String author, String publisher, String isbn) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.isbn = isbn;
    }

    // Getter 方法
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getIsbn() {
        return isbn;
    }

    // Setter 方法
    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Override
    public String toString() {
        return "Book{" +
                "书名='" + title + '\'' +
                ", 作者='" + author + '\'' +
                ", 出版社='" + publisher + '\'' +
                ", ISBN='" + isbn + '\'' +
                '}';
    }
}
