package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pojo.*;
import service.OrderService;

/**
 * Servlet implementation class OrderApply
 */
@WebServlet("/OrderApply")
public class OrderApplyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderApplyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
        
		Integer orderId = Integer.parseInt( request.getParameter("orderId"));
		Integer studentId = Integer.parseInt( request.getParameter("studentId"));
		String remark =  request.getParameter("remark");
		if(orderId == null) {
			orderId = 0;
		}
		if(studentId == null) {
			studentId = 0;
		}
		String res = OrderService.applyOrder(studentId, orderId, remark);
		out.print(res);
		request.setAttribute("result", res);
		request.getRequestDispatcher("/StudentAppliedOrderList").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
