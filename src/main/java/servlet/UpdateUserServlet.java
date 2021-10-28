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
		String account =  request.getParameter("account");
		String password =  request.getParameter("password");
		String name = request.getParameter("name");
		String matriculationNo = request.getParameter("matriculationNo");
		String gender =  request.getParameter("gender");
		Integer age = Integer.parseInt( request.getParameter("age"));
		String nationality = request.getParameter("nationality");
		Integer yearOfStudy = Integer.parseInt( request.getParameter("yearOfStudy"));
		String finNo = request.getParameter("finNo");
		String email = request.getParameter("email");
		String phoneNumber = request.getParameter("phoneNumber");
		String degree = request.getParameter("degree");
		String remark = request.getParameter("remark");
		String program = request.getParameter("program");
		String experience = request.getParameter("experience");
		
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
