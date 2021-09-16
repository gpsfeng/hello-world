package com.lib.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BaseDao{
	private String url="jdbc:mysql://localhost:3306/bookmanager_db";	//���ݿ����ӵ�ַ
	private String driver="com.mysql.jdbc.Driver";//���ݿ����������
	private String dbName="root";//���ݿ��˺�
	private String dbPassWord="";//���ݿ�����
	Connection conn;//���ݿ����Ӷ���
	PreparedStatement ps;//����ִ�ж���
	ResultSet rs;//�洢���صĽ��
	/**
	 * �������ݿ����ӣ�������Ӷ���
	 * @return ���Ӷ���
	 * @throws ClassNotFoundException 
	 */
	public Connection getConn() {
		//��������
		try {
			Class.forName(driver);
			return DriverManager.getConnection(url,dbName,dbPassWord);
		} catch (Exception e) {
			// �쳣��Ϣд�뵽�ⲿ���ļ���ExceptionLog.txt
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
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
			conn=null;
		}
	}
	public ResultSet myQuery(String sql,Object[] obj) {
		try{
			//1����õ�ǰ���ݿ�����
			this.conn=this.getConn();
			//2�����ps����
			this.ps=conn.prepareStatement(sql);
		
			for (int i = 0; i < obj.length; i++) {
				ps.setObject(i+1, obj[i]);
			}
		
			//3��ִ�в�ѯ����
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
		
