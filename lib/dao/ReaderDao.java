package com.lib.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lib.reader.Reader;

/**
 * �û��־ò�
 */
public class ReaderDao extends BaseDao{
	
	/**
	 * �û���¼
	 * @param userno  �˺�
	 * @param password  ����
	 * @return	��ǰ�û���¼����
	 */
	public Reader login(String name, String password){
		//��ѯ���ݿ⣬�Ա��˺������Ƿ�һ�£�һ�·���true�����򷵻�false
		String sql="SELECT * FROM reader WHERE name='"+name+"' AND `password`='"+password+"'";
		//1��������ݿ�����
		try {
			this.conn=this.getConn();
			//2�����ps����
			this.ps=conn.prepareStatement(sql);
			//3��ִ�в�ѯ����
			this.rs=ps.executeQuery();
			//4��ȡ���
			if(rs.next()){
				Reader reader=new Reader();		//���rs�������е�һ������
				int ri=rs.getInt("reader_id");
				String pwd=rs.getString("password");
				String phone=rs.getString("phone");
				String address=rs.getString("address");
				String n=rs.getString("name");
				String birth=rs.getString("birth");
				String sex=rs.getString("sex");
				reader.setReader_id(ri);
				reader.setPassword(pwd);
				reader.setPhone(phone);
				reader.setAddress(address);
				reader.setName(n);
				reader.setBirth(birth);
				reader.setSex(sex);
				return reader;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.closeAll();
		}
		return null;
	}
	public boolean addReader(Reader r) {
		String sql="insert into reader(name,sex,birth,address,phone,password) values('"+r.getName()+"','"+r.getSex()+"','"+r.getBirth()+"','"+r.getAddress()+"','"+r.getPhone()+"','"+r.getPassword()+"')";
		//1��������ݿ�����
		try {
			this.conn=this.getConn();
			//2�����ps����
			this.ps=conn.prepareStatement(sql);
			//3��ִ�и�������(�޸ġ�������ɾ��)
			int result=ps.executeUpdate();//�������ݿ���Ӱ�������
			if(result>0){
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	public List<Reader> findReaderList(Reader r) {
		String sql="SELECT * FROM reader";	
		try {
			this.conn=this.getConn();
			//2�����ps����
			this.ps=conn.prepareStatement(sql);
			//3��ִ�в�ѯ����
			this.rs=ps.executeQuery();
			//4��ȡ���
			List<Reader> list=new ArrayList<Reader>();
			while(rs.next()){
				Reader reader=new Reader();		//���rs�������е�һ������
				int id=rs.getInt("reader_id");
				String n=rs.getString("name");
				String sex=rs.getString("sex");
				String birth=rs.getString("birth");;
				String phone=rs.getString("phone");
				String address=rs.getString("address");
				String password=rs.getString("password");
				reader.setReader_id(id);
				reader.setName(n);
				reader.setSex(sex);
				reader.setBirth(birth);
				reader.setPhone(phone);
				reader.setAddress(address);
				reader.setPassword(password);
				list.add(reader);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
}
	public boolean updateReader(Reader r) {
			String sql="update reader set name='"+r.getName()+"',sex='"+r.getSex()+"',birth='"+r.getBirth()+"',address='"+r.getAddress()+"',phone='"+r.getPhone()+"'where reader_id="+r.getReader_id();
			try {
				this.conn=this.getConn();
				//2�����ps����
				this.ps=conn.prepareStatement(sql);
				//3��ִ�и�������(�޸ġ�������ɾ��)
				int result=ps.executeUpdate();//�������ݿ���Ӱ�������
				if(result>0){
					return true;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return false;
	}
	public boolean updatepwd(String newpwd,int id) {
		String sql="update reader set password='"+newpwd+"'where reader_id="+id;
		try {
			this.conn=this.getConn();
			//2�����ps����
			this.ps=conn.prepareStatement(sql);
			//3��ִ�и�������(�޸ġ�������ɾ��)
			int result=ps.executeUpdate();//�������ݿ���Ӱ�������
			if(result>0){
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	return false;
	}
	public boolean deleteReader(int reader_id) {
		String sql="delete from reader where reader_id="+reader_id;
		//1��������ݿ�����
		try {
			this.conn=this.getConn();
			//2�����ps����
			this.ps=conn.prepareStatement(sql);
			//3��ִ�и�������(�޸ġ�������ɾ��)
			int result=ps.executeUpdate();//�������ݿ���Ӱ�������
			if(result>0){
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	public List<Reader> findReaderById(int id) {
		String sql="SELECT * FROM reader WHERE reader.reader_id"+" LIKE'%"+id+"%'";;
		try {
			this.conn=this.getConn();
			//2�����ps����
			this.ps=conn.prepareStatement(sql);
			//3��ִ�в�ѯ����
			this.rs=ps.executeQuery();
			//4��ȡ���
			List<Reader> list=new ArrayList<Reader>();
			while(rs.next()){
				Reader reader=new Reader();		//���rs�������е�һ������
				int reader_id=rs.getInt("reader_id");
				String n=rs.getString("name");
				String sex=rs.getString("sex");
				String birth=rs.getString("birth");;
				String phone=rs.getString("phone");
				String address=rs.getString("address");
				String password=rs.getString("password");
				reader.setReader_id(reader_id);
				reader.setName(n);
				reader.setSex(sex);
				reader.setBirth(birth);
				reader.setPhone(phone);
				reader.setAddress(address);
				reader.setPassword(password);
				list.add(reader);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	