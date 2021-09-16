package com.lib.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lib.reader.Admin;

/**
 * �û��־ò�
 */
public class AdminDao extends BaseDao{
	
	/**
	 * �û���¼
	 * @param userno  �˺�
	 * @param password  ����
	 * @return	��ǰ�û���¼����
	 */
	public Admin login(String username, String password){
		//��ѯ���ݿ⣬�Ա��˺������Ƿ�һ�£�һ�·���true�����򷵻�false
		String sql="SELECT * FROM admin WHERE username='"+username+"' AND `password`='"+password+"'";
		//1��������ݿ�����
		try {
			this.conn=this.getConn();
			//2�����ps����
			this.ps=conn.prepareStatement(sql);
			//3��ִ�в�ѯ����
			this.rs=ps.executeQuery();
			//4��ȡ���
			if(rs.next()){
				Admin admin=new Admin();		//���rs�������е�һ������
				int id=rs.getInt("admin_id");
				String pwd=rs.getString("password");
				String n=rs.getString("username");
				admin.setAdmin_id(id);
				admin.setPassword(pwd);
				admin.setUsername(n);
				return admin;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.closeAll();
		}
		return null;
	}
	public boolean addAdmin(Admin a) {
		String sql="insert into admin(username,password) values('"+a.getUsername()+"','"+a.getPassword()+"')";
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
	public List<Admin> findAdminList(Admin a) {
		String sql="SELECT * FROM admin";	
		try {
			this.conn=this.getConn();
			//2�����ps����
			this.ps=conn.prepareStatement(sql);
			//3��ִ�в�ѯ����
			this.rs=ps.executeQuery();
			//4��ȡ���
			List<Admin> list=new ArrayList<Admin>();
			while(rs.next()){
				Admin admin=new Admin();		//���rs�������е�һ������
				int id=rs.getInt("admin_id");
				String n=rs.getString("username");
				String password=rs.getString("password");
				admin.setAdmin_id(id);
				admin.setUsername(n);
				admin.setPassword(password);
				list.add(admin);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}