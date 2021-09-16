package com.lib.service;

import java.util.List;

import com.lib.dao.ReaderDao;
import com.lib.reader.Reader;

public class ReaderService {
	ReaderDao readerDao=new ReaderDao();
	public Reader login(String reader_id, String password) {	
		return readerDao.login(reader_id,password);
	}
	public List<Reader> findReaderList(Reader r) {
		return readerDao.findReaderList(r);
	}
	
	public boolean addReader(Reader reader){
		return readerDao.addReader(reader);
	}
	public boolean updateReader(Reader reader) {
		return readerDao.updateReader(reader);
	}
	public boolean updatepwd(String newpwd, int id) {
		return readerDao.updatepwd(newpwd,id);
	}
	public boolean deleteReader(int reader_id){
		return readerDao.deleteReader(reader_id);
	}
	public List<Reader> findReaderById(int id) {
		return readerDao.findReaderById(id);
	}
}
