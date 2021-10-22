package service;
import dao.ApplyOrderDao;
import dao.CollectOrderDao;
import dao.UserinfoDao;
import dao.OrderInfoDao;
import pojo.*;

import java.util.*;

import config.*;

public class OrderService {
	
	/**
	 * ��������б�֧�����������Լ����ʷ�Χɸѡ
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
	 * ��ѯָ�����ӵ�����
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
	 * ѧ�����붩��
	 * @param studentId
	 * @param orderId
	 * @param remark
	 * @return
	 */
	public static String applyOrder(int studentId,int orderId,String remark) {
		
		List<Integer> oldOrders = ApplyOrderDao.getStudentOrderId(studentId);
		if(oldOrders.contains(orderId)) {
			return "������������������ظ�����";
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
		return "����ʧ��";
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
			return "��������ʧ��";
		}
		
	}
	
	public static String collectOrder(int studentId,int orderId) {
		String str = "�ղض���";
		String query = "SELECT * FROM " + TableName.COLLECT_ORDER_INFO
				+ "WHERE student_id = " + studentId;
		
		List<CollectOrderInfo> list = CollectOrderDao.queryOrderByStudent(query);
		String sql = "INSERT INTO " +TableName.COLLECT_ORDER_INFO
				+ " (student_id,order_id) VALUES ("
				+ studentId + "," + orderId +")";
		
		for(CollectOrderInfo one:list) {
			if(one.orderId == orderId) {
				sql = "DELETE FROM " + TableName.COLLECT_ORDER_INFO
						+"WHERE student_id = " + studentId
						+"AND order_id = " + orderId;
				str = "ȡ���ղض���";
				break;
			}
		}
		boolean res = CollectOrderDao.updateOrder(sql);
		
		if(res) {
			return str+"�ɹ�";
		}else {
			return str+"ʧ��";
		}
	}

	/**
	 * �̼һ�ȡ�ѷ������������֧��״̬������ɸѡ���Լ�����title��content
	 * @param merchantId
	 * @param status
	 * @param type
	 * @param search
	 * @return
	 */
	public static List<OrderInfo> getOrderByCondition(int merchantId,String status,String type,String search){
		String sql = "SELECT * FROM " + TableName.ORDER_INFO + "WHERE merchant_id ="
				+ merchantId;
		if(status != null && !"".equals(status)) {
			sql = sql + "AND status = " + status;
		}
		if(type != null && !"".equals(type)) {
			sql = sql + "AND type = " + type;
		}
		if(search != null && !"".equals(search)) {
			sql = sql + "AND (title like %" + search +"% OR content like %" + search+"%)";
		}
		
		List<OrderInfo> orders = OrderInfoDao.queryOrderInfo(sql);
		
		return orders;
		
		
	}
	
	/**
	 * ��ѯָ���̼�����ָ��״̬������ѧ����Ϣ
	 * @param merchantId
	 * @param status
	 * @return
	 */
	public static List<StudentApplyInfo> getApplyStudentByMerchant(int merchantId,String status){
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT a.*,b.* c.* FROM ")
		  .append(TableName.USER_INFO)
		  .append(" as a ,  ")
		  .append(TableName.STUDENT_APPLY_INFO)
		  .append(" as b , ")
		  .append(TableName.ORDER_INFO)
		  .append(" as c ")
		  .append(" WHERE a.id = b.student_id AND  c.merchant_id = ")
		  .append(merchantId)
		  .append(" AND b.order_id = c.id");
		
		if(status != null && !"".equals(status)) {
			sql.append(" AND a.status = ")
			  .append(status);
		}
		
		List<StudentApplyInfo> users = ApplyOrderDao.queryOrderInfo(sql.toString());
		
		return users;
	}
	
	public static String updateApplication(int studentId,int orderId,String status) {
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE ")
		  .append(TableName.STUDENT_APPLY_INFO)
		  .append(" SET status = ")
		  .append(status)
		  .append(" WHERE student_id = ")
		  .append(studentId)
		  .append(" AND order_id = ")
		  .append(orderId);
		
		boolean res = ApplyOrderDao.updateOrder(sql.toString());
		
		if(res) {
			return "success";
		}else {
			return "����״̬ʧ��";
		}
	}

}
