package packingVoucher;

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
 * Servlet implementation class PackingVoucher1Servlet
 */
public class PackingVoucher1Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PackingVoucher1Servlet() {
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
		System.out.println("Packing Voucher..........................");
		// int SerialNo=Integer.parseInt(request.getParameter("SerialNo"));
		String n_a_consignee = request.getParameter("n_a_consignee");
		String ourreference = request.getParameter("ourreference");
		//int issuevoucherno = Integer.parseInt(request.getParameter("issuevoucherno"));
		String issuevoucherno = request.getParameter("issuevoucherno");
		// date...............date..................
		String pdate = request.getParameter("pdate");
		/*
		 * Date date = null; try { date = new
		 * SimpleDateFormat("yyyy-MM-dd").parse(issue_date); } catch (ParseException e1)
		 * { // TODO Auto-generated catch block e1.printStackTrace(); }
		 * System.out.println(date + "here.... ");
		 */
		Date date = null;
		try {
			date = new SimpleDateFormat("yyyy-MM-dd").parse(pdate);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println(date + "here.... ");
		SimpleDateFormat pdate1 = new SimpleDateFormat("dd-MM-yyyy");
		try {
			java.util.Date pdate2 = pdate1.parse(pdate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// shirting_cloth_...................................................................................
		double shirting1_cloth_mtrs = 00.00;
		if (!request.getParameter("shirting1_cloth_mtrs").equals(""))
			shirting1_cloth_mtrs = Double.parseDouble(request.getParameter("shirting1_cloth_mtrs"));
		double shirting2_cloth_mtrs = 00.00;
		if (!request.getParameter("shirting2_cloth_mtrs").equals(""))
			shirting2_cloth_mtrs = Double.parseDouble(request.getParameter("shirting2_cloth_mtrs"));
		int shirting1_cloth_pcs = 0;
		if (!request.getParameter("shirting1_cloth_pcs").equals(""))
			shirting1_cloth_pcs = Integer.parseInt(request.getParameter("shirting1_cloth_pcs"));
		int shirting2_cloth_pcs = 0;
		if (!request.getParameter("shirting2_cloth_pcs").equals(""))
			shirting2_cloth_pcs = Integer.parseInt(request.getParameter("shirting2_cloth_pcs"));

		double shirting_cloth_qnt = 00.00;
		shirting_cloth_qnt=(shirting1_cloth_mtrs * shirting1_cloth_pcs + shirting2_cloth_mtrs * shirting2_cloth_pcs);

		double shirting_cloth_remarks = 00.00;
		if (!request.getParameter("shirting_cloth_remarks").equals(""))
			shirting_cloth_remarks = Double.parseDouble(request.getParameter("shirting_cloth_remarks"));

		// paint1_cloth_..................................................................................................
		double paint1_cloth_mtrs = 00.00;
		if (!request.getParameter("paint1_cloth_mtrs").equals(""))
			paint1_cloth_mtrs = Double.parseDouble(request.getParameter("paint1_cloth_mtrs"));
		double paint2_cloth_mtrs = 00.00;
		if (!request.getParameter("paint2_cloth_mtrs").equals(""))
			paint2_cloth_mtrs = Double.parseDouble(request.getParameter("paint2_cloth_mtrs"));
		int paint1_cloth_pcs = 0;
		if (!request.getParameter("paint1_cloth_pcs").equals(""))
			paint1_cloth_pcs = Integer.parseInt(request.getParameter("paint1_cloth_pcs"));
		int paint2_cloth_pcs = 0;
		if (!request.getParameter("paint2_cloth_pcs").equals(""))
			paint2_cloth_pcs = Integer.parseInt(request.getParameter("paint2_cloth_pcs"));

		double paint_cloth_qtn = 00.00;
		paint_cloth_qtn=(paint1_cloth_mtrs * paint1_cloth_pcs + paint2_cloth_mtrs * paint2_cloth_pcs);

		double paint_cloth_remarks = 00.00;
		if (!request.getParameter("paint_cloth_remarks").equals(""))
			paint_cloth_remarks = Double.parseDouble(request.getParameter("paint_cloth_remarks"));

		// suit1_cloth_mtrs.........................................................................................
		double suit1_cloth_mtrs = 00.00;
		if (!request.getParameter("suit1_cloth_mtrs").equals(""))
			suit1_cloth_mtrs = Double.parseDouble(request.getParameter("suit1_cloth_mtrs"));
		double suit2_cloth_mtrs = 00.00;
		if (!request.getParameter("suit2_cloth_mtrs").equals(""))
			suit2_cloth_mtrs = Double.parseDouble(request.getParameter("suit2_cloth_mtrs"));
		int suit1_cloth_pcs = 0;
		if (!request.getParameter("suit1_cloth_pcs").equals(""))
			suit1_cloth_pcs = Integer.parseInt(request.getParameter("suit1_cloth_pcs"));
		int suit2_cloth_pcs = 0;
		if (!request.getParameter("suit2_cloth_pcs").equals(""))
			suit2_cloth_pcs = Integer.parseInt(request.getParameter("suit2_cloth_pcs"));

		double suit_cloth_qtn = 00.00;
		suit_cloth_qtn=(suit1_cloth_mtrs * suit1_cloth_pcs + suit2_cloth_mtrs * suit2_cloth_pcs);

		double suit_cloth_remarks = 00.00;
		if (!request.getParameter("suit_cloth_remarks").equals(""))
			suit_cloth_remarks = Double.parseDouble(request.getParameter("suit_cloth_remarks"));

		// blaizer1_cloth_mtrs.............................................................................................
		double blaizer1_cloth_mtrs = 00.00;
		if (!request.getParameter("blaizer1_cloth_mtrs").equals(""))
			blaizer1_cloth_mtrs = Double.parseDouble(request.getParameter("blaizer1_cloth_mtrs"));
		double blaizer2_cloth_mtrs = 00.00;
		if (!request.getParameter("blaizer2_cloth_mtrs").equals(""))
			blaizer2_cloth_mtrs = Double.parseDouble(request.getParameter("blaizer2_cloth_mtrs"));
		int blaizer1_cloth_pcs = 0;
		if (!request.getParameter("blaizer1_cloth_pcs").equals(""))
			blaizer1_cloth_pcs = Integer.parseInt(request.getParameter("blaizer1_cloth_pcs"));
		int blaizer2_cloth_pcs = 0;
		if (!request.getParameter("blaizer2_cloth_pcs").equals(""))
			blaizer2_cloth_pcs = Integer.parseInt(request.getParameter("blaizer2_cloth_pcs"));

		double blaizer_cloth_qtn = 00.00;
		blaizer_cloth_qtn=(blaizer1_cloth_mtrs * blaizer1_cloth_pcs + blaizer2_cloth_mtrs * blaizer2_cloth_pcs);

		double blaizer_cloth_remarks = 00.00;
		if (!request.getParameter("blaizer_cloth_remarks").equals(""))
			blaizer_cloth_remarks = Double.parseDouble(request.getParameter("blaizer_cloth_remarks"));

		// ........silk_saree_pcs.............................
		int silk_saree_pcs = 0;
		if (!request.getParameter("silk_saree_pcs").equals(""))
			silk_saree_pcs = Integer.parseInt(request.getParameter("silk_saree_pcs"));

		double silk_saree_qtn = 00.00;
		silk_saree_qtn=silk_saree_pcs;

		double silk_saree_remark = 00.00;
		if (!request.getParameter("silk_saree_remark").equals(""))
			silk_saree_remark = Double.parseDouble(request.getParameter("silk_saree_remark"));

		// ..........crape_saree_pcs...............................
		int crape_saree_pcs = 0;
		if (!request.getParameter("crape_saree_pcs").equals(""))
			crape_saree_pcs = Integer.parseInt(request.getParameter("crape_saree_pcs"));

		double crape_saree_qtn = 00.00;
		crape_saree_qtn=crape_saree_pcs;

		double crape_saree_remark = 00.00;
		if (!request.getParameter("crape_saree_remark").equals(""))
			crape_saree_remark = Double.parseDouble(request.getParameter("crape_saree_remark"));

		// ..................synthetic_saree_pcs..................
		int synthetic_saree_pcs = 0;
		if (!request.getParameter("synthetic_saree_pcs").equals(""))
			synthetic_saree_pcs = Integer.parseInt(request.getParameter("synthetic_saree_pcs"));

		double synthetic_saree_qtn=synthetic_saree_pcs;

		double synthetic_saree_remark = 00.00;
		if (!request.getParameter("synthetic_saree_remark").equals(""))
			synthetic_saree_remark = Double.parseDouble(request.getParameter("synthetic_saree_remark"));

		// ..................
		int neck_tie_pcs = 0;
		if (!request.getParameter("neck_tie_pcs").equals(""))
			neck_tie_pcs = Integer.parseInt(request.getParameter("neck_tie_pcs"));

		double neck_tie_qtn = 00.00;
		neck_tie_qtn=neck_tie_pcs;

		double neck_tie_remark = 00.00;
		if (!request.getParameter("neck_tie_remark").equals(""))
			neck_tie_remark = Double.parseDouble(request.getParameter("neck_tie_remark"));

		// ........scarves_pcs................
		int scarves_pcs = 0;
		if (!request.getParameter("scarves_pcs").equals(""))
			scarves_pcs = Integer.parseInt(request.getParameter("scarves_pcs"));

		double scarves_qtn = 00.00;
		scarves_qtn=scarves_pcs;

		double scarves_remark = 00.00;
		if (!request.getParameter("scarves_remark").equals(""))
			scarves_remark = Double.parseDouble(request.getParameter("scarves_remark"));

		PackingVoucher1Pozo p = new PackingVoucher1Pozo(n_a_consignee, ourreference, issuevoucherno,date,
				shirting1_cloth_mtrs, shirting2_cloth_mtrs, shirting1_cloth_pcs, shirting2_cloth_pcs, shirting_cloth_qnt,
				shirting_cloth_remarks, paint1_cloth_mtrs, paint2_cloth_mtrs, paint1_cloth_pcs, paint2_cloth_pcs,
				paint_cloth_qtn, paint_cloth_remarks, suit1_cloth_mtrs, suit2_cloth_mtrs, suit1_cloth_pcs, suit2_cloth_pcs,
				suit_cloth_qtn, suit_cloth_remarks, blaizer1_cloth_mtrs, blaizer2_cloth_mtrs, blaizer1_cloth_pcs,
				blaizer2_cloth_pcs, blaizer_cloth_qtn, blaizer_cloth_remarks, silk_saree_pcs, silk_saree_qtn,
				silk_saree_remark, crape_saree_pcs, crape_saree_qtn, crape_saree_remark, synthetic_saree_pcs,
				synthetic_saree_qtn, synthetic_saree_remark, neck_tie_pcs, neck_tie_qtn, neck_tie_remark, scarves_pcs,
				scarves_qtn, scarves_remark);

		try {
			String myObjectId = UUID.randomUUID().toString();
			request.getSession().setAttribute(myObjectId, p);
			request.setAttribute("myObjectId", myObjectId);

			request.setAttribute("PackingVoucher1Pozo", p);
			request.setAttribute("date", pdate);
			RequestDispatcher rd = request.getRequestDispatcher("PackingVoucher2.jsp");
			rd.forward(request, response);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}


}

//ctrl+shift+/ for multiple comment line

/*
 * PackingVoucher1Dao d = new PackingVoucher1Dao();
 * 
 * try { int rs = d.PackingVoucher1Servlet(p); if (rs != 0) {
 * System.out.println("PackingVoucher1Dao .................... servlet work.");
 * 
 * request.setAttribute("PackingVoucher1Pozo", p); /*
 * request.setAttribute("n_a_consignee", n_a_consignee);
 * 
 * request.setAttribute("ourreference", ourreference);
 * request.setAttribute("issuevoucherno", issuevoucherno);
 * request.setAttribute("date", date);
 * System.out.println("what is the problem......................");
 * request.setAttribute("shirting1_cloth_mtrs", shirting1_cloth_mtrs);
 * request.setAttribute("shirting2_cloth_mtrs", shirting2_cloth_mtrs);
 * request.setAttribute("shirting1_cloth_pcs", shirting1_cloth_pcs);
 * request.setAttribute("shirting2_cloth_pcs", shirting2_cloth_pcs);
 * request.setAttribute("shirting_cloth_remarks", shirting_cloth_remarks);
 * 
 * request.setAttribute("paint1_cloth_mtrs", paint1_cloth_mtrs);
 * request.setAttribute("paint2_cloth_mtrs", paint2_cloth_mtrs);
 * request.setAttribute("paint1_cloth_pcs", paint1_cloth_pcs);
 * request.setAttribute("paint2_cloth_pcs", paint2_cloth_pcs);
 * request.setAttribute("paint_cloth_remarks", paint_cloth_remarks);
 * 
 * request.setAttribute("suit1_cloth_mtrs", suit1_cloth_mtrs);
 * request.setAttribute("suit2_cloth_mtrs", suit2_cloth_mtrs);
 * request.setAttribute("suit1_cloth_pcs", suit1_cloth_pcs);
 * request.setAttribute("suit2_cloth_pcs", suit2_cloth_pcs);
 * request.setAttribute("suit_cloth_remarks", suit_cloth_remarks);
 * 
 * request.setAttribute("blaizer1_cloth_mtrs", blaizer1_cloth_mtrs);
 * request.setAttribute("blaizer2_cloth_mtrs", blaizer2_cloth_mtrs);
 * request.setAttribute("blaizer1_cloth_pcs", blaizer1_cloth_pcs);
 * request.setAttribute("blaizer2_cloth_pcs", blaizer2_cloth_pcs);
 * request.setAttribute("blaizer_cloth_remarks", blaizer_cloth_remarks);
 * 
 * request.setAttribute("silk_saree_pcs", silk_saree_pcs);
 * request.setAttribute("silk_saree_remark", silk_saree_remark);
 * 
 * request.setAttribute("crape_saree_pcs", crape_saree_pcs);
 * request.setAttribute("crape_saree_remark", crape_saree_remark);
 * 
 * request.setAttribute("synthetic_saree_pcs", synthetic_saree_pcs);
 * request.setAttribute("synthetic_saree_remark", synthetic_saree_remark);
 * 
 * request.setAttribute("neck_tie_pcs", neck_tie_pcs);
 * request.setAttribute("neck_tie_remark", neck_tie_remark);
 * 
 * request.setAttribute("scarves_pcs", scarves_pcs);
 * request.setAttribute("scarves_remark", scarves_remark);
 * System.out.println("what is the problem......................");
 * RequestDispatcher rd = request.getRequestDispatcher("PackingVoucher2.jsp");
 * //RequestDispatcher rd = request.getRequestDispatcher("PackingVoucher2.jsp");
 * rd.forward(request, response);
 * System.out.println("what is the problem......................");
 * 
 * } else { System.out.
 * println("PackingVoucher1Dao .................... servlet work not work.");
 * 
 * } } catch (Exception e) { // TODO: handle exception }

	}

}*/
