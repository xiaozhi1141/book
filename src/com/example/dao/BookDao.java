package com.example.dao;

import com.example.pojo.Book;

import java.util.List;

public interface BookDao {

    int addBook(Book book);

    int deleteBookById(Integer id);

    int updateBook(Book book);

    Book queryBookById(Integer id);

    List<Book> queryBooks();

    Integer queryForPageTotalCount();

    List<Book> queryPageItems(int begin, int pageSize);

    Integer queryForPageTotalCountByPrice(int min, int max);

    List<Book> queryPageItemsByPrice(int begin, int pageSize, int min, int max);
    List<Book> queryPageItemsByCategory(int begin, int pageSize, String category);
    Integer queryPageTotalCountByCategory(String category);
}

