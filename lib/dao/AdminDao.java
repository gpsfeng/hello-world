package com.lib.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lib.reader.Admin;

/**
 * 用户持久层
 */
public class AdminDao extends BaseDao{
	
	/**
	 * 用户登录
	 * @param userno  账号
	 * @param password  密码
	 * @return	当前用户登录对象
	 */
	public Admin login(String username, String password){
		//查询数据库，对比账号密码是否一致，一致返回true，否则返回false
		String sql="SELECT * FROM admin WHERE username='"+username+"' AND `password`='"+password+"'";
		//1、获得数据库连接
		try {
			this.conn=this.getConn();
			//2、获得ps对象
			this.ps=conn.prepareStatement(sql);
			//3、执行查询命令
			this.rs=ps.executeQuery();
			//4、取结果
			if(rs.next()){
				Admin admin=new Admin();		//如果rs集合中有第一条数据
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
		//1、获得数据库连接
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
	public List<Admin> findAdminList(Admin a) {
		String sql="SELECT * FROM admin";	
		try {
			this.conn=this.getConn();
			//2、获得ps对象
			this.ps=conn.prepareStatement(sql);
			//3、执行查询命令
			this.rs=ps.executeQuery();
			//4、取结果
			List<Admin> list=new ArrayList<Admin>();
			while(rs.next()){
				Admin admin=new Admin();		//如果rs集合中有第一条数据
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