package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserinfoDao;
import pojo.*;
import service.LoginService;

import java.util.*;

import config.*;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public LoginServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		String account = (String) request.getParameter("account");

		String password = (String) request.getParameter("password");
		
		//get session object
		HttpSession session = request.getSession();       

		//set one attribute of session
		session.setAttribute("loginTime", new Date());     
		session.setAttribute("account", account);
		session.setAttribute("password", password);

		//get one attribute of session
		out.println("Time of logging in£º" +(Date)session.getAttribute("loginTime"));    
		

		Userinfo user = LoginService.login(account, password);
		
		out.print(user);
		if(user == null) {
			request.setAttribute("result", "login fail");
		}else {
			request.setAttribute("result", "login success");
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
