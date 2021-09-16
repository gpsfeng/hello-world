package com.lib.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lib.reader.Admin;
import com.lib.reader.Book;
import com.lib.service.AdminService;
import com.lib.service.BookService;
import com.lib.service.ReaderService;
import com.lib.reader.Reader;
/**
 * Servlet implementation class AdminServlet
 */
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Admin admin=new Admin();
		AdminService adminService=new AdminService();
		Reader reader=new Reader();
		ReaderService readerService=new ReaderService();
		Book book=new Book();
		BookService bookService=new BookService();
		String action=request.getParameter("action");
		if(action!=null&&action.equals("add")){
			String name=request.getParameter("name");
			String sex=request.getParameter("sex");
			String birth=request.getParameter("birth");
			String address=request.getParameter("address");
			String phone=request.getParameter("phone");
			String password=request.getParameter("password");
			reader.setName(name);
			reader.setSex(sex);
			reader.setBirth(birth);
			reader.setAddress(address);
			reader.setPhone(phone);
			reader.setPassword(password);
			boolean re=readerService.addReader(reader);
			if(re){
				System.out.println("新增成功!");
			}else{
				System.out.println("新增失败!");
			}
			request.getRequestDispatcher("readermanage.html").forward(request,response);
		}
		else if(action!=null&&action.equals("update")){
			int id=Integer.parseInt(request.getParameter("reader_id"));
			String name=request.getParameter("name");
			String sex=request.getParameter("sex");
			String birth=request.getParameter("birth");
			String address=request.getParameter("address");
			String phone=request.getParameter("phone");
			reader.setReader_id(id);
			reader.setPhone(phone);
			reader.setAddress(address);
			reader.setName(name);
			reader.setBirth(birth);
			reader.setSex(sex);
			boolean re=readerService.updateReader(reader);
			if(re){
				//修改成功
				System.out.println("修改成功!");
				request.getSession().removeAttribute("reader");
				request.getSession().setAttribute("reader",reader);
				request.getRequestDispatcher("readermanage.html").forward(request,response);
			}
		}
		else if(action!=null&&action.equals("delete")){
			int id=Integer.parseInt(request.getParameter("reader_id"));
			boolean re=readerService.deleteReader(id);
			if(re){
				//修改成功
				System.out.println("删除成功!");
				request.getSession().removeAttribute("reader");
				request.getSession().setAttribute("reader",reader);
				request.getRequestDispatcher("readermanage.html").forward(request,response);
			}
		}
		else if(action!=null&&action.equals("find")){
			int id=Integer.parseInt(request.getParameter("reader_id"));
			List<Reader>list=readerService.findReaderById(id);
			request.getSession().setAttribute("list",list);
			request.getRequestDispatcher("readerfindlist.jsp").forward(request,response);		
		}
		else if(action!=null&&action.equals("borrow")){
			int id=Integer.parseInt(request.getParameter("id"));
			String ISBN=request.getParameter("ISBN");
			String lend_date=request.getParameter("lend_date");
			String back_date=request.getParameter("back_date");
			boolean re=bookService.updateinfo(id,ISBN,lend_date,back_date);
			if(re){
			request.getRequestDispatcher("readermanage.html").forward(request,response);
			}
		}
		else if(action!=null&&action.equals("bookadd")){
			String ISBN=request.getParameter("ISBN");
			String name=request.getParameter("name");
			int class_id=Integer.parseInt(request.getParameter("class_id"));
			String class_name=request.getParameter("class_name");
			book.setISBN(ISBN);
			book.setName(name);
			book.setClass_id(class_id);
			book.setClass_name(class_name);
			boolean re=bookService.addbook(book);
			if(re){
				System.out.println("新增成功!");
			}else{
				System.out.println("新增失败!");
			}
			request.getRequestDispatcher("bookmanage.html").forward(request,response);
		}
		else if(action!=null&&action.equals("bookupdate")){
			String newdata=request.getParameter("newdata");
			String type=request.getParameter("type");
			String ISBN=request.getParameter("ISBN");
			boolean re=bookService.update(type,newdata,ISBN);
			if(re){
				System.out.println("修改成功!");
			}else{
				System.out.println("修改失败!");
			}request.getRequestDispatcher("bookmanage.html").forward(request,response);
		}
		else if(action!=null&&action.equals("record")){
			List<Book>booklist=bookService.findborrowrecord();
			request.getSession().setAttribute("booklist",booklist);
			request.getRequestDispatcher("borrowrecordlist.jsp").forward(request,response);
		}
	}
}

