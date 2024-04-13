package receiptOtherAirport;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import otherAirportLocation.LocationOtherAirport1Pozo;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Servlet implementation class ReceiptOtherAirport2Servlet
 */
public class ReceiptOtherAirport2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReceiptOtherAirport2Servlet() {
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
		
		//LocationOtherAirport1Pozo l = new LocationOtherAirport1Pozo(t_airportname, t_airportaddress);
		LocationOtherAirport1Pozo l1=new LocationOtherAirport1Pozo(t_airportname,t_airportaddress);
		LocationOtherAirport1Pozo l2 =new LocationOtherAirport1Pozo(f_airportname,f_airportaddress);
		//int issue_vr_no = Integer.parseInt(request.getParameter("issue_vr_no"));
		String issue_vr_no=request.getParameter("issue_vr_no");
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
				/*SimpleDateFormat issuedate1 = new SimpleDateFormat("dd-MM-yyyy");
				try {
					java.util.Date issuedate2 = issuedate1.parse(issue_date);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/
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
				if(!request.getParameter("suit2_cloth_pcs").equals(""))
					suit2_cloth_pcs=Integer.parseInt(request.getParameter("suit2_cloth_pcs"));
				
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
				ReceiptOtherAirport1Pozo r1 = new ReceiptOtherAirport1Pozo(t_receiver, t_airportname, t_airportaddress, f_sender,
						f_airportname, f_airportaddress, issue_vr_no, date, shirting1_cloth_mtrs, shirting1_cloth_pcs,
						shirting2_cloth_mtrs, shirting2_cloth_pcs, shirting_cloth_qnt, shirting_cloth_remarks,
						paint1_cloth_mtrs, paint1_cloth_pcs, paint2_cloth_mtrs, paint2_cloth_pcs, paint_cloth_qtn,
						paint_cloth_remarks, suit1_cloth_mtrs, suit1_cloth_pcs, suit2_cloth_mtrs, suit2_cloth_pcs,
						suit_cloth_qtn, suit_cloth_remarks, blaizer1_cloth_mtrs, blaizer1_cloth_pcs, blaizer2_cloth_mtrs,
						blaizer2_cloth_pcs, blaizer_cloth_qtn, blaizer_cloth_remarks, silk_saree_pcs, silk_saree_qtn,
						silk_saree_remark, crape_saree_pcs, crape_saree_qtn, crape_saree_remark, synthetic_saree_pcs,
						synthetic_saree_qtn, synthetic_saree_remark, neck_tie_pcs, neck_tie_qtn, neck_tie_remark, scarves_pcs,
						scarves_qtn, scarves_remark);

		// ....................................ReceiptOtherAirport2.............................................................
		// int issue_vr_no=Integer.parseInt(request.getParameter("issue_vr_no"));

		int h1_32_size = 0;
		if (!request.getParameter("h1_32_size").equals(""))
			h1_32_size = Integer.parseInt(request.getParameter("h1_32_size"));
		int p1_32_size = 0;
		if (!request.getParameter("p1_32_size").equals(""))
			p1_32_size = Integer.parseInt(request.getParameter("p1_32_size"));
		int f1_32_size = 0;
		if (!request.getParameter("f1_32_size").equals(""))
			f1_32_size = Integer.parseInt(request.getParameter("f1_32_size"));
		int lc1_32_size = 0;
		if (!request.getParameter("lc1_32_size").equals(""))
			lc1_32_size = Integer.parseInt(request.getParameter("lc1_32_size"));
		double remarks_32_size = 00.00;
		if (!request.getParameter("remarks_32_size").equals(""))
			remarks_32_size = Double.parseDouble(request.getParameter("remarks_32_size"));
		// ..................................................................................................

		int h2_34_size = 0;
		if (!request.getParameter("h2_34_size").equals(""))
			h2_34_size = Integer.parseInt(request.getParameter("h2_34_size"));
		int p2_34_size = 0;
		if (!request.getParameter("p2_34_size").equals(""))
			p2_34_size = Integer.parseInt(request.getParameter("p2_34_size"));
		int f2_34_size = 0;
		if (!request.getParameter("f2_34_size").equals(""))
			f2_34_size = Integer.parseInt(request.getParameter("f2_34_size"));
		int lc2_34_size = 0;
		if (!request.getParameter("lc2_34_size").equals(""))
			lc2_34_size = Integer.parseInt(request.getParameter("lc2_34_size"));
		double remarks_34_size = 00.00;
		if (!request.getParameter("remarks_34_size").equals(""))
			remarks_34_size = Double.parseDouble(request.getParameter("remarks_34_size"));
		// ...................................................................................................

		int h3_36_size = 0;
		if (!request.getParameter("h3_36_size").equals(""))
			h3_36_size = Integer.parseInt(request.getParameter("h3_36_size"));
		int p3_36_size = 0;
		if (!request.getParameter("p3_36_size").equals(""))
			p3_36_size = Integer.parseInt(request.getParameter("p3_36_size"));
		int f3_36_size = 0;
		if (!request.getParameter("f3_36_size").equals(""))
			f3_36_size = Integer.parseInt(request.getParameter("f3_36_size"));
		int lc3_36_size = 0;
		if (!request.getParameter("lc3_36_size").equals(""))
			lc3_36_size = Integer.parseInt(request.getParameter("lc3_36_size"));
		double remarks_36_size = 00.00;
		if (!request.getParameter("remarks_36_size").equals(""))
			remarks_36_size = Double.parseDouble(request.getParameter("remarks_36_size"));
		// .............................................................................................................

		int h4_38_size = 0;
		if (!request.getParameter("h4_38_size").equals(""))
			h4_38_size = Integer.parseInt(request.getParameter("h4_38_size"));
		int p4_38_size = 0;
		if (!request.getParameter("p4_38_size").equals(""))
			p4_38_size = Integer.parseInt(request.getParameter("p4_38_size"));
		int f4_38_size = 0;
		if (!request.getParameter("f4_38_size").equals(""))
			f4_38_size = Integer.parseInt(request.getParameter("f4_38_size"));
		int lc4_38_size = 0;
		if (!request.getParameter("lc4_38_size").equals(""))
			lc4_38_size = Integer.parseInt(request.getParameter("lc4_38_size"));
		double remarks_38_size = 00.00;
		if (!request.getParameter("remarks_38_size").equals(""))
			remarks_38_size = Double.parseDouble(request.getParameter("remarks_38_size"));
		// .............................................................................................................

		int h5_40_size = 0;
		if (!request.getParameter("h5_40_size").equals(""))
			h5_40_size = Integer.parseInt(request.getParameter("h5_40_size"));
		int p5_40_size = 0;
		if (!request.getParameter("p5_40_size").equals(""))
			p5_40_size = Integer.parseInt(request.getParameter("p5_40_size"));
		int f5_40_size = 0;
		if (!request.getParameter("f5_40_size").equals(""))
			f5_40_size = Integer.parseInt(request.getParameter("f5_40_size"));
		int lc5_40_size = 0;
		if (!request.getParameter("lc5_40_size").equals(""))
			lc5_40_size = Integer.parseInt(request.getParameter("lc5_40_size"));
		double remarks_40_size = 00.00;
		if (!request.getParameter("remarks_40_size").equals(""))
			remarks_40_size = Double.parseDouble(request.getParameter("remarks_40_size"));
		// ..........................................................................................................

		int h6_42_size = 0;
		if (!request.getParameter("h6_42_size").equals(""))
			h6_42_size = Integer.parseInt(request.getParameter("h6_42_size"));
		int p6_42_size = 0;
		if (!request.getParameter("p6_42_size").equals(""))
			p6_42_size = Integer.parseInt(request.getParameter("p6_42_size"));
		int f6_42_size = 0;
		if (!request.getParameter("f6_42_size").equals(""))
			f6_42_size = Integer.parseInt(request.getParameter("f6_42_size"));
		int lc6_42_size = 0;
		if (!request.getParameter("lc6_42_size").equals(""))
			lc6_42_size = Integer.parseInt(request.getParameter("lc6_42_size"));
		double remarks_42_size = 00.00;
		if (!request.getParameter("remarks_42_size").equals(""))
			remarks_42_size = Double.parseDouble(request.getParameter("remarks_42_size"));
		// .........................................................................................................................

		int h7_44_size = 0;
		if (!request.getParameter("h7_44_size").equals(""))
			h7_44_size = Integer.parseInt(request.getParameter("h7_44_size"));
		int p7_44_size = 0;
		if (!request.getParameter("p7_44_size").equals(""))
			p7_44_size = Integer.parseInt(request.getParameter("p7_44_size"));
		int f7_44_size = 0;
		if (!request.getParameter("f7_44_size").equals(""))
			f7_44_size = Integer.parseInt(request.getParameter("f7_44_size"));
		int lc7_44_size = 0;
		if (!request.getParameter("lc7_44_size").equals(""))
			lc7_44_size = Integer.parseInt(request.getParameter("lc7_44_size"));
		double remarks_44_size = 00.00;
		if (!request.getParameter("remarks_44_size").equals(""))
			remarks_44_size = Double.parseDouble(request.getParameter("remarks_44_size"));
		// ...................................................................................................

		int h8_46_size = 0;
		if (!request.getParameter("h8_46_size").equals(""))
			h8_46_size = Integer.parseInt(request.getParameter("h8_46_size"));
		int p8_46_size = 0;
		if (!request.getParameter("p8_46_size").equals(""))
			p8_46_size = Integer.parseInt(request.getParameter("p8_46_size"));
		int f8_46_size = 0;
		if (!request.getParameter("f8_46_size").equals(""))
			f8_46_size = Integer.parseInt(request.getParameter("f8_46_size"));
		int lc8_46_size = 0;
		if (!request.getParameter("lc8_46_size").equals(""))
			lc8_46_size = Integer.parseInt(request.getParameter("lc8_46_size"));
		double remarks_46_size = 00.00;
		if (!request.getParameter("remarks_46_size").equals(""))
			remarks_46_size = Double.parseDouble(request.getParameter("remarks_46_size"));
		// ...................................................................................................

		int h9_48_size = 0;
		if (!request.getParameter("h9_48_size").equals(""))
			h9_48_size = Integer.parseInt(request.getParameter("h9_48_size"));
		int p9_48_size = 0;
		if (!request.getParameter("p9_48_size").equals(""))
			p9_48_size = Integer.parseInt(request.getParameter("p9_48_size"));
		int f9_48_size = 0;
		if (!request.getParameter("f9_48_size").equals(""))
			f9_48_size = Integer.parseInt(request.getParameter("f9_48_size"));
		int lc9_48_size = 0;
		if (!request.getParameter("lc9_48_size").equals(""))
			lc9_48_size = Integer.parseInt(request.getParameter("lc9_48_size"));
		double remarks_48_size = 00.00;
		if (!request.getParameter("remarks_48_size").equals(""))
			remarks_48_size = Double.parseDouble(request.getParameter("remarks_48_size"));
		// ..........................................................................................................

	/*	int h10_50_size = 0;
		if (!request.getParameter("h10_50_size").equals(""))
			h10_50_size = Integer.parseInt(request.getParameter("h10_50_size"));
		int p10_50_size = 0;
		if (!request.getParameter("p10_50_size").equals(""))
			p10_50_size = Integer.parseInt(request.getParameter("p10_50_size"));
		int f10_50_size = 0;
		if (!request.getParameter("f10_50_size").equals(""))
			f10_50_size = Integer.parseInt(request.getParameter("f10_50_size"));
		int lc10_50_size = 0;
		if (!request.getParameter("lc10_50_size").equals(""))
			lc10_50_size = Integer.parseInt(request.getParameter("lc10_50_size"));
		double remarks_50_size = 0;
		if (!request.getParameter("remarks_50_size").equals(""))
			remarks_50_size = Double.parseDouble(request.getParameter("remarks_50_size"));   */
		//..........................................total_qtny..........................................................
		double total_h_s_g_c_qtny=h1_32_size+h2_34_size+h3_36_size+h4_38_size+h5_40_size+h6_42_size+h7_44_size+h8_46_size+h9_48_size;
		
