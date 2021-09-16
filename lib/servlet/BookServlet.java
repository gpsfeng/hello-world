package com.lib.servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lib.reader.Book;
import com.lib.reader.Reader;
import com.lib.service.BookService;


public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public BookServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BookService bookService=new BookService();
		Book book=new Book();
		List<Book>list=bookService.findBookList(book);
		request.getSession().setAttribute("list",list);
		String action=request.getParameter("action");
		if(action!=null&&action.equals("record")){
			Reader r=(Reader)request.getSession().getAttribute("reader");
			String name=r.getName();
			List<Book> l=bookService.findByBorrowPeople(name);
			if(l!=null){
				request.getSession().setAttribute("l",l);
			}
			request.getRequestDispatcher("booklist.jsp").forward(request,response);
		}
		else if(action!=null&&action.equals("rank")){
			List<Book>list2=bookService.sort(book);
			request.getSession().setAttribute("list2",list2);
			request.getRequestDispatcher("sortlist.jsp").forward(request,response);
		}
		else if(action!=null&&action.equals("remind")){
			LocalDate day=LocalDate.now();
			String date=day.toString();	
			
		}
		else if(action!=null&&action.equals("find")){
			String type=request.getParameter("type");
			String data=request.getParameter("data");
			List<Book>findlist=bookService.findBykey(book,data,type);
			request.getSession().setAttribute("findlist",findlist);
			request.getRequestDispatcher("findlist.jsp").forward(request,response);
		}
		else if(action!=null&&action.equals("announce")){
			request.getRequestDispatcher("announce.html").forward(request,response);
		}
	}

}
