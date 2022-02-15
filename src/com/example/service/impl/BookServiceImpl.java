package com.example.service.impl;

import com.example.dao.BookDao;
import com.example.dao.impl.BookDaoImpl;
import com.example.pojo.Book;
import com.example.pojo.Page;
import com.example.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookDao bookDao;

    @Override
    public void addBook(Book book) {
       bookDao.addBook(book);
    }

    @Override
    public void deleteBookById(Integer id) {
        bookDao.deleteBookById(id);
    }

    @Override
    public void updateBook(Book book) {
        bookDao.updateBook(book);
    }

    @Override
    public Book queryBookById(Integer id) {
        return bookDao.queryBookById(id);
    }

    @Override
    public List<Book> queryBooks() {
        return bookDao.queryBooks();
    }

    @Override
    public Page<Book> page(int pageNo, int pageSize) {
        Page<Book> page = new Page<Book>();
        //求总记录时
        Integer pageTotalCount = bookDao.queryForPageTotalCount();
        //设置记录数
        page.setPageTotalCount(pageTotalCount);
        //求总页码
        Integer PageTotal = pageTotalCount / pageSize;
        if( pageTotalCount % pageSize > 0){
            PageTotal++;
        }
        //总页码
        page.setPageTotal(PageTotal);
        page.setPageNo(pageNo);
        page.setPageSize(pageSize);
        int begin = (page.getPageNo() - 1) * pageSize;
        //请当前页数据
        List<Book> items = bookDao.queryPageItems(begin,pageSize);
        //设置当前页数据
        page.setItems(items);
        return page;
    }

    @Override
    public Page<Book> pageByPrice(int pageNo, int pageSize, int min, int max) {
        Page<Book> page = new Page<Book>();
        //求总记录时
        Integer pageTotalCount = bookDao.queryForPageTotalCountByPrice(min,max);
        //设置记录数
        page.setPageTotalCount(pageTotalCount);
        //求总页码
        Integer PageTotal = pageTotalCount / pageSize;
        if( pageTotalCount % pageSize > 0){
            PageTotal++;
        }
        //总页码
        page.setPageTotal(PageTotal);
        page.setPageNo(pageNo);
        page.setPageSize(pageSize);
        int begin = (page.getPageNo() - 1) * pageSize;
        //请当前页数据
        List<Book> items = bookDao.queryPageItemsByPrice(begin,pageSize,min,max);
        //设置当前页数据
        page.setItems(items);
        return page;
    }

    @Override
    public Page<Book> pageByCategory(int pageNo, int pageSize, String category) {
        Page<Book> page = new Page<Book>();
        //求总记录时
        Integer pageTotalCount = bookDao.queryPageTotalCountByCategory(category);
        //设置记录数
        page.setPageTotalCount(pageTotalCount);
        //求总页码
        Integer PageTotal = pageTotalCount / pageSize;
        if( pageTotalCount % pageSize > 0){
            PageTotal++;
        }
        //总页码
        page.setPageTotal(PageTotal);
        page.setPageNo(pageNo);
        page.setPageSize(pageSize);
        int begin = (page.getPageNo() - 1) * pageSize;
        //请当前页数据
        List<Book> items = bookDao.queryPageItemsByCategory(begin,pageSize,category);
        //设置当前页数据
        page.setItems(items);
        return page;
    }

}
