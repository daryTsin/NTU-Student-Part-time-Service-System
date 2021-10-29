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
	public static List<OrderInfo> getOrderList(String search,double leastSalary,double mostSalary,String type){
		List<OrderInfo> orders = new ArrayList();
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append("SELECT * FROM ").append(TableName.ORDER_INFO)
		  .append(" WHERE salary > ").append(leastSalary);
		
		if(mostSalary != 0) {
			sqlBuilder.append(" AND salary <=").append(mostSalary);
		}
		if(type != null) {
			sqlBuilder.append(" AND type =").append(type);
		}
		if(search != null && !"".equals(search)) {
			sqlBuilder.append(" AND ( title like '%")
			  .append(search).append("%'")
			  .append(" OR content like '%")
			  .append(search).append("%'")
			  .append(" OR location like '%")
			  .append(search).append("%' )");
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
				+ " WHERE id = " + id;
		
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
		System.out.println(oldOrders);
		if(oldOrders.contains(orderId)) {
			return "You have already applied this order!";
		}
		
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append("INSERT INTO ")
		  .append(TableName.STUDENT_APPLY_INFO)
		  .append("( student_id, order_id,remark,status) VALUES (")
		  .append(studentId)
		  .append(",")
		  .append(orderId)
		  .append(",")
		  .append(remark)
		  .append(",'processing'")
		  .append(")");
		
		boolean res = ApplyOrderDao.updateOrder(sqlBuilder.toString());
		if(res) {
			return "apply success";
		}
		return "apply fail";
	}
	
	public static String publishOrder(int merchantId,OrderInfo info) {
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO ")
		  .append(TableName.ORDER_INFO)
		  .append(" ( merchant_id,title, content, location, post_code, work_period,  salary, type,"
		  		+ " staff_number, deadline, status ) VALUES (")
		  .append(" ?")
		  .append(", ?")
		  .append(", ?")
		  .append(", ?")
		  .append(", ?")
		  .append(", ?")
		  .append(", ?")
		  .append(", ?")
		  .append(", ?")
		  .append(", ?")
		  .append(", ? )");
		
		boolean res = OrderInfoDao.creaateOrder(sql.toString(),info);
		
		if(res) {
			return "publish success!";
		}else {
			return "publish fail!";
		}
		
	}
	
	/**
	 * �ղض�������ȡ���ղض���
	 * @param studentId
	 * @param orderId
	 * @return
	 */
	public static String collectOrder(int studentId,int orderId) {
		String str = "collecting order";
		String query = "SELECT * FROM " + TableName.COLLECT_ORDER_INFO
				+ " WHERE student_id = " + studentId;
		
		List<CollectOrderInfo> list = CollectOrderDao.queryOrderByStudent(query);
		String sql = "INSERT INTO " +TableName.COLLECT_ORDER_INFO
				+ " (student_id,order_id) VALUES ("
				+ studentId + "," + orderId +")";
		
		for(CollectOrderInfo one:list) {
			if(one.orderId == orderId) {
				sql = "DELETE FROM " + TableName.COLLECT_ORDER_INFO
						+" WHERE student_id = " + studentId
						+" AND order_id = " + orderId;
				str = "cancel collecting order";
				break;
			}
		}
		boolean res = CollectOrderDao.updateOrder(sql);
		
		if(res) {
			return str+" success";
		}else {
			return str+" fail";
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
		String sql = "SELECT * FROM " + TableName.ORDER_INFO + " WHERE merchant_id ="
				+ merchantId;
		if(status != null && !"".equals(status)) {
			sql = sql + " AND status = " + status;
		}
		if(type != null && !"".equals(type)) {
			sql = sql + " AND type = " + type;
		}
		if(search != null && !"".equals(search)) {
			sql = sql + " AND (title like '%" + search +"%' OR content like '%" + search+"%' )";
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
		sql.append("SELECT a.*,b.* ,c.* FROM ")
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
	
	
	/**
	 * �̼Ҿܾ�����ͬ��ѧ���Ķ�������
	 * @param studentId
	 * @param orderId
	 * @param status
	 * @return
	 */
	public static String updateApplication(int studentId,int orderId,String status) {
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE ")
		  .append(TableName.STUDENT_APPLY_INFO)
		  .append(" SET status = '")
		  .append(status)
		  .append("' WHERE student_id = ")
		  .append(studentId)
		  .append(" AND order_id = ")
		  .append(orderId);
		
		boolean res = ApplyOrderDao.updateOrder(sql.toString());
		
		if(res) {
			return "update success";
		}else {
			return "update fail";
		}
	}
	
	/** Meng Ying
	 * ��ѯָ��ѧ�������̼���Ϣ
	 * @param studentId
	 * @param status
	 * @param search
	 * @return
	 */
	public static List<StudentApplyInfo> getApplyMerchantByStudent(int studentId,String status,String search){
		String sql = null;
		
		sql = " select a.*,b.*,c.* "
				+ " from student_apply_info  a"
				+ " left join order_info  b"
				+ " on a.order_id=b.id"
				+ " left join user_info c"
				+ " on c.id = b.merchant_id"
				+ " where a.student_id = "+ studentId;
		
		if(status != null && !"".equals(status)) {
			sql = sql + " and a.status like '%"+status+"%'";
		}
		if(search != null && !"".equals(search)) {
			sql = sql + " and (b.title like '%"+search+"%' "
		              + " or b.content like '%"+search+"%' "
					  + " or b.location like '%"+search+"%')";
		}
		
		List<StudentApplyInfo> appliedOrders = ApplyOrderDao.queryOrderInfo(sql.toString());
		
		return appliedOrders;
	}
	
	/**
	 * ��ѯָ��ѧ���鰺������Ϣ
	 * @param studentId
	 * @param status
	 * @param search
	 * @return
	 */
	public static List<StudentApplyInfo> getColletOrder(int studentId,String status,String search){
		String sql = null;
		
		sql = " select a.*,b.*,c.*"
				+ " from collect_order_info  a"
				+ " left join order_info  b"
				+ " on a.order_id=b.id"
				+ " left join user_info c"
				+ " on c.id = b.merchant_id"
				+ " where a.student_id = " + studentId;
		
		if(status != null && !"".equals(status)) {
			sql = sql + " and a.status like '%"+status+"%'";
		}
		if(search != null && !"".equals(search)) {
			sql = sql + " and (b.title like '%"+search+"%' "
		              + " or b.content like '%"+search+"%' "
					  + " or b.location like '%"+search+"%')";
		}
		
		List<StudentApplyInfo> collectOrders = ApplyOrderDao.queryOrderInfo(sql.toString());
		
		return collectOrders;
	}
	
	

}
