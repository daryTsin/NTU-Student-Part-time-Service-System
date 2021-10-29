package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		HttpSession session = request.getSession(); 
		Integer id = (Integer) session.getAttribute("userid");
		String account = (String) session.getAttribute("account");
		String password = (String) session.getAttribute("password");
		
//        Integer id = (Integer) request.getAttribute("id");
//        if(id==null) {
//        	request.setAttribute("result", "upadate fail,no id");
//        	return;
//        }
		
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
			yearOfStudy = 0;
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
		//out.print(user);

		boolean res = LoginService.updateUserInfo(id, user);

		if(res) {
			request.setAttribute("result", "update success");
		}else {
			request.setAttribute("result", "update fail");
		}
		String result = (String)request.getAttribute("result");
		out.print(result);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
