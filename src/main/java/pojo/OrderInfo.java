package pojo;

public class OrderInfo {
	int orderId;
	int merchantId;
	String title;
	String content;
	String location;
	String postCode;
	String workPeriod;
	String publishTime;
	Double salary;
	String type;
	int staffNumber;
	String deadline;
	
	OrderInfo(int id, int merchantId,String title,String content,String location,
			String postCode,String workPeriod,String publishTime,Double salary,String type,
			int staffNumber,String deadline){
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
		
	}

}
