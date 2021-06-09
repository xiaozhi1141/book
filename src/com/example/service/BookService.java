package com.example.service;

import com.example.pojo.Book;
import com.example.pojo.Page;

import java.util.List;

public interface BookService {
    void addBook(Book book);

    void deleteBookById(Integer id);

    void updateBook(Book book);

    Book queryBookById(Integer id);

    List<Book> queryBooks();

    Page<Book> page(int pageNo, int pageSize);

    Page<Book> pageByPrice(int pageNo, int pageSize, int min, int max);
    Page<Book> pageByCategory(int pageNo, int pageSize,String category);
}
