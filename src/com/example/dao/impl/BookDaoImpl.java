package com.example.dao.impl;

import com.example.dao.BookDao;
import com.example.pojo.Book;

import java.util.List;

public class BookDaoImpl extends BaseDao  implements BookDao {
    @Override
    public int addBook(Book book) {
        String sql = "insert into t_book(name,author,price,sales,stock,img_path,category) values(?,?,?,?,?,?,?)";
        return update(sql,book.getName(),book.getAuthor(),book.getPrice(),book.getSales(),book.getStock(),book.getImgPath(),book.getCategory());
    }

    @Override
    public int deleteBookById(Integer id) {
        String sql = "delete from t_book where id=?";
        return update(sql,id);
    }

    @Override
    public int updateBook(Book book) {
        String sql = "update t_book set name=?,author=?,price=?,sales=?,stock=?,img_path=?,category=? where id=?";
        return update(sql,book.getName(),book.getAuthor(),book.getPrice(),book.getSales(),book.getStock(),book.getImgPath(),book.getCategory(),book.getId());
    }

    @Override
    public Book queryBookById(Integer id) {
        String sql = "select id,name,author,price,sales,stock,img_path imgPath,category from t_book where id=?";
        return queryForOne(Book.class,sql,id);
    }

    @Override
    public List<Book> queryBooks() {
        String sql = "select id,name,author,price,sales,stock,img_path imgPath from t_book" ;
        return queryForList(Book.class,sql);
    }

    @Override
    public Integer queryForPageTotalCount() {
        String sql = "select count(*) from t_book";
        Number count = (Number) queryForSingleValue(sql);
        return count.intValue();
    }

    @Override
    public List<Book> queryPageItems(int begin, int pageSize) {
        String sql = "select id,name,author,price,sales,stock,img_path imgPath from t_book limit ?,?";
        return queryForList(Book.class, sql, begin, pageSize);
    }

    @Override
    public Integer queryForPageTotalCountByPrice(int min, int max) {
        String sql = "select count(*) from t_book where price between ? and ?";
        Number count = (Number) queryForSingleValue(sql,min,max);
        return count.intValue();
    }

    @Override
    public List<Book> queryPageItemsByPrice(int begin, int pageSize, int min, int max) {
        String sql = "select id,name,author,price,sales,stock,img_path imgPath from t_book where price between ? and ? order by price limit ?,?";
        return queryForList(Book.class, sql, min,max,begin, pageSize);
    }

    @Override
    public List<Book> queryPageItemsByCategory(int begin, int pageSize, String category) {
        String sql = "select id,name,author,price,sales,stock,img_path imgPath from t_book where category=? limit ?,?";
        return queryForList(Book.class, sql, category,begin, pageSize);
    }

    @Override
    public Integer queryPageTotalCountByCategory(String category) {
        String sql = "select count(*) from t_book where category=?";
        Number count = (Number) queryForSingleValue(sql,category);
        return count.intValue();
    }
}
