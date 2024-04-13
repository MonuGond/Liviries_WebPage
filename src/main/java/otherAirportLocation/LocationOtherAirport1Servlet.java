package otherAirportLocation;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import sendReceive.SenderReceiverPozo;

/**
 * Servlet implementation class LocationOtherAirport1Servlet
 */
public class LocationOtherAirport1Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LocationOtherAirport1Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("This is working at LocationOtherAirport1Servlet.......... next page is ReceiptOtherAirport1.jsp..");

		// int
		// locationOtherAirportid=Integer.parseInt(request.getParameter("locationOtherAirportid"));
		String t_airportname = request.getParameter("t_airportname");
		String t_airportaddress = request.getParameter("t_airportaddress");
		String f_airportname = request.getParameter("f_airportname");
		String f_airportaddress = request.getParameter("f_airportaddress");
		String t_receiver= request.getParameter("t_receiver");
		String f_sender= request.getParameter("f_sender");
		// yha pr ek page se data ko data base me set krne ke liye pozo ko call kiya gya hai
		LocationOtherAirport1Pozo l1=new LocationOtherAirport1Pozo(t_airportname,t_airportaddress);
		LocationOtherAirport1Pozo l2 =new LocationOtherAirport1Pozo(f_airportname,f_airportaddress);
		//System.out.println(airportname+" "+airportaddress);

		SenderReceiverPozo sr = new SenderReceiverPozo(t_receiver,f_sender);

		// here pozo call
	//	LocationOtherAirport1Pozo p = new LocationOtherAirport1Pozo(airportname, airportaddress);
		// here dao call
	//	LocationOtherAirport1Dao d = new LocationOtherAirport1Dao();

		try {

			// request.setAttribute("locationOtherAirportid", locationOtherAirportid);
			//request.setAttribute("airportname", airportname);
			//request.setAttribute("airportaddress", airportaddress);
			//yha pr data ko database me send kiya jaa rha
			request.setAttribute("SenderReceiverPozo", sr);
			request.setAttribute("LocationOtherAirport1Pozo1", l1);
			request.setAttribute("LocationOtherAirport1Pozo2", l2);
			RequestDispatcher rd = request.getRequestDispatcher("ReceiptOtherAirport1.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
