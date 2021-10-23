package pojo;

public class StudentApplyInfo {
	int id;
	int studentId;
	int orderId;
	String status;
	String remark;
	public Userinfo studentInfo;
	public OrderInfo orderInfo;
	
	public StudentApplyInfo(int id,int studentId,int orderId,String status,String remark){
		this.id = id;
		this.studentId = studentId;
		this.orderId = orderId;
		this.status = status;
		this.remark = remark;
	}
	
	public String toString() {
		return "{ 'id':"+id+", 'studentId':" +studentId+",'orderId':"+
	        orderId+",'status':'"+status+"','remark':'"+remark+
	        "','studentInfo':'"+studentInfo+"','orderInfo':'"+orderInfo+
	        "'}";
	}

}
