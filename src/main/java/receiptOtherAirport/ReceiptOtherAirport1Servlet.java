package receiptOtherAirport;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * Servlet implementation class ReceiptOtherAirport1Servlet
 */

public class ReceiptOtherAirport1Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReceiptOtherAirport1Servlet() {
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
		String t_airportname = request.getParameter("t_airportname");
		String t_airportaddress = request.getParameter("t_airportaddress");
		String f_airportname = request.getParameter("f_airportname");
		String f_airportaddress = request.getParameter("f_airportaddress");
		String t_receiver = request.getParameter("t_receiver");
		String f_sender = request.getParameter("f_sender");
		// int issue_vr_no = Integer.parseInt(request.getParameter("issue_vr_no"));
		String issue_vr_no = request.getParameter("issue_vr_no");
		String issue_date = request.getParameter("issue_date");
//here date ..........................................................
		Date date = null;
		try {
			date = new SimpleDateFormat("yyyy-MM-dd").parse(issue_date);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println(date + "here.... ");
		SimpleDateFormat issuedate1 = new SimpleDateFormat("dd-MM-yyyy");
		try {
			java.util.Date issuedate2 = issuedate1.parse(issue_date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//.......................................................................................
		double shirting1_cloth_mtrs = 00.00;
		if (!request.getParameter("shirting1_cloth_mtrs").equals(""))
			shirting1_cloth_mtrs = Double.parseDouble(request.getParameter("shirting1_cloth_mtrs"));
		int shirting1_cloth_pcs = 0;
		if (!request.getParameter("shirting1_cloth_pcs").equals(""))
			shirting1_cloth_pcs = Integer.parseInt(request.getParameter("shirting1_cloth_pcs"));

		double shirting2_cloth_mtrs = 00.00;
		if (!request.getParameter("shirting2_cloth_mtrs").equals(""))
			shirting2_cloth_mtrs = Double.parseDouble(request.getParameter("shirting2_cloth_mtrs"));
		int shirting2_cloth_pcs = 0;
		if (!request.getParameter("shirting2_cloth_pcs").equals(""))
			shirting2_cloth_pcs = Integer.parseInt(request.getParameter("shirting2_cloth_pcs"));

		// for new pozo
		double shirting_cloth_qnt = shirting1_cloth_mtrs * shirting1_cloth_pcs
				+ shirting2_cloth_mtrs * shirting2_cloth_pcs;

		double shirting_cloth_remarks = 00.00;
		if (!request.getParameter("shirting_cloth_remarks").equals(""))
			shirting_cloth_remarks = Double.parseDouble(request.getParameter("shirting_cloth_remarks"));
//......................................................................................................

		double paint1_cloth_mtrs = 00.00;
		if (!request.getParameter("paint1_cloth_mtrs").equals(""))
			paint1_cloth_mtrs = Double.parseDouble(request.getParameter("paint1_cloth_mtrs"));
		int paint1_cloth_pcs = 0;
		if (!request.getParameter("paint1_cloth_pcs").equals(""))
			paint1_cloth_pcs = Integer.parseInt(request.getParameter("paint1_cloth_pcs"));

		double paint2_cloth_mtrs = 00.00;
		if (!request.getParameter("paint2_cloth_mtrs").equals(""))
			paint2_cloth_mtrs = Double.parseDouble(request.getParameter("paint2_cloth_mtrs"));
		int paint2_cloth_pcs = 0;
		if (!request.getParameter("paint2_cloth_pcs").equals(""))
			paint2_cloth_pcs = Integer.parseInt(request.getParameter("paint2_cloth_pcs"));

		double paint_cloth_qtn = paint1_cloth_mtrs * paint1_cloth_pcs + paint2_cloth_mtrs * paint2_cloth_pcs;

		double paint_cloth_remarks = 00.00;
		if (!request.getParameter("paint_cloth_remarks").equals(""))
			paint_cloth_remarks = Double.parseDouble(request.getParameter("paint_cloth_remarks"));
//......................................................................................................
		double suit1_cloth_mtrs = 00.00;
		if (!request.getParameter("suit1_cloth_mtrs").equals(""))
			suit1_cloth_mtrs = Double.parseDouble(request.getParameter("suit1_cloth_mtrs"));

		int suit1_cloth_pcs = 0;
		if (!request.getParameter("suit1_cloth_pcs").equals(""))
			suit1_cloth_pcs = Integer.parseInt(request.getParameter("suit1_cloth_pcs"));

		double suit2_cloth_mtrs = 00.00;
		if (!request.getParameter("suit2_cloth_mtrs").equals(""))
			suit2_cloth_mtrs = Double.parseDouble(request.getParameter("suit2_cloth_mtrs"));

		int suit2_cloth_pcs = 0;
		if (!request.getParameter("suit2_cloth_pcs").equals(""))
			suit2_cloth_pcs = Integer.parseInt(request.getParameter("suit2_cloth_pcs"));

		double suit_cloth_qtn = suit1_cloth_mtrs * suit1_cloth_pcs + suit2_cloth_mtrs * suit2_cloth_pcs;

		double suit_cloth_remarks = 00.00;
		if (!request.getParameter("suit_cloth_remarks").equals(""))
			suit_cloth_remarks = Double.parseDouble(request.getParameter("suit_cloth_remarks"));
//......................................................................................................
		double blaizer1_cloth_mtrs = 00.00;
		if (!request.getParameter("blaizer1_cloth_mtrs").equals(""))
			blaizer1_cloth_mtrs = Double.parseDouble(request.getParameter("blaizer1_cloth_mtrs"));

		int blaizer1_cloth_pcs = 0;
		if (!request.getParameter("blaizer1_cloth_pcs").equals(""))
			blaizer1_cloth_pcs = Integer.parseInt(request.getParameter("blaizer1_cloth_pcs"));

		double blaizer2_cloth_mtrs = 00.00;
		if (!request.getParameter("blaizer2_cloth_mtrs").equals(""))
			blaizer2_cloth_mtrs = Double.parseDouble(request.getParameter("blaizer2_cloth_mtrs"));

		int blaizer2_cloth_pcs = 0;
		if (!request.getParameter("blaizer2_cloth_pcs").equals(""))
			blaizer2_cloth_pcs = Integer.parseInt(request.getParameter("blaizer2_cloth_pcs"));

		double blaizer_cloth_qtn = blaizer1_cloth_mtrs * blaizer1_cloth_pcs + blaizer2_cloth_mtrs * blaizer2_cloth_pcs;

		double blaizer_cloth_remarks = 00.00;
		if (!request.getParameter("blaizer_cloth_remarks").equals(""))
			blaizer_cloth_remarks = Double.parseDouble(request.getParameter("blaizer_cloth_remarks"));
//.....................................................................................................
		int silk_saree_pcs = 0;
		if (!request.getParameter("silk_saree_pcs").equals(""))
			silk_saree_pcs = Integer.parseInt(request.getParameter("silk_saree_pcs"));

		double silk_saree_qtn = silk_saree_pcs;

		double silk_saree_remark = 00.00;
		if (!request.getParameter("silk_saree_remark").equals(""))
			silk_saree_remark = Double.parseDouble(request.getParameter("silk_saree_remark"));
//......................................................................................................
		int crape_saree_pcs = 0;
		if (!request.getParameter("crape_saree_pcs").equals(""))
			crape_saree_pcs = Integer.parseInt(request.getParameter("crape_saree_pcs"));

		double crape_saree_qtn = crape_saree_pcs;

		double crape_saree_remark = 00.00;
		if (!request.getParameter("crape_saree_remark").equals(""))
			crape_saree_remark = Double.parseDouble(request.getParameter("crape_saree_remark"));
//.......................................................................................................
		int synthetic_saree_pcs = 0;
		if (!request.getParameter("synthetic_saree_pcs").equals(""))
			synthetic_saree_pcs = Integer.parseInt(request.getParameter("synthetic_saree_pcs"));

		double synthetic_saree_qtn = synthetic_saree_pcs;

		double synthetic_saree_remark = 00.00;
		if (!request.getParameter("synthetic_saree_remark").equals(""))
			synthetic_saree_remark = Double.parseDouble(request.getParameter("synthetic_saree_remark"));
//........................................................................................................
		int neck_tie_pcs = 0;
		if (!request.getParameter("neck_tie_pcs").equals(""))
			neck_tie_pcs = Integer.parseInt(request.getParameter("neck_tie_pcs"));

		double neck_tie_qtn = neck_tie_pcs;

		double neck_tie_remark = 00.00;
		if (!request.getParameter("neck_tie_remark").equals(""))
			neck_tie_remark = Double.parseDouble(request.getParameter("neck_tie_remark"));
//.........................................................................................................
		int scarves_pcs = 0;
		if (!request.getParameter("scarves_pcs").equals(""))
			scarves_pcs = Integer.parseInt(request.getParameter("scarves_pcs"));

		double scarves_qtn = scarves_pcs;

		double scarves_remark = 00.00;
		if (!request.getParameter("scarves_remark").equals(""))
			scarves_remark = Double.parseDouble(request.getParameter("scarves_remark"));

		// here ReceiptOtherAirport1Pozo call
		ReceiptOtherAirport1Pozo p = new ReceiptOtherAirport1Pozo(t_receiver, t_airportname, t_airportaddress, f_sender,
				f_airportname, f_airportaddress, issue_vr_no, date, shirting1_cloth_mtrs, shirting1_cloth_pcs,
				shirting2_cloth_mtrs, shirting2_cloth_pcs, shirting_cloth_qnt, shirting_cloth_remarks,
				paint1_cloth_mtrs, paint1_cloth_pcs, paint2_cloth_mtrs, paint2_cloth_pcs, paint_cloth_qtn,
				paint_cloth_remarks, suit1_cloth_mtrs, suit1_cloth_pcs, suit2_cloth_mtrs, suit2_cloth_pcs,
				suit_cloth_qtn, suit_cloth_remarks, blaizer1_cloth_mtrs, blaizer1_cloth_pcs, blaizer2_cloth_mtrs,
				blaizer2_cloth_pcs, blaizer_cloth_qtn, blaizer_cloth_remarks, silk_saree_pcs, silk_saree_qtn,
				silk_saree_remark, crape_saree_pcs, crape_saree_qtn, crape_saree_remark, synthetic_saree_pcs,
				synthetic_saree_qtn, synthetic_saree_remark, neck_tie_pcs, neck_tie_qtn, neck_tie_remark, scarves_pcs,
				scarves_qtn, scarves_remark);

		// here ReceiptOtherAirport1Dao call
		/*
		 * ReceiptOtherAirport1Dao d = new ReceiptOtherAirport1Dao();
		 * LocationOtherAirport1Pozo p1 = (LocationOtherAirport1Pozo)
		 * request.getAttribute("LocationOtherAirport1Pozo"); try { int rs =
		 * d.ReceiptOtherAirport1(p); if (rs != 0) {
		 * System.out.println(" Receipt method wrok");
		 * request.setAttribute("ReceiptOtherAirport1Pozo", p);
		 * request.setAttribute("LocationOtherAirport1Pozo", p1); RequestDispatcher rd =
		 * request.getRequestDispatcher("ReceiptOtherAirport2.jsp"); rd.forward(request,
		 * response); } else { System.out.println(" Receipt method not work"); }
		 * 
		 * } catch (Exception e) { // TODO: handle exception e.printStackTrace(); }
		 */

		try {
			String myObjectId = UUID.randomUUID().toString();
			request.getSession().setAttribute(myObjectId, p);
			request.setAttribute("myObjectId", myObjectId);

			request.setAttribute("ReceiptOtherAirport1Pozo", p);
			request.setAttribute("date", issue_date);
			RequestDispatcher rd = request.getRequestDispatcher("ReceiptOtherAirport2.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

}
