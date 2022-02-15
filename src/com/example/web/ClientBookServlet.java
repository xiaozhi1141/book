package com.example.web;

import com.example.pojo.Book;
import com.example.pojo.Page;
import com.example.service.BookService;
import com.example.service.impl.BookServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ClientBookServlet extends BaseServlet{
    private BookService bookService = WebUtils.getBean(BookService.class);

    /**
     * 处理分页对象
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"),1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
        Page<Book> page = bookService.page(pageNo,pageSize);
        page.setUrl("client/BookServlet?action=page");
        req.setAttribute("page",page);
        req.getRequestDispatcher("/pages/client/index.jsp").forward(req,resp);
    }
    protected void pageByPrice(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"),1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
        int min = WebUtils.parseInt(req.getParameter("min"),0);
        int max = WebUtils.parseInt(req.getParameter("max"),Integer.MAX_VALUE);
        Page<Book> page = bookService.pageByPrice(pageNo,pageSize,min,max);
        StringBuilder stringBuilder = new StringBuilder("client/BookServlet?action=pageByPrice");
        if(req.getParameter("min")!=null){
            stringBuilder.append("&min=").append(req.getParameter("min"));
        }
        if(req.getParameter("max")!=null){
            stringBuilder.append("&max=").append(req.getParameter("max"));
        }
        page.setUrl(stringBuilder.toString());
        req.setAttribute("page",page);
        req.getRequestDispatcher("/pages/client/index.jsp").forward(req,resp);
    }

    protected void pageByCategory(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"),1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
        String category = req.getParameter("category");
        Page<Book> page = bookService.pageByCategory(pageNo,pageSize,category);
        StringBuilder stringBuilder = new StringBuilder("client/BookServlet?action=pageByPrice");
        stringBuilder.append("&category=").append(req.getParameter("category"));
        page.setUrl(stringBuilder.toString());
        req.setAttribute("page",page);
        req.getRequestDispatcher("/pages/client/index.jsp").forward(req,resp);
    }
}
