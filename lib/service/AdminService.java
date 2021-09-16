package com.lib.service;

import java.util.List;



import com.lib.dao.AdminDao;
import com.lib.reader.Admin;

public class AdminService {

	AdminDao adminDao=new AdminDao();
	public Admin login(String admin_id, String password) {	
		return adminDao.login(admin_id,password);
	}
	public List<Admin> findAdminList(Admin a) {
		return adminDao.findAdminList(a);
	}
	
	public boolean addAdmin(Admin admin){
		return adminDao.addAdmin(admin);
	}
	
//	public List<Reader> findReaderList(Reader r) {
//		return readerDao.findReaderList(r);
//	}
//	
//	public boolean addReader(Reader reader){
//		return readerDao.addReader(reader);
//	}
//	public boolean updateReader(Reader reader) {
//		return readerDao.updateReader(reader);
//	}
//	public boolean updatepwd(String newpwd, int id) {
//		return readerDao.updatepwd(newpwd,id);
//	}
//	public boolean deleteReader(int reader_id){
//		return readerDao.deleteReader(reader_id);
//	}
//	public List<Reader> findReaderById(int id) {
//		return readerDao.findReaderById(id);
//	}
}
