package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pojo.*;
import service.LoginService;

/**
 * Servlet implementation class updateUserServlet
 */
@WebServlet("/updateUser")
public class UpdateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
        Integer id = (Integer) request.getAttribute("id");
        if(id==null) {
        	request.setAttribute("result", "用户信息修改失败,用户id未传");
        	return;
        }
		String account = (String) request.getAttribute("account");
		String password = (String) request.getAttribute("password");
		String name = (String) request.getAttribute("name");
		String matriculationNo = (String) request.getAttribute("matriculationNo");
		String gender = (String) request.getAttribute("gender");
		Integer age = (Integer) request.getAttribute("age");
		String nationality = (String) request.getAttribute("nationality");
		Integer yearOfStudy = (Integer) request.getAttribute("yearOfStudy");
		String finNo = (String) request.getAttribute("finNo");
		String email = (String) request.getAttribute("email");
		String phoneNumber = (String) request.getAttribute("phoneNumber");
		String degree = (String) request.getAttribute("degree");
		String remark = (String) request.getAttribute("remark");
		String program = (String) request.getAttribute("program");
		String experience = (String) request.getAttribute("experience");
		
		if(age ==null) {
			age = 0;
		}
		if(yearOfStudy == null) {
			yearOfStudy = 1;
		}

		Userinfo user = new Userinfo( id,
	     account,
	     password,
	     null,
    	 name,
	     matriculationNo,
	     gender,
	     age,
    	 nationality,
	     yearOfStudy,
	     finNo,
	     email,
	     phoneNumber,
	     degree,
	     remark,
	     program,
	     experience);

		boolean res = LoginService.updateUserInfo(id, user);

		if(res) {
			request.setAttribute("result", "update success");
		}else {
			request.setAttribute("result", "update fail");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
