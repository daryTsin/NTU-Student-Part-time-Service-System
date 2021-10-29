package pojo;

import java.util.*;

public class OrderInfo {
	public int orderId;
	public int merchantId;
	public String title;
	public String content;
	public String location;
	public String postCode;
	public String workPeriod;
	public String publishTime;
	public Double salary;
	public String type;
	public int staffNumber;
	public String deadline;
	public String status;
	public List<Userinfo> applyInfo;
	
	public OrderInfo() {
		
	}
	
	public OrderInfo(int id, int merchantId,String title,String content,String location,
			String postCode,String workPeriod,String publishTime,Double salary,String type,
			int staffNumber,String deadline,String status){
		this.orderId = id;
		this.merchantId = merchantId;
		this.title = title;
		this.content = content;
		this.location = location;
		this.postCode = postCode;
		this.workPeriod = workPeriod;
		this.publishTime = publishTime;
		this.salary = salary;
		this.type = type;
		this.staffNumber = staffNumber;
		this.deadline = deadline;
		this.status = status;
		
	}
	
	public String toString() {
		return "{'orderId':" + orderId + ",'merchantId':" + merchantId +
				",'title':'" + title +"','content':'" + content +"','location':'"+location+"','postCode':'"+
				postCode +"','workPeriod':'"+workPeriod+"','publishTime':'"+publishTime+
				"','salary':"+salary + ",'type':'"+type+"','staffNumber':"+staffNumber +
				",'deadline':'"+deadline+"','status':'"+status+"'}";
	}

}
