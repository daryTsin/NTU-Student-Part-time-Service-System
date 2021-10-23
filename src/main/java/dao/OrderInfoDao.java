package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

import config.*;
import java.util.*;

import pojo.*;

public class OrderInfoDao {

public static Connection conn = null;
	
	/**
	 * 获取数据库连接
	 */
	private static Connection getConn(String dbName,String myUser,String myPassword) {
		Connection conn = null;
		try {
//			Class.forName(Constants.dbDriver);
			String myUrl = Constants.dbUrl;
			if(dbName != null) {
				myUrl = myUrl.replace("parttime_system", dbName);
			}
			
			if(myUser!=null) {
				conn = DriverManager.getConnection(myUrl,myUser,myPassword);
			}else {
				conn = DriverManager.getConnection(myUrl,Constants.username,Constants.password);
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
	
	public static List<OrderInfo> queryOrderInfo(String sql){
		List<OrderInfo> orderList = new ArrayList();
		Connection conn = getConn(null,null,null);
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			ResultSetMetaData md = rs.getMetaData();
			int size = md.getColumnCount();
			while(rs.next()) {
				
				OrderInfo one = new OrderInfo(rs.getInt("id"),
						rs.getInt("merchant_id"),
						rs.getString("title"),
						rs.getString("content"),
						rs.getString("location"),
						rs.getString("post_code"),
						rs.getString("work_period"),
						rs.getString("publish_time"),
						rs.getDouble("salary"),
						rs.getString("type"),
						rs.getInt("staff_number"),
						rs.getString("deadline"),
						rs.getString("status"));
				
				
				orderList.add(one);
				
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		closeConn(rs,ps,conn);
		
		return orderList;
	}
	
	public static boolean updateOrder(String sql) {
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
	
	public static boolean creaateOrder(String sql,OrderInfo info) {
		boolean res = true;
		Connection conn = getConn(null,null,null);
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(sql);
			if(sql.contains("?")) {
				ps.setInt(1, info.merchantId);
				ps.setString(2, info.title);
				ps.setString(3, info.content);
				ps.setString(4, info.location);
				ps.setString(5, info.postCode);
				ps.setString(6, info.workPeriod);
				ps.setDouble(8, info.salary);
				ps.setString(9, info.type);
				ps.setInt(10, info.staffNumber);
				ps.setString(11, info.deadline);
				ps.setString(12, info.status);
				
			}
			
			ps.executeUpdate();
			
			
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		
		closeConn(rs,ps,conn);
		
		
		return res;
		
	}
}
