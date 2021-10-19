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
		String sql = "SELECT * FROM " + TableName.USER_INFO + "WHERE account = "+account
				+"AND password = " + password;
		
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
		  .append("SET account = ")
		  .append(info.account)
		  .append(", password = ")
		  .append(info.password)
		  .append(", name = ")
		  .append(info.name)
		  .append(", matriculation_no = ")
		  .append(info.matriculationNo)
		  .append(", gendedr = ")
		  .append(info.gender)
		  .append(", age = ")
		  .append(info.age)
		  .append(", nationality = ")
		  .append(info.nationality)
		  .append(", year_of_study = ")
		  .append(info.yearOfStudy)
		  .append(", fin_no = ")
		  .append(info.finNo)
		  .append(", email = ")
		  .append(info.email)
		  .append(", phone_number = ")
		  .append(info.phoneNumber)
		  .append(", degree = ")
		  .append(info.degree)
		  .append(", remark = ")
		  .append(info.remark)
		  .append(", program = ")
		  .append(info.program)
		  .append(", experience =")
		  .append(info.experience)
		  .append("WHERE id =")
		  .append(id);
		
		 return UserinfoDao.updateUser(sqlBuilder.toString());
	}

}
