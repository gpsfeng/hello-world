package com.lib.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lib.reader.Reader;

/**
 * 用户持久层
 */
public class ReaderDao extends BaseDao{
	
	/**
	 * 用户登录
	 * @param userno  账号
	 * @param password  密码
	 * @return	当前用户登录对象
	 */
	public Reader login(String name, String password){
		//查询数据库，对比账号密码是否一致，一致返回true，否则返回false
		String sql="SELECT * FROM reader WHERE name='"+name+"' AND `password`='"+password+"'";
		//1、获得数据库连接
		try {
			this.conn=this.getConn();
			//2、获得ps对象
			this.ps=conn.prepareStatement(sql);
			//3、执行查询命令
			this.rs=ps.executeQuery();
			//4、取结果
			if(rs.next()){
				Reader reader=new Reader();		//如果rs集合中有第一条数据
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
	public List<Reader> findReaderList(Reader r) {
		String sql="SELECT * FROM reader";	
		try {
			this.conn=this.getConn();
			//2、获得ps对象
			this.ps=conn.prepareStatement(sql);
			//3、执行查询命令
			this.rs=ps.executeQuery();
			//4、取结果
			List<Reader> list=new ArrayList<Reader>();
			while(rs.next()){
				Reader reader=new Reader();		//如果rs集合中有第一条数据
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
	public boolean updatepwd(String newpwd,int id) {
		String sql="update reader set password='"+newpwd+"'where reader_id="+id;
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
	public boolean deleteReader(int reader_id) {
		String sql="delete from reader where reader_id="+reader_id;
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
	public List<Reader> findReaderById(int id) {
		String sql="SELECT * FROM reader WHERE reader.reader_id"+" LIKE'%"+id+"%'";;
		try {
			this.conn=this.getConn();
			//2、获得ps对象
			this.ps=conn.prepareStatement(sql);
			//3、执行查询命令
			this.rs=ps.executeQuery();
			//4、取结果
			List<Reader> list=new ArrayList<Reader>();
			while(rs.next()){
				Reader reader=new Reader();		//如果rs集合中有第一条数据
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	