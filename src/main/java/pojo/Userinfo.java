package pojo;

public class Userinfo {
	int id;
	String account;
	String password;
	String type;
	String name;
	String matriculationNo;
	String gender;
	int age;
	String nationality;
	int yearOfStudy;
	String finNo;
	String email;
	String phoneNumber;
	String degree;
	String remark;
	String program;
	String experience;
	
	public Userinfo(int id,
	    String account,
	    String password,
	    String type,
    	String name,
	    String matriculationNo,
	    String gender,
	    int age,
    	String nationality,
	    int yearOfStudy,
	    String finNo,
	    String email,
	    String phoneNumber,
	    String degree,
	    String remark,
	    String program,
	    String experience){
		
		this.id = id;
		this.account = account;
		this.password = password;
		this.type = type;
		this.name = name;
		this.matriculationNo = matriculationNo;
		this.gender = gender;
		this.age = age;
		this.nationality = nationality;
		this.yearOfStudy = yearOfStudy;
		this.finNo = finNo;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.degree = degree;
		this.remark = remark;
		this.program = program;
		this.experience = experience;
		
		
	}

	public Userinfo() {
		// TODO Auto-generated constructor stub
	}

}
