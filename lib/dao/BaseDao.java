package com.lib.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BaseDao{
	private String url="jdbc:mysql://localhost:3306/bookmanager_db";	//数据库连接地址
	private String driver="com.mysql.jdbc.Driver";//数据库驱动入口类
	private String dbName="root";//数据库账号
	private String dbPassWord="";//数据库密码
	Connection conn;//数据库连接对象
	PreparedStatement ps;//命令执行对象
	ResultSet rs;//存储返回的结果
	/**
	 * 创建数据库连接，获得连接对象
	 * @return 连接对象
	 * @throws ClassNotFoundException 
	 */
	public Connection getConn() {
		//加载驱动
		try {
			Class.forName(driver);
			return DriverManager.getConnection(url,dbName,dbPassWord);
		} catch (Exception e) {
			// 异常信息写入到外部的文件里ExceptionLog.txt
			e.printStackTrace();
		}
		return  null;
	}
	public void closeAll(){
		if(rs!=null){
			try {
				rs.close();
				rs=null;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(ps!=null){
			try {
				ps.close();
				ps=null;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			conn=null;
		}
	}
	public ResultSet myQuery(String sql,Object[] obj) {
		try{
			//1、获得当前数据库连接
			this.conn=this.getConn();
			//2、获得ps对象
			this.ps=conn.prepareStatement(sql);
		
			for (int i = 0; i < obj.length; i++) {
				ps.setObject(i+1, obj[i]);
			}
		
			//3、执行查询命令
			this.rs=ps.executeQuery();
			return rs;
		} catch (Exception e){
			e.printStackTrace();
		}
		return null;
	}
	public static void main(String[]args){
		Connection conn=new BaseDao().getConn();
		System.out.println(conn);
	}
}
		
