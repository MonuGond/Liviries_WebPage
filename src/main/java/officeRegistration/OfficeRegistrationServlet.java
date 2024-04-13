package officeRegistration;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Servlet implementation class OfficeRegistrationServlet
 */
public class OfficeRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OfficeRegistrationServlet() {
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
		String Email= request.getParameter("Email");
		String Password = request.getParameter("Password");
		
		OfficeRegistrationPozo p= new OfficeRegistrationPozo(Email,Password);
		
		OfficeRegistrationDao d= new OfficeRegistrationDao();
		
		try {
			int rs= d.OfficeRegistrationDao(p);
			request.setAttribute("OfficeRegistrationPozo", p);
			RequestDispatcher rd= request.getRequestDispatcher("Home.html");
			rd.forward(request, response);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*request.setAttribute("OfficeRegistrationPozo", p);
		RequestDispatcher rd= request.getRequestDispatcher("Home.html");
		rd.forward(request, response);*/
		
		
		
	}

}
