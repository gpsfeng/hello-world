package com.lib.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;

import com.lib.reader.Reader;
import com.lib.service.ReaderService;


public class ReaderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ReaderServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Reader reader=new Reader();
		ReaderService readerService=new ReaderService();
		String action=request.getParameter("action");
		if(action!=null&&action.equals("regist")){
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
				System.out.println("注册成功!");
			}else{
				System.out.println("注册失败!");
			}
			request.getRequestDispatcher("Login.html").forward(request,response);
		}
		if(action!=null&&action.equals("updateinfo")){
			Reader r=(Reader)request.getSession().getAttribute("reader");
			int id=r.getReader_id();
			String pwd=r.getPassword();
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
			reader.setPassword(pwd);
			boolean re=readerService.updateReader(reader);
			if(re){
				//修改成功
				System.out.println("修改成功!");
				request.getSession().removeAttribute("reader");
				request.getSession().setAttribute("reader",reader);
				request.getRequestDispatcher("index.html").forward(request,response);
			}
		}
		if(action!=null&&action.equals("updatepassword")){
			Reader r=(Reader)request.getSession().getAttribute("reader");
			int id=r.getReader_id();
			String oldpwd=r.getPassword();
			String op=request.getParameter("oldpwd");
			String newpwd=request.getParameter("newpwd");
			if(oldpwd.equals(op)){
				boolean re=readerService.updatepwd(newpwd,id);
				if(re){
					System.out.println("修改成功!");
				}else{
					System.out.println("修改失败!");
				}
				request.getRequestDispatcher("index.html").forward(request,response);
			}else{
				request.getRequestDispatcher("index.html").forward(request,response);
			}
		}
	}

}
