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
 * Servlet implementation class OldOrderServlet
 */
@WebServlet("/OldOrders")
public class OldOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OldOrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
        
		Integer merchantId = Integer.parseInt(request.getParameter("merchantId")) ;
		String status =  request.getParameter("status");
		String type =  request.getParameter("type");
		String search =  request.getParameter("search");
		
		if(merchantId == null) {
			merchantId = 0;
		}
		
		List<OrderInfo> orders = OrderService.getOrderByCondition(merchantId, status, type, search);

		request.setAttribute("orders", orders);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
