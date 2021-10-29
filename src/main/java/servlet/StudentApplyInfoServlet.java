package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pojo.*;
import service.OrderService;

/**
 * Servlet implementation class StudentApplyInfoServlet
 */
@WebServlet("/StudentApplyInfo")
public class StudentApplyInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentApplyInfoServlet() {
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
		Integer merchantId = 0;
		if(session.getAttribute("userid") == null) {
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}else {
			merchantId = (Integer) session.getAttribute("userid");
		}
        
		
		String status =  request.getParameter("status");
		if(merchantId == null) {
			merchantId = 2;
		}
		
		List<StudentApplyInfo> orders = OrderService.getApplyStudentByMerchant(merchantId, status);
		out.print(orders);
		request.setAttribute("orders", orders);
		request.getRequestDispatcher("waitinglist.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
