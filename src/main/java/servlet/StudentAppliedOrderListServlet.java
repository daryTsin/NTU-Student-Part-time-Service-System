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

import pojo.OrderInfo;
import pojo.StudentApplyInfo;
import service.OrderService;

/**
 * Servlet implementation class StudentAppliedOrderListServlet
 */
@WebServlet("/StudentAppliedOrderList")
public class StudentAppliedOrderListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentAppliedOrderListServlet() {
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
		Integer studentId = 0;
		if(session.getAttribute("userid") == null) {
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}else {
			studentId = (Integer) session.getAttribute("userid");
		}
        
		
		String status = (String) request.getParameter("status");
		//String type = (String) request.getParameter("type");
		String search = (String) request.getParameter("search");
		
		studentId =1;
		status ="Completed";
		search = "title";
		
		if(studentId == null) {
			studentId = 0;
		}
		
		List<StudentApplyInfo> appliedorders = OrderService.getApplyMerchantByStudent(studentId, status, search);
		out.print(appliedorders);
		request.setAttribute("appliedorders", appliedorders);
		request.getRequestDispatcher("applied.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
