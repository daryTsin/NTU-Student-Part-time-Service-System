package service;

import dao.ConnectorUtil;
import pojo.*;

import java.util.*;

import config.*;


public class LoginService {
	
	public static Userinfo login(String account,String password) {
		String sql = "SELECT * FROM " + TableName.USER_INFO + "WHERE account = "+account
				+"AND password = " + password;
		
		List<Userinfo> list = ConnectorUtil.queryAccoutInfo(sql);
		
		if(list == null || list.isEmpty()) {
			return null;
		}else {
			return list.get(0);
		}
	}

}
