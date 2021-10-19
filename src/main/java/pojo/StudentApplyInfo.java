package pojo;

public class StudentApplyInfo {
	int id;
	int studentId;
	int orderId;
	String status;
	String remark;
	
	public StudentApplyInfo(int id,int studentId,int orderId,String status,String remark){
		this.id = id;
		this.studentId = studentId;
		this.orderId = orderId;
		this.status = status;
		this.remark = remark;
	}

}
