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
import service.OrderService;

/**
 * Servlet implementation class getOrders
 */
@WebServlet("/GetOrders")
public class GetOrdersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetOrdersServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
        
		String search = (String) request.getParameter("search");
		String s1 = request.getParameter("leastSalary");
		String s2 = request.getParameter("mostSalary");
		String type = request.getParameter("type");
		Double leastSalary = 0.0 ;
		Double mostSalary = 0.0 ;
		if(s1 != null) {
			leastSalary = Double.valueOf(s1);
		}
		if(s2 != null) {
			mostSalary = Double.valueOf(s2);
		}
		System.out.print(search);
		System.out.print(type);
		List<OrderInfo> orders = OrderService.getOrderList(search, leastSalary, mostSalary,type);
		
		request.setAttribute("orders", orders);
		request.getRequestDispatcher("home.jsp").forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
