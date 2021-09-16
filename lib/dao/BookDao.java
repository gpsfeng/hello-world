package com.lib.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lib.reader.Book;

public class BookDao extends BaseDao{

	public List<Book> findBookList(Book book) {
		String sql="SELECT * FROM book";
		try {
			this.conn=this.getConn();
			//2、获得ps对象
			this.ps=conn.prepareStatement(sql);
			//3、执行查询命令
			this.rs=ps.executeQuery();
			//4、取结果
			List<Book> list=new ArrayList<Book>();
			while(rs.next()){
				Book b=new Book();		//如果rs集合中有第一条数据
				String ISBN=rs.getString("ISBN");
				String author=rs.getString("author");
				String publish=rs.getString("publish");
				String language=rs.getString("language");
				int price=rs.getInt("price");
				int class_id=rs.getInt("class_id");
				String name=rs.getString("name");
				String introduction=rs.getString("introduction");
				String pub_time=rs.getString("pub_time");
				int number=rs.getInt("number");
				String class_name=rs.getString("class_name");
				String borrowpeople=rs.getString("borrowpeople");
				String lend_date=rs.getString("lend_date");
				String back_date=rs.getString("back_date");
				int borrowtimes=rs.getInt("borrowtimes");
				b.setISBN(ISBN);
				b.setAuthor(author);
				b.setPublish(publish);
				b.setLanguage(language);
				b.setPrice(price);
				b.setClass_id(class_id);
				b.setName(name);
				b.setIntroduction(introduction);
				b.setPub_time(pub_time);
				b.setNumber(number);
				b.setClass_name(class_name);
				b.setBorrowpeople(borrowpeople);
				b.setLend_date(lend_date);
				b.setBack_date(back_date);
				b.setBorrowtimes(borrowtimes);
				list.add(b);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Book> findByBorrowPeople(String name) {
		String sql="SELECT * FROM book WHERE borrowpeople='"+name+"'";
		try {
			this.conn=this.getConn();
			//2、获得ps对象
			this.ps=conn.prepareStatement(sql);
			//3、执行查询命令
			this.rs=ps.executeQuery();
			//4、取结果
			List<Book>list=new ArrayList<Book>();
			while(rs.next()){
				Book b=new Book();		//如果rs集合中有第一条数据
				String ISBN=rs.getString("ISBN");
				String author=rs.getString("author");
				String publish=rs.getString("publish");
				String language=rs.getString("language");
				int price=rs.getInt("price");
				int class_id=rs.getInt("class_id");
				String n=rs.getString("name");
				String introduction=rs.getString("introduction");
				String pub_time=rs.getString("pub_time");
				int number=rs.getInt("number");
				String class_name=rs.getString("class_name");
				String borrowpeople=rs.getString("borrowpeople");
				String lend_date=rs.getString("lend_date");
				String back_date=rs.getString("back_date");
				int borrowtimes=rs.getInt("borrowtimes");
				b.setISBN(ISBN);
				b.setAuthor(author);
				b.setPublish(publish);
				b.setLanguage(language);
				b.setPrice(price);
				b.setClass_id(class_id);
				b.setName(n);
				b.setIntroduction(introduction);
				b.setPub_time(pub_time);
				b.setNumber(number);
				b.setClass_name(class_name);
				b.setBorrowpeople(borrowpeople);
				b.setLend_date(lend_date);
				b.setBack_date(back_date);
				b.setBorrowtimes(borrowtimes);
				list.add(b);
			}
			return list;
		}catch (SQLException e) {
		e.printStackTrace();
		}
	return null;
	}

	 public List<Book> sort(Book book) {
		String sql="select * from book ORDER BY borrowtimes DESC";
		try {
			this.conn=this.getConn();
			//2、获得ps对象
			this.ps=conn.prepareStatement(sql);
			//3、执行查询命令
			this.rs=ps.executeQuery();
			//4、取结果
			List<Book>list=new ArrayList<Book>();
			while(rs.next()){
				Book b=new Book();		//如果rs集合中有第一条数据
				String ISBN=rs.getString("ISBN");
				String author=rs.getString("author");
				String publish=rs.getString("publish");
				String language=rs.getString("language");
				int price=rs.getInt("price");
				int class_id=rs.getInt("class_id");
				String n=rs.getString("name");
				String introduction=rs.getString("introduction");
				String pub_time=rs.getString("pub_time");
				int number=rs.getInt("number");
				String class_name=rs.getString("class_name");
				String borrowpeople=rs.getString("borrowpeople");
				String lend_date=rs.getString("lend_date");
				String back_date=rs.getString("back_date");
				int borrowtimes=rs.getInt("borrowtimes");
				b.setISBN(ISBN);
				b.setAuthor(author);
				b.setPublish(publish);
				b.setLanguage(language);
				b.setPrice(price);
				b.setClass_id(class_id);
				b.setName(n);
				b.setIntroduction(introduction);
				b.setPub_time(pub_time);
				b.setNumber(number);
				b.setClass_name(class_name);
				b.setBorrowpeople(borrowpeople);
				b.setLend_date(lend_date);
				b.setBack_date(back_date);
				b.setBorrowtimes(borrowtimes);
				list.add(b);
			}
			return list;
		}
					catch (SQLException e) {
		e.printStackTrace();
		}
	return null;
	}

	public List<Book> findBykey(Book book, String key,String type) {
		String sql="SELECT * FROM book WHERE book."+type+" LIKE'%"+key+"%'";
		try {
			this.conn=this.getConn();
			//2、获得ps对象
			this.ps=conn.prepareStatement(sql);
			//3、执行查询命令
			this.rs=ps.executeQuery();
			//4、取结果
			List<Book>list=new ArrayList<Book>();
			while(rs.next()){
				Book b=new Book();		//如果rs集合中有第一条数据
				String ISBN=rs.getString("ISBN");
				String author=rs.getString("author");
				String publish=rs.getString("publish");
				String language=rs.getString("language");
				int price=rs.getInt("price");
				int class_id=rs.getInt("class_id");
				String n=rs.getString("name");
				String introduction=rs.getString("introduction");
				String pub_time=rs.getString("pub_time");
				int number=rs.getInt("number");
				String class_name=rs.getString("class_name");
				String borrowpeople=rs.getString("borrowpeople");
				String lend_date=rs.getString("lend_date");
				String back_date=rs.getString("back_date");
				int borrowtimes=rs.getInt("borrowtimes");
				b.setISBN(ISBN);
				b.setAuthor(author);
				b.setPublish(publish);
				b.setLanguage(language);
				b.setPrice(price);
				b.setClass_id(class_id);
				b.setName(n);
				b.setIntroduction(introduction);
				b.setPub_time(pub_time);
				b.setNumber(number);
				b.setClass_name(class_name);
				b.setBorrowpeople(borrowpeople);
				b.setLend_date(lend_date);
				b.setBack_date(back_date);
				b.setBorrowtimes(borrowtimes);
				list.add(b);
			}
			return list;
		}
					catch (SQLException e) {
		e.printStackTrace();
		}
	return null;
	}

	public boolean updateinfo(int id, String ISBN, String lend_date,String back_date){
		String sql="update book set borrowpeople='"+id+"',lend_date='"+lend_date+"',back_date='"+back_date+"'where ISBN='"+ISBN+"'";
		try {
			this.conn=this.getConn();
			//2、获得ps对象
			this.ps=conn.prepareStatement(sql);
			//3、执行更新命令(修改、新增、删除)
			int result=ps.executeUpdate();//返回数据库受影响的行数
			if(result>0){
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	return false;
}
	public boolean addbook(Book book) {
		String sql="insert into book(ISBN,name,class_id,class_name) values('"+book.getISBN()+"','"+book.getName()+"',"+book.getClass_id()+",'"+book.getClass_name()+"')";
		try {
			this.conn=this.getConn();
			//2、获得ps对象
			this.ps=conn.prepareStatement(sql);
			//3、执行更新命令(修改、新增、删除)
			int result=ps.executeUpdate();//返回数据库受影响的行数
			if(result>0){
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean update(String type, String newdata,String ISBN) {
		String sql="update book set "+type+"='"+newdata+"'where ISBN='"+ISBN+"'";
		try {
			this.conn=this.getConn();
			//2、获得ps对象
			this.ps=conn.prepareStatement(sql);
			//3、执行更新命令(修改、新增、删除)
			int result=ps.executeUpdate();//返回数据库受影响的行数
			if(result>0){
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	return false;
	}

	public List<Book> findborrowrecord() {
		String sql="select * from book where borrowpeople is not null";
		try {
			this.conn=this.getConn();
			//2、获得ps对象
			this.ps=conn.prepareStatement(sql);
			//3、执行查询命令
			this.rs=ps.executeQuery();
			//4、取结果
			List<Book>list=new ArrayList<Book>();
			while(rs.next()){
				Book b=new Book();		//如果rs集合中有第一条数据
				String ISBN=rs.getString("ISBN");
				String author=rs.getString("author");
				String publish=rs.getString("publish");
				String language=rs.getString("language");
				int price=rs.getInt("price");
				int class_id=rs.getInt("class_id");
				String n=rs.getString("name");
				String introduction=rs.getString("introduction");
				String pub_time=rs.getString("pub_time");
				int number=rs.getInt("number");
				String class_name=rs.getString("class_name");
				String borrowpeople=rs.getString("borrowpeople");
				String lend_date=rs.getString("lend_date");
				String back_date=rs.getString("back_date");
				int borrowtimes=rs.getInt("borrowtimes");
				b.setISBN(ISBN);
				b.setAuthor(author);
				b.setPublish(publish);
				b.setLanguage(language);
				b.setPrice(price);
				b.setClass_id(class_id);
				b.setName(n);
				b.setIntroduction(introduction);
				b.setPub_time(pub_time);
				b.setNumber(number);
				b.setClass_name(class_name);
				b.setBorrowpeople(borrowpeople);
				b.setLend_date(lend_date);
				b.setBack_date(back_date);
				b.setBorrowtimes(borrowtimes);
				list.add(b);
			}
			return list;
		}
					catch (SQLException e) {
		e.printStackTrace();
		}
	return null;
	}
}
