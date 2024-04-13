package officeRegisLogin;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import employeeRegistration.EmpRegisterPozo;

/**
 * Servlet implementation class OfficeRegiLogServlet
 */
public class OfficeRegiLogServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OfficeRegiLogServlet() {
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
		String Email=request.getParameter("Email");
		String Password=request.getParameter("Password");
		
		OfficeRegLoginPozo p= new OfficeRegLoginPozo(Email,Password);
		OfficeRegLoginDao d=new OfficeRegLoginDao();
		
		if(OfficeRegLoginDao.validate(Email,Password)){
			RequestDispatcher rd=request.getRequestDispatcher("officeVoucher.html");
			rd.forward(request, response);	
		}else {
			System.out.println("Sorry email and password wrong");
			RequestDispatcher rd=request.getRequestDispatcher("loginError.html");
			rd.forward(request, response);
		}
		
	}

}