		double total_p_o_qtny=p1_32_size+p2_34_size+p3_36_size+p4_38_size+p5_40_size+p6_42_size+p7_44_size+p8_46_size+p9_48_size;
		
		double total_f_p_o_qtny=f1_32_size+f2_34_size+f3_36_size+f4_38_size+f5_40_size+f6_42_size+f7_44_size+f8_46_size+f9_48_size;
		
		double total_l_c_qtny=lc1_32_size+lc2_34_size+lc3_36_size+lc4_38_size+lc5_40_size+lc6_42_size+lc7_44_size+lc8_46_size+lc9_48_size;
		
		double total_remarks=remarks_32_size+remarks_34_size+remarks_36_size+remarks_38_size+remarks_40_size+remarks_42_size+
				remarks_44_size+remarks_46_size+remarks_48_size;

		// .............................................................................................

		ReceiptOtherAirport2Pozo p2 = new ReceiptOtherAirport2Pozo(issue_vr_no, h1_32_size, p1_32_size, f1_32_size,
				lc1_32_size, remarks_32_size, h2_34_size, p2_34_size, f2_34_size, lc2_34_size, remarks_34_size,
				h3_36_size, p3_36_size, f3_36_size, lc3_36_size, remarks_36_size, h4_38_size, p4_38_size, f4_38_size,
				lc4_38_size, remarks_38_size, h5_40_size, p5_40_size, f5_40_size, lc5_40_size, remarks_40_size,
				h6_42_size, p6_42_size, f6_42_size, lc6_42_size, remarks_42_size, h7_44_size, p7_44_size, f7_44_size,
				lc7_44_size, remarks_44_size, h8_46_size, p8_46_size, f8_46_size, lc8_46_size, remarks_46_size,
				h9_48_size, p9_48_size, f9_48_size, lc9_48_size, remarks_48_size, total_h_s_g_c_qtny, total_p_o_qtny, total_f_p_o_qtny,
				total_l_c_qtny, total_remarks);

