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


public class ApplyOrderDao {
	/**
	 * ��ȡ���ݿ�����
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
	 * �ر�����
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
	
	public static List<StudentApplyInfo> queryOrderInfo(String sql){
		List<StudentApplyInfo> orderList = new ArrayList();
		Connection conn = getConn(null,null,null);
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			ResultSetMetaData md = rs.getMetaData();
			int size = md.getColumnCount();
			while(rs.next()) {
				
				StudentApplyInfo one = new StudentApplyInfo(rs.getInt("id"),
						rs.getInt("student_id"),
						rs.getInt("order_id"),
						rs.getString("status"),
						rs.getString("remark"));
				
				Userinfo student = new Userinfo(rs.getInt("id"),
						rs.getString("account"),
						rs.getString("password"),
						"student",
						rs.getString("name"),
						rs.getString("matriculation_no"),
						rs.getString("gender"),
						rs.getInt("age"),
						rs.getString("nationality"),
						rs.getInt("year_of_study"),
						rs.getString("fin_no"),
						rs.getString("email"),
						rs.getString("phone_number"),
						rs.getString("degree"),
						rs.getString("remark"),
						rs.getString("program"),
						rs.getString("experience"));
				OrderInfo order = new OrderInfo(rs.getInt("id"),
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
				
				one.studentInfo = student;
				one.orderInfo = order;
				
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
	
	public static List<Integer> getStudentOrderId(int studentId){
		List<Integer> list = new ArrayList();
		String sql = "SELECT order_id FROM " + TableName.STUDENT_APPLY_INFO
				+ " WHERE student_id = " + studentId;
		Connection conn = getConn(null,null,null);
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			while(rs.next()) {
				
				list.add(rs.getInt("order_id"));
				
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		closeConn(rs,ps,conn);
		
		return list;
	}

}
