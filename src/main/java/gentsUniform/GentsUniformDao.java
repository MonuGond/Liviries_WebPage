package gentsUniform;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class GentsUniformDao {
	private Connection conn = null;
	private PreparedStatement ps = null;
	ResultSet rs = null;

	public int GentsUniformServlet(GentsUniformPozo p) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "System", "tiger1");
		String query = "insert into gentsuniform values (?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?)";
		ps = conn.prepareStatement(query);
		ps.setInt(1, p.getBookno());
		ps.setInt(2, p.getPgno());
		ps.setInt(3, p.getG_u_size());
		ps.setInt(4, p.getEmpno());
		ps.setString(5, p.getEname());
		ps.setString(6, p.getDesignation());
		java.sql.Date sqldate = new java.sql.Date(p.getGdate().getTime());
		System.out.println("sql date in Dao .................." + sqldate);
		ps.setDate(7, sqldate);
		ps.setString(8, p.getSerialno());
		ps.setDouble(9, p.getShirting_cloth_mtrs());
		ps.setInt(10, p.getShirting_cloth_pcs());
		ps.setDouble(11, p.getShirting_cloth_qnt());
		ps.setDouble(12, p.getPaint_cloth_mtrs());
		ps.setInt(13, p.getPaint_cloth_pcs());
		ps.setDouble(14, p.getPaint_cloth_qtn());
		ps.setDouble(15, p.getSuit_cloth_mtrs());
		ps.setInt(16, p.getSuit_cloth_pcs());
		ps.setDouble(17, p.getSuit_cloth_qtn());
		ps.setInt(18, p.getPullover());
		ps.setDouble(19, p.getTotal_p_o_qtny());
		ps.setInt(20, p.getH_s_cardigan());
		ps.setDouble(21, p.getTotal_h_s_g_c_qtny());
		ps.setInt(22, p.getNeck_tie_pcs());
		ps.setDouble(23, p.getNeck_tie_qtn());
		ps.setInt(24, p.getScarves_pcs());
		ps.setDouble(25, p.getScarves_qtn());
		ps.setInt(26, p.getF_p_over());
		ps.setDouble(27, p.getTotal_f_p_o_qtny());
		int rs = ps.executeUpdate();
		return rs;
	}

	// ..................Pdf Data sent To Servlet....................

		public ArrayList<GentsUniformPozo> getDataFromDao(String serialno) throws ClassNotFoundException, SQLException {
			// TODO Auto-generated method stub
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "System", "tiger1");
			String querypdf = "select * from gentsuniform where serialno ='" + serialno + "'";
			ps = conn.prepareStatement(querypdf);
			rs = ps.executeQuery();
			ArrayList<GentsUniformPozo> gentspdf = new ArrayList<>();
			while (rs.next()) {
				GentsUniformPozo d = new GentsUniformPozo();
				d.setBookno(rs.getInt(1));
				d.setPgno(rs.getInt(2));
				d.setG_u_size(rs.getInt(3));
				d.setEmpno(rs.getInt(4));
				d.setEname(rs.getString(5));
				d.setDesignation(rs.getString(6));
				d.setGdate(rs.getDate(7));
				d.setSerialno(rs.getString(8));
				d.setShirting_cloth_mtrs(rs.getDouble(9));
				d.setShirting_cloth_pcs(rs.getInt(10));
				d.setShirting_cloth_qnt(rs.getDouble(11));

				d.setPaint_cloth_mtrs(rs.getDouble(12));
				d.setPaint_cloth_pcs(rs.getInt(13));
				d.setPaint_cloth_qtn(rs.getDouble(14));

				d.setSuit_cloth_mtrs(rs.getDouble(15));
				d.setSuit_cloth_pcs(rs.getInt(16));
				d.setSuit_cloth_qtn(rs.getDouble(17));
	//total_h_s_g_c_qtny,total_p_o_qtny,total_f_p_o_qtny,scarves_qtn,neck_tie_qtn;
				d.setPullover(rs.getInt(18));
				d.setTotal_p_o_qtny(rs.getDouble(19));

				d.setH_s_cardigan(rs.getInt(20));
				d.setTotal_h_s_g_c_qtny(rs.getDouble(21));

				d.setNeck_tie_pcs(rs.getInt(22));
				d.setNeck_tie_qtn(rs.getDouble(23));

				d.setScarves_pcs(rs.getInt(24));
				d.setScarves_qtn(rs.getDouble(25));

				d.setF_p_over(rs.getInt(26));
				d.setTotal_f_p_o_qtny(rs.getDouble(27));
				gentspdf.add(d);

			}
			return gentspdf;
		}
		
		// ....................................Update......................................................
		// Form....................................
		//total_h_s_g_c_qtny,total_p_o_qtny,total_f_p_o_qtny,scarves_qtn,neck_tie_qtn;
		public int GentsVoucherUpdate(GentsUniformPozo p) throws ClassNotFoundException, SQLException {
			// TODO Auto-generated method stub
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "System", "tiger1");
			String queryupdate = "update gentsuniform set bookno=?,pgno=?,g_u_size=?,empno=?,ename=?,designation=?,"
					+ "gdate=?,shirting_cloth_mtrs=?,shirting_cloth_pcs=?,shirting_cloth_qnt=?,"
					+ "paint_cloth_mtrs=?,paint_cloth_pcs=?,paint_cloth_qtn=?,suit_cloth_mtrs=?,"
					+ "suit_cloth_pcs=?,suit_cloth_qtn=?,pullover=?,total_p_o_qtny=?,h_s_cardigan=?,total_h_s_g_c_qtny=?,"
					+ "neck_tie_pcs=?,neck_tie_qtn=?,scarves_pcs=?,scarves_qtn=?,f_p_over=?,total_f_p_o_qtny=? where serialno=?";
			ps = conn.prepareStatement(queryupdate);
			ps.setInt(1, p.getBookno());
			System.out.println(p.getBookno());
			ps.setInt(2, p.getPgno());
			ps.setInt(3, p.getG_u_size());
			ps.setInt(4, p.getEmpno());
			ps.setString(5, p.getEname());  
			ps.setString(6, p.getDesignation());
			java.sql.Date sqldate = new java.sql.Date(p.getGdate().getTime());
			System.out.println("sql date in Dao .................." + sqldate);
			ps.setDate(7, sqldate);

		//	ps.setString(8, p.getSerialno());
			ps.setDouble(8, p.getShirting_cloth_mtrs());
			ps.setInt(9, p.getShirting_cloth_pcs());
			ps.setDouble(10, p.getShirting_cloth_qnt());
			
			ps.setDouble(11, p.getPaint_cloth_mtrs());
			ps.setInt(12, p.getPaint_cloth_pcs());
			ps.setDouble(13, p.getPaint_cloth_qtn());
			
			ps.setDouble(14, p.getSuit_cloth_mtrs());
			ps.setInt(15, p.getSuit_cloth_pcs());
			ps.setDouble(16, p.getSuit_cloth_qtn());
			
			ps.setInt(17, p.getPullover());
			ps.setDouble(18, p.getTotal_p_o_qtny());
			
			ps.setInt(19, p.getH_s_cardigan());
			ps.setDouble(20, p.getTotal_h_s_g_c_qtny());
			
			ps.setInt(21, p.getNeck_tie_pcs());
			ps.setDouble(22, p.getNeck_tie_qtn());
		
			ps.setInt(23, p.getScarves_pcs());
			ps.setDouble(24, p.getScarves_qtn());
			
			ps.setInt(25, p.getF_p_over());
			ps.setDouble(26, p.getTotal_f_p_o_qtny());
			
			ps.setString(27, p.getSerialno());
			System.out.println("Total 27 Value call................................");

			int rs = ps.executeUpdate();

			return rs;
		}
	

}
