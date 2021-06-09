package com.example.test;

import com.example.pojo.Book;
import com.example.pojo.Page;
import com.example.service.BookService;
import com.example.service.impl.BookServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

public class BookServiceTest {
    private BookService bookService = new BookServiceImpl();

    @Test
    public void addBook() {
        bookService.addBook(new Book(null,"python","python",new BigDecimal(76.88),12,24,null,"计算机"));
    }

    @Test
    public void deleteBookById() {
        bookService.deleteBookById(24);
    }

    @Test
    public void updateBook() {
        bookService.updateBook(new Book(24,"java","java",new BigDecimal(76.88),12,24,null,"计算机"));
    }

    @Test
    public void queryBookById() {
        System.out.println(bookService.queryBookById(24));
    }

    @Test
    public void queryBooks() {
        List<Book> books = bookService.queryBooks();
        for (Book book : books) {
            System.out.println(book);
        }
    }
    @Test
    public void page() {
        Page<Book> page = bookService.page(1,Page.PAGE_SIZE);
        System.out.println(page);
    }
    @Test
    public void pageByPrice() {
        Page<Book> page = bookService.pageByPrice(1,Page.PAGE_SIZE,10,50);
        System.out.println(page);
    }
}