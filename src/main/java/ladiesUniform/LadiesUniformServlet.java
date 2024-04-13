package ladiesUniform;

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
 * Servlet implementation class LadiesUniformServlet
 */
public class LadiesUniformServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LadiesUniformServlet() {
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
		
		System.out.println("Ladies Unifrom Voucher...........Start to created ");
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
		// private double silk_saree_qtn,crape_saree_qtn,synthetic_saree_qtn;
		// private double
		// total_p_o_qtny,total_h_s_g_c_qtny,total_l_c_qtny,scarves_qtn,total_f_p_o_qtny;
		int s_saree_pcs = 0;
		if (!request.getParameter("s_saree_pcs").equals(""))
			s_saree_pcs = Integer.parseInt(request.getParameter("s_saree_pcs"));
		double silk_saree_qtn = s_saree_pcs;

		int c_saree_pcs = 0;
		if (!request.getParameter("c_saree_pcs").equals(""))
			c_saree_pcs = Integer.parseInt(request.getParameter("c_saree_pcs"));
		double crape_saree_qtn = c_saree_pcs;

		int syn_saree_pcs = 0;
		if (!request.getParameter("syn_saree_pcs").equals(""))
			syn_saree_pcs = Integer.parseInt(request.getParameter("syn_saree_pcs"));
		double synthetic_saree_qtn = syn_saree_pcs;

		int pullover = 0;
		if (!request.getParameter("pullover").equals(""))
			pullover = Integer.parseInt(request.getParameter("pullover"));
		double total_p_o_qtny = pullover;

		int h_s_cardigan = 0;
		if (!request.getParameter("h_s_cardigan").equals(""))
			h_s_cardigan = Integer.parseInt(request.getParameter("h_s_cardigan"));
		double total_h_s_g_c_qtny = h_s_cardigan;

		int cardigan_pcs = 0;
		if (!request.getParameter("cardigan_pcs").equals(""))
			cardigan_pcs = Integer.parseInt(request.getParameter("cardigan_pcs"));
		double total_l_c_qtny = cardigan_pcs;

		int scarves_pcs = 0;
		if (!request.getParameter("scarves_pcs").equals(""))
			scarves_pcs = Integer.parseInt(request.getParameter("scarves_pcs"));
		double scarves_qtn = scarves_pcs;

		int f_p_over = 0;
		if (!request.getParameter("f_p_over").equals(""))
			f_p_over = Integer.parseInt(request.getParameter("f_p_over"));
		double total_f_p_o_qtny = f_p_over;

		LadiesUniformPozo p = new LadiesUniformPozo(bookno, pgno, g_u_size, empno, ename, designation, date, serialno,
				s_saree_pcs, c_saree_pcs, syn_saree_pcs, pullover, h_s_cardigan, cardigan_pcs, scarves_pcs, f_p_over,
				silk_saree_qtn, crape_saree_qtn, synthetic_saree_qtn, total_p_o_qtny, total_h_s_g_c_qtny,
				total_l_c_qtny, scarves_qtn, total_f_p_o_qtny);
		LadiesUniformDao d = new LadiesUniformDao();

		try {
			int rs = d.LadiesUniformServlet(p);
			String myObjectId = UUID.randomUUID().toString();
			request.getSession().setAttribute(myObjectId, p);
			request.setAttribute("myObjectId", myObjectId);

			request.setAttribute("serialno", serialno);
			request.setAttribute("LadiesUniformPozo", p);
			request.setAttribute("date", gdate);

			RequestDispatcher rd = request.getRequestDispatcher("LadiesUniform.jsp");
			rd.forward(request, response);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

}
