package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
        
		Integer studentId = (Integer) request.getAttribute("studentId");
		String status = (String) request.getAttribute("status");
		//String type = (String) request.getAttribute("type");
		String search = (String) request.getAttribute("search");
		
		studentId =1;
		status ="Completed";
		search = "title";
		
		if(studentId == null) {
			studentId = 0;
		}
		
		List<StudentApplyInfo> appliedorders = OrderService.getApplyMerchantByStudent(studentId, status, search);
		out.print(appliedorders);
		request.setAttribute("appliedorders", appliedorders);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
