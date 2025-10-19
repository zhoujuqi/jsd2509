package oopday01today04test5;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books;  // 图书列表

    // 构造方法
    public Library() {
        this.books = new ArrayList<>();
    }

    // 添加图书
    public void addBook(Book book) {
        books.add(book);
        System.out.println("图书添加成功：" + book.getTitle());
    }

    // 删除图书（根据ISBN）
    public boolean removeBook(String isbn) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getIsbn().equals(isbn)) {
                Book removedBook = books.remove(i);
                System.out.println("图书删除成功：" + removedBook.getTitle());
                return true;
            }
        }
        System.out.println("未找到ISBN为：" + isbn + " 的图书");
        return false;
    }

    // 查询图书信息（根据书名）
    public void searchBookByTitle(String title) {
        List<Book> foundBooks = new ArrayList<>();
        for (Book book : books) {
            if (book.getTitle().contains(title)) {
                foundBooks.add(book);
            }
        }
        
        if (foundBooks.isEmpty()) {
            System.out.println("未找到包含 \"" + title + "\" 的图书");
        } else {
            System.out.println("找到以下图书：");
            for (Book book : foundBooks) {
                System.out.println(book);
            }
        }
    }

    // 查询图书信息（根据作者）
    public void searchBookByAuthor(String author) {
        List<Book> foundBooks = new ArrayList<>();
        for (Book book : books) {
            if (book.getAuthor().contains(author)) {
                foundBooks.add(book);
            }
        }
        
        if (foundBooks.isEmpty()) {
            System.out.println("未找到作者包含 \"" + author + "\" 的图书");
        } else {
            System.out.println("找到以下图书：");
            for (Book book : foundBooks) {
                System.out.println(book);
            }
        }
    }

    // 显示所有图书
    public void displayAllBooks() {
        if (books.isEmpty()) {
            System.out.println("图书馆中暂无图书");
        } else {
            System.out.println("图书馆中所有图书：");
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }

    // 获取图书总数
    public int getBookCount() {
        return books.size();
    }
}
