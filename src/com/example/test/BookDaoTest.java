package com.example.test;

import com.example.dao.BookDao;
import com.example.dao.impl.BookDaoImpl;
import com.example.pojo.Book;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

public class BookDaoTest {
    private BookDao bookDao = new BookDaoImpl();

    @Test
    public void addBook() {
        System.out.println(bookDao.addBook(new Book(null,"mysql","mysql",new BigDecimal(56.7),100,100,null,"计算机")));
    }

    @Test
    public void deleteBookById() {
        bookDao.deleteBookById(23);
    }

    @Test
    public void updateBook() {
        bookDao.updateBook(new Book(22,"mysql","mysql",new BigDecimal(56.7),120,120,null,"计算机"));
    }

    @Test
    public void queryBookById() {
        System.out.println(bookDao.queryBookById(23));
    }

    @Test
    public void queryBooks() {
        List<Book> books = bookDao.queryBooks();
        for (Book book : books) {
            System.out.println(book);
        }
    }
    @Test
    public void queryForPageTotalCount(){
        System.out.println(bookDao.queryForPageTotalCount());
    }

    @Test
    public void queryPageItems(){
        for (Book queryPageItem : bookDao.queryPageItems(0, 4)) {
            System.out.println(queryPageItem);
        }
    }
    @Test
    public void queryForPageTotalCountByPrice(){
        System.out.println(bookDao.queryForPageTotalCountByPrice(10,50));
    }

    @Test
    public void queryPageItemsByPrice(){
        for (Book queryPageItem : bookDao.queryPageItemsByPrice(0, 4,10,50)) {
            System.out.println(queryPageItem);
        }
    }
    @Test
    public void queryPageItemsByCategory() {
        for (Book queryPageItem : bookDao.queryPageItemsByCategory(0, 4, "铁路")) {
            System.out.println(queryPageItem);
        }
    }
    @Test
    public void pageByCategory(){
        System.out.println(bookDao.queryPageTotalCountByCategory("铁路"));
    }


}