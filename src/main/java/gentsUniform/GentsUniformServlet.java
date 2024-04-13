package gentsUniform;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * Servlet implementation class GentsUniformServlet
 */
public class GentsUniformServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GentsUniformServlet() {
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
		
		System.out.println("Gents Unifrom Voucher...........Start to created ");
		int bookno = Integer.parseInt(request.getParameter("bookno"));
		int pgno = Integer.parseInt(request.getParameter("pgno"));
		int g_u_size = Integer.parseInt(request.getParameter("g_u_size"));
		int empno = Integer.parseInt(request.getParameter("empno"));
		String ename = request.getParameter("ename");
		String designation = request.getParameter("designation");
		String gdate = request.getParameter("gdate");
		String serialno = request.getParameter("serialno");
		Date date = null;
		try {
			date = new SimpleDateFormat("yyyy-MM-dd").parse(gdate);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println(date + "here.... ");
		SimpleDateFormat pdate1 = new SimpleDateFormat("dd-MM-yyyy");
		try {
			java.util.Date pdate2 = pdate1.parse(gdate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// ..........Shirting Cloth Meters..............................
		double shirting_cloth_mtrs = 00.00;
		if (!request.getParameter("shirting_cloth_mtrs").equals(""))
			shirting_cloth_mtrs = Double.parseDouble(request.getParameter("shirting_cloth_mtrs"));
		int shirting_cloth_pcs = 0;
		if (!request.getParameter("shirting_cloth_pcs").equals(""))
			shirting_cloth_pcs = Integer.parseInt(request.getParameter("shirting_cloth_pcs"));

		double shirting_cloth_qnt = shirting_cloth_mtrs * shirting_cloth_pcs;

		// .............Paint Cloth Meters................................
		double paint_cloth_mtrs = 00.00;
		if (!request.getParameter("paint_cloth_mtrs").equals(""))
			paint_cloth_mtrs = Double.parseDouble(request.getParameter("paint_cloth_mtrs"));
		int paint_cloth_pcs = 0;
		if (!request.getParameter("paint_cloth_pcs").equals(""))
			paint_cloth_pcs = Integer.parseInt(request.getParameter("paint_cloth_pcs"));

		double paint_cloth_qtn = paint_cloth_mtrs * paint_cloth_pcs;

		// ............Suit Cloth Meters..................................
		double suit_cloth_mtrs = 00.00;
		if (!request.getParameter("suit_cloth_mtrs").equals(""))
			suit_cloth_mtrs = Double.parseDouble(request.getParameter("suit_cloth_mtrs"));
		int suit_cloth_pcs = 0;
		if (!request.getParameter("suit_cloth_pcs").equals(""))
			suit_cloth_pcs = Integer.parseInt(request.getParameter("suit_cloth_pcs"));

		double suit_cloth_qtn = suit_cloth_mtrs * suit_cloth_pcs;

		// ............Pull Over...........................................
		int pullover = 0;
		if (!request.getParameter("pullover").equals(""))
			pullover = Integer.parseInt(request.getParameter("pullover"));
		double total_p_o_qtny = pullover;

		// total_h_s_g_c_qtny,total_p_o_qtny,total_f_p_o_qtny, scarves_qtn,
		// neck_tie_qtn;

		int h_s_cardigan = 0;
		if (!request.getParameter("h_s_cardigan").equals(""))
			h_s_cardigan = Integer.parseInt(request.getParameter("h_s_cardigan"));
		double total_h_s_g_c_qtny = h_s_cardigan;

		int neck_tie_pcs = 0;
		if (!request.getParameter("neck_tie_pcs").equals(""))
			neck_tie_pcs = Integer.parseInt(request.getParameter("neck_tie_pcs"));
		double neck_tie_qtn = neck_tie_pcs;

		int scarves_pcs = 0;
		if (!request.getParameter("scarves_pcs").equals(""))
			scarves_pcs = Integer.parseInt(request.getParameter("scarves_pcs"));
		double scarves_qtn = scarves_pcs;

		int f_p_over = 0;
		if (!request.getParameter("f_p_over").equals(""))
			f_p_over = Integer.parseInt(request.getParameter("f_p_over"));
		double total_f_p_o_qtny = f_p_over;
//error below
		GentsUniformPozo p = new GentsUniformPozo(bookno, pgno, g_u_size, empno, ename, designation, date, serialno,
				shirting_cloth_mtrs, shirting_cloth_pcs, shirting_cloth_qnt, paint_cloth_mtrs, paint_cloth_pcs,
				paint_cloth_qtn, suit_cloth_mtrs, suit_cloth_pcs, suit_cloth_qtn, pullover, total_p_o_qtny,
				h_s_cardigan, total_h_s_g_c_qtny, neck_tie_pcs, neck_tie_qtn, scarves_pcs, scarves_qtn, f_p_over,
				total_f_p_o_qtny);

		GentsUniformDao d = new GentsUniformDao();
		try {
			int rs = d.GentsUniformServlet(p);
			String myObjectId = UUID.randomUUID().toString();
			request.getSession().setAttribute(myObjectId, p);
			request.setAttribute("myObjectId", myObjectId);

			request.setAttribute("GentsUniformPozo", p);

			request.setAttribute("date", gdate);
			request.setAttribute("serialno", serialno);
			RequestDispatcher rd = request.getRequestDispatcher("GentsUniform.jsp");
			rd.forward(request, response);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

}
