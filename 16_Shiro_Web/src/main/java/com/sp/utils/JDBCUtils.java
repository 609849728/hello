package com.sp.utils;

import java.sql.*;

public class JDBCUtils {
	
	//加载驱动并连接数据库
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		String driverName="com.mysql.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/shiro";
		String user="root";
		String password="root";
		
		Class.forName(driverName);
		
		Connection conn = DriverManager.getConnection(url, user, password);
		
		return conn;
	}
	
	//关闭数据库连接，释放资源
	public static void close(Statement stmt,Connection conn) {
		if(stmt!=null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				stmt=null;
			}
		}
		
		if(conn!=null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				conn=null;
			}
		}
	}
	
	public static void close(ResultSet rs,Statement stmt,Connection conn) {
		if(rs!=null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				rs=null;
			}
		}
		close(stmt, conn);
	}
	
	
}
