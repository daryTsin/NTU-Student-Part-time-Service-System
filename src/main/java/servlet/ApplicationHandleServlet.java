package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.OrderService;

/**
 * Servlet implementation class ApplicationHandle
 */
@WebServlet("/ApplicationHandle")
public class ApplicationHandleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApplicationHandleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
        
		Integer studentId = Integer.parseInt(request.getParameter("studentId")) ;
		Integer orderId = Integer.parseInt(request.getParameter("orderId")) ;
		
		String status = (String) request.getAttribute("status");
		if(studentId == null) {
			studentId = 0;
		}
		if(orderId == null) {
			orderId = 0;
		}
		String res = OrderService.updateApplication(studentId,orderId, status);
		out.print(res);
		request.setAttribute("result", res);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
