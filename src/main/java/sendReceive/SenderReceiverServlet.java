package sendReceive;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.io.IOException;

/**
 * Servlet implementation class SenderReceiverServlet
 */
public class SenderReceiverServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SenderReceiverServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
System.out.println("Sender .............Receiver..............1");
		
		String f_sender=request.getParameter("t_sender");
		String t_receiver=request.getParameter("f_receiver");
		
		
		SenderReceiverPozo sr = new SenderReceiverPozo(f_sender,t_receiver);
		//SenderReceiverDao d = new SenderReceiverDao();
		
		try {
			
			request.setAttribute("SenderReceiverPozo", sr);
			RequestDispatcher rd = request.getRequestDispatcher("ReceiptOtherAirport1.jsp");
			rd.forward(request, response);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
