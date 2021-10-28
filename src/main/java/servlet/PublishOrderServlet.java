package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.*;
import pojo.*;

/**
 * Servlet implementation class PublishOrderServlet
 */
@WebServlet("/PublishOrder")
public class PublishOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PublishOrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		Integer id = Integer.parseInt( request.getParameter("merchantId"));
		String title =  request.getParameter("title");
		String content =  request.getParameter("content");
		String location = request.getParameter("location");
		String postCode =  request.getParameter("postCode");
		String workPeriod =  request.getParameter("workPeriod");

		Double salary = Double.valueOf( request.getParameter("salary"));
		String type =  request.getParameter("type");
		Integer staffNumber = Integer.parseInt( request.getParameter("staffNumber"));
		String deadline =  request.getParameter("deadline");
		String status = "processing";
		if(id == null) {
			id = 0;
		}
		if(salary == null) {
			salary = 0.0;
		}
		if(staffNumber == null) {
			staffNumber = 1;
		}
		
		OrderInfo order = new OrderInfo(0,
				id,
				title,
				content,
				location,
				postCode,
				workPeriod,
				null,
				salary,
				type,
				staffNumber,
				deadline,
				status
				);
		String res = OrderService.publishOrder(id, order);
		out.print(res);
		request.setAttribute("result", res);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
