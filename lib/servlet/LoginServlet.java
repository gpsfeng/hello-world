package com.lib.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lib.reader.Admin;
import com.lib.reader.Reader;
import com.lib.service.AdminService;
import com.lib.service.ReaderService;


public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String type=request.getParameter("type");
		if(type!=null&&type.equals("reader")){
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		String key="";
		ReaderService readerService=new ReaderService();
		Reader reader=readerService.login(name,password);
		if(reader!=null){
			System.out.println("登录成功!");		//进入首页
			Reader r=new Reader();
			List<Reader>list=readerService.findReaderList(r);
			request.getSession().setAttribute("list",list);
			request.getSession().setAttribute("reader",reader);	//session对象数据作用域，针对同一个浏览器（同一个浏览器的不同窗口之间共享数据)
			request.getRequestDispatcher("index.html").forward(request,response);
		}
			else{
				System.out.println("登录失败!");
			}
		}
		else if(type!=null&&type.equals("admin")){
			String username=request.getParameter("username");
			String password=request.getParameter("password");
			String key="";
			AdminService adminService=new AdminService();
			Admin admin=adminService.login(username, password);
			if(admin!=null){
				System.out.println("登录成功!");
				request.getSession().setAttribute("admin",admin);
				request.getRequestDispatcher("adminindex.html").forward(request,response);
			}
		}
//		String username=request.getParameter("username");
//		AdminService adminService=new AdminService();
//		Admin admin=adminService.login(username, password);
//		if(admin!=null){
//			System.out.println("登录成功!");		//进入首页
//			Admin a=new Admin();
//			List<Admin>list=adminService.findAdminList(a);
//			request.getSession().setAttribute("list",list);
//			request.getSession().setAttribute("admin",admin);	//session对象数据作用域，针对同一个浏览器（同一个浏览器的不同窗口之间共享数据)
//			request.getRequestDispatcher("adminlist.jsp").forward(request,response);
//		}
//		else{
//			System.out.println("登录失败!");
//		}
	}
}
