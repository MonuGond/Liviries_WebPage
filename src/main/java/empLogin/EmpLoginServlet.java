package empLogin;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class EmpLoginServlet
 */
public class EmpLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmpLoginServlet() {
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
		String eusername=request.getParameter("eusername");
		String epassword=request.getParameter("epassword");
		EmpLoginPozo p= new EmpLoginPozo(eusername,epassword);
		
		EmpLoginDao d=new EmpLoginDao();
		if(EmpLoginDao.validate(eusername,epassword)) {
			RequestDispatcher rd=request.getRequestDispatcher("UniformGenerate.html");
			rd.forward(request, response);
		}else {
			System.out.println("Sorry email and password wrong");
			RequestDispatcher rd=request.getRequestDispatcher("loginError.html");
			rd.include(request, response);
		}
		
		
	}

}
