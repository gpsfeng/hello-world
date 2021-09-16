package com.lib.service;

import java.util.List;

import com.lib.dao.BookDao;
import com.lib.reader.Book;

public class BookService {
	BookDao bookDao=new BookDao();
	public List<Book> findBookList(Book book){
		return bookDao.findBookList(book);
	}
	public List<Book> findByBorrowPeople(String name) {
		return bookDao.findByBorrowPeople(name);
	}
	public List<Book> sort(Book book) {
		return bookDao.sort(book);
		
	}
	public List<Book> findBykey(Book book, String key,String type) {
		return bookDao.findBykey(book,key,type);
	}
	public boolean updateinfo(int id, String ISBN, String lend_date,
			String back_date) {
		return bookDao.updateinfo(id,ISBN,lend_date,back_date);
	}
	public boolean addbook(Book book) {
		return bookDao.addbook(book);
	}
	public boolean update(String type, String newdata,String ISBN) {
		return bookDao.update(type,newdata,ISBN);	
	}
	public List<Book> findborrowrecord() {
		return bookDao.findborrowrecord();
	}
}
