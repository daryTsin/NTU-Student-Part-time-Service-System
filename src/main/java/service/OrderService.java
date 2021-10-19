package service;
import dao.ApplyOrderDao;
import dao.UserinfoDao;
import dao.OrderInfoDao;
import pojo.*;

import java.util.*;

import config.*;

public class OrderService {
	
	/**
	 * 浏览帖子列表，支持搜索功能以及工资范围筛选
	 * @param search
	 * @param leastSalary
	 * @param mostSalary
	 * @return
	 */
	public static List<OrderInfo> getOrderList(String search,double leastSalary,double mostSalary){
		List<OrderInfo> orders = new ArrayList();
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append("SELECT * FROM ").append(TableName.ORDER_INFO)
		  .append("WHERE salary >=").append(leastSalary);
		
		if(mostSalary != 0) {
			sqlBuilder.append("AND salary <=").append(mostSalary);
		}
		if(search != null && !"".equals(search)) {
			sqlBuilder.append("AND ( title like %")
			  .append(search).append("%")
			  .append("OR content like %")
			  .append(search).append("%")
			  .append("OR location like %")
			  .append(search).append("% )");
		}
		
		orders = OrderInfoDao.queryOrderInfo(sqlBuilder.toString());
		
		return orders;
	}
	
	/**
	 * 查询指定帖子的详情
	 * @param id
	 * @return
	 */
	public static OrderInfo getOrderDetail(int id) {
		List<OrderInfo> orders = new ArrayList();
		String sql = "SELECT * FROM " + TableName.ORDER_INFO
				+ "WHERE id = " + id;
		
		orders = OrderInfoDao.queryOrderInfo(sql);
		
		if(orders == null || orders.isEmpty()) {
			return null;
		}
		
		return orders.get(0);
	}
	
	/**
	 * 学生申请订单
	 * @param studentId
	 * @param orderId
	 * @param remark
	 * @return
	 */
	public static String applyOrder(int studentId,int orderId,String remark) {
		
		List<Integer> oldOrders = ApplyOrderDao.getStudentOrderId(studentId);
		if(oldOrders.contains(orderId)) {
			return "订单已申请过，请勿重复申请";
		}
		
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append("INSERT INTO ")
		  .append(TableName.STUDENT_APPLY_INFO)
		  .append("( student_id, order_id,remark) VALUES (")
		  .append(studentId)
		  .append(",")
		  .append(orderId)
		  .append(",")
		  .append(remark)
		  .append(")");
		
		boolean res = ApplyOrderDao.updateOrder(sqlBuilder.toString());
		if(res) {
			return "success";
		}
		return "申请失败";
	}
	
	public static String publishOrder(int merchantId,OrderInfo info) {
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO ")
		  .append(TableName.ORDER_INFO)
		  .append(" ( merchant_id,title, content, location, post_code, work_period, publish_time, salary, type,"
		  		+ " staff_number, deadline, status ) VALUES (")
		  .append(merchantId)
		  .append(", ")
		  .append(info.title)
		  .append(",")
		  .append(info.content)
		  .append(",")
		  .append(info.location)
		  .append(",")
		  .append(info.postCode)
		  .append(",")
		  .append(info.workPeriod)
		  .append(",")
		  .append(info.publishTime)
		  .append(",")
		  .append(info.salary)
		  .append(",")
		  .append(info.type)
		  .append(",")
		  .append(info.staffNumber)
		  .append(",")
		  .append(info.deadline)
		  .append(",")
		  .append(info.status)
		  .append(")");
		
		boolean res = OrderInfoDao.updateOrder(sql.toString());
		
		if(res) {
			return "success";
		}else {
			return "发布订单失败";
		}
		
	}


}