		ReceiptOtherAirport2Dao r2Dao = new ReceiptOtherAirport2Dao();
		/*
		 * LocationOtherAirport1Pozo p1=
		 * (LocationOtherAirport1Pozo)request.getAttribute("LocationOtherAirport1Pozo");
		 * try { int rs=d.ReceiptOtherAirport2(p2); if(rs!=0) {
		 * System.out.println(" Receipt method wrok");
		 * request.setAttribute("ReceiptOtherAirport2Pozo", p2);
		 * request.setAttribute("LocationOtherAirport1Pozo", p1); RequestDispatcher rd =
		 * request.getRequestDispatcher("Addition1and2and3ReceiptOther.jsp");
		 * 
		 * rd.forward(request, response); }else {
		 * System.out.println(" Receipt method not work"); }
		 * 
		 * } catch (Exception e) { // TODO: handle exception e.printStackTrace(); }
		 */

		int i = 0;
		try {
			i = r2Dao.ReceiptOtherAirport2(r1, p2);
			if (i != 0) {
				request.setAttribute("LocationOtherAirport1Pozo", l1);
				request.setAttribute("LocationOtherAirport1Pozo", l2);
				request.setAttribute("issue_date", issue_date);
				request.setAttribute("ReceiptOtherAirport2Pozo", p2);
				request.setAttribute("ReceiptOtherAirport1Pozo", r1);
				RequestDispatcher rd = request.getRequestDispatcher("Addition1and2and3ReceiptOther.jsp");

				rd.forward(request, response);
			} else {
				System.out.println("Error in database adding");
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

}
