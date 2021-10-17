package pojo;

public class OrderReviewInfo {
	int id;
	int studentId;
	int orderId;
	int merchantId;
	String review;
	
	OrderReviewInfo(int id,int studentId,int orderId,int merchantId,String review){
		this.id = id;
		this.studentId = studentId;
		this.orderId = orderId;
		this.merchantId = merchantId;
		this.review = review;
	}

}
