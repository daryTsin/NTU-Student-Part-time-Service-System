package dao;
import java.sql.*;
import java.util.*;

import pojo.*;

public class UserinfoDao {

	private static final String dbDriver = "com.mysql.cj.jdbc.Driver";
	private static final String dbUrl = "jdbc:mysql://localhost:3306/parttime_system?&useSSL=false";
	private static final String username = "root";
	private static final String password = "aini119120";
	public static Connection conn = null;
	
	/**
	 * 获取数据库连接
	 */
	private static Connection getConn(String dbName,String myUser,String myPassword) {
		Connection conn = null;
		try {
			Class.forName(dbDriver);
			String myUrl = dbUrl;
			if(dbName != null) {
				myUrl = myUrl.replace("parttime_system", dbName);
			}
			
			if(myUser!=null) {
				conn = DriverManager.getConnection(myUrl,myUser,myPassword);
			}else {
				conn = DriverManager.getConnection(myUrl,username,password);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return conn;
	}
	
	/**
	 * 关闭连接
	 * @param rs
	 * @param ps
	 * @param conn
	 */
	private static void closeConn(ResultSet rs, PreparedStatement ps, Connection conn) {
		if(rs != null) {
			try {
				rs.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		if(ps != null) {
			try {
				ps.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		if(conn != null) {
			try {
				conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public static List<List<Object>> getDataBySql(String dbName,String myUser,String myPassword,
			String sql){
		Connection conn = getConn(dbName,myUser,myPassword);
		PreparedStatement ps = null;
		List<List<Object>> list = new ArrayList();
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			ResultSetMetaData md = rs.getMetaData();
			int size = md.getColumnCount();
			while(rs.next()) {
				List<Object> oneRow = new ArrayList();
				for(int i=1;i<=size;i++) {
					oneRow.add(rs.getObject(i)==null?"":rs.getObject(i));
				}
				list.add(oneRow);
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public static List<Userinfo> queryAccoutInfo(String sql){
		List<Userinfo> userList = new ArrayList();
		Connection conn = getConn(null,null,null);
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			ResultSetMetaData md = rs.getMetaData();
			int size = md.getColumnCount();
			while(rs.next()) {
				
				Userinfo one = new Userinfo(rs.getInt("id"),
						rs.getString("account"),
						rs.getString("password"),
						rs.getString("type"),
						rs.getString("name"),
						rs.getString("matriculation_no"),
						rs.getString("gender"),
						rs.getInt("age"),
						rs.getString("nationality"),
						rs.getInt("yearOfStudy"),
						rs.getString("finNo"),
						rs.getString("email"),
						rs.getString("phoneNumber"),
						rs.getString("degree"),
						rs.getString("remark"),
						rs.getString("program"),
						rs.getString("experience"));
				
				userList.add(one);
				
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		closeConn(rs,ps,conn);
		
		return userList;
	}
	
	public static boolean updateUser(String sql) {
		boolean res = true;
		Connection conn = getConn(null,null,null);
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.executeUpdate();
			
			
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		
		closeConn(rs,ps,conn);
		
		
		return res;
		
	}
	
	public static void main(String[] args) {
		String sql = "select * from user_info";
		List<List<Object>> list = getDataBySql(null,null,null,sql);
		System.out.print(list);
	}
	
	
}
