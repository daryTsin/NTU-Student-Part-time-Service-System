package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pojo.*;
import service.OrderService;

/**
 * Servlet implementation class StudentApplyInfoServlet
 */
@WebServlet("/CollectOrderList")
public class CollectOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CollectOrderServlet() {
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
//		status ="Completed";
//		search = "title";
		
		if(studentId == null) {
			studentId = 0;
		}
		
		List<StudentApplyInfo> collectOrders = OrderService.getColletOrder(studentId, status ,search);
		out.print(collectOrders);
		request.setAttribute("orders", collectOrders);
		request.getRequestDispatcher("favorite.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
