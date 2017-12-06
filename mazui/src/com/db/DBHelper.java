package com.db;

import java.sql.*;

public class DBHelper {	
	private String dbUrl="jdbc:mysql://localhost:3306/mazui";
	private String dbUser="root";
	private String dbPassword="root";
	private String jdbcName="com.mysql.jdbc.Driver";
	
	//连接数据库
	public Connection getConn(){
		Connection conn = null;
		try{
			Class.forName(jdbcName);
		}
		catch(Exception e){}
		try{
			//conn=DriverManager.getConnection(dbUrl,dbUser,dbPassword);
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/mazui?user=root&password=root&useUnicode=true&characterEncoding=utf-8" );
		}
		catch(SQLException ex){}
		return conn;		
	}
	
//    测试
	public static void main(String[] args)
	{
		System.out.println(new DBHelper().getConn());
		
	}
	
}
