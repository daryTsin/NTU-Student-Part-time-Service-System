package service;

import dao.UserinfoDao;
import pojo.*;

import java.util.*;

import config.*;


public class LoginService {
	
	/**
	 * 登陆
	 * @param account
	 * @param password
	 * @return
	 */
	public static Userinfo login(String account,String password) {
		String sql = "SELECT * FROM " + TableName.USER_INFO + " WHERE account = "+account
				+" AND password = " + password;
		
		List<Userinfo> list = UserinfoDao.queryAccoutInfo(sql);
		
		if(list == null || list.isEmpty()) {
			return null;
		}else {
			return list.get(0);
		}
	}
	
	/**
	 * 更新用户信息
	 * @param id
	 * @param info
	 * @return
	 */
	public static boolean updateUserInfo(int id, Userinfo info) {
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append("UPDATE ")
		  .append(TableName.USER_INFO)
		  .append(" SET account = ?")
		  .append(", password = ?")
		  .append(", name = ?")
		  .append(", matriculation_no = ?")
		  .append(", gender = ?")
		  .append(", age = ?")
		  .append(", nationality = ?")
		  .append(", year_of_study = ?")
		  .append(", fin_no = ?")
		  .append(", email = ?")
		  .append(", phone_number = ?")
		  .append(", degree = ?")
		  .append(", remark = ?")
		  .append(", program = ?")
		  .append(", experience = ?")
		  .append(" WHERE id = ")
		  .append(id);
		
		 System.out.println(sqlBuilder.toString());
		 return UserinfoDao.updateUser(sqlBuilder.toString(),info);
	}

}
