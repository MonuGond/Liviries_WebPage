package ladiesUniform;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class LadiesUniformDao {
	private Connection conn = null;
	private PreparedStatement ps = null;
	ResultSet rs = null;
	public int LadiesUniformServlet(LadiesUniformPozo p) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "System", "tiger1");
		String query = "insert into ladiesUniform values (?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?)";
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
		ps.setInt(9, p.getS_saree_pcs());
		ps.setDouble(10, p.getSilk_saree_qtn());
		ps.setInt(11, p.getC_saree_pcs());
		ps.setDouble(12, p.getCrape_saree_qtn());
		ps.setInt(13, p.getSyn_saree_pcs());
		ps.setDouble(14, p.getSynthetic_saree_qtn());
		ps.setInt(15, p.getPullover());
		ps.setDouble(16, p.getTotal_p_o_qtny());
		ps.setInt(17, p.getH_s_cardigan());
		ps.setDouble(18, p.getTotal_h_s_g_c_qtny());
		ps.setInt(19, p.getCardigan_pcs());
		ps.setDouble(20, p.getTotal_l_c_qtny());
		ps.setInt(21, p.getScarves_pcs());
		ps.setDouble(22, p.getScarves_qtn());
		ps.setInt(23, p.getF_p_over());
		ps.setDouble(24, p.getTotal_f_p_o_qtny());
		int rs = ps.executeUpdate();
		return rs;
	}
	public ArrayList<ladiesUniform.LadiesUniformPozo> getDataFromDao(String serialno) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "System", "tiger1");
		String querypdf = "select * from ladiesUniform where serialno ='" + serialno + "'";
		ps = conn.prepareStatement(querypdf);
		rs = ps.executeQuery();
		ArrayList<LadiesUniformPozo> ladiesspdf = new ArrayList<>();
		while (rs.next()) {
			LadiesUniformPozo d = new LadiesUniformPozo();
			d.setBookno(rs.getInt(1));
			d.setPgno(rs.getInt(2));
			d.setG_u_size(rs.getInt(3));
			d.setEmpno(rs.getInt(4));
			d.setEname(rs.getString(5));
			d.setDesignation(rs.getString(6));
			d.setGdate(rs.getDate(7));
			d.setSerialno(rs.getString(8));
			d.setS_saree_pcs(rs.getInt(9));
			d.setSilk_saree_qtn(rs.getDouble(10));
			d.setC_saree_pcs(rs.getInt(11));
			d.setCrape_saree_qtn(12);
			d.setSyn_saree_pcs(rs.getInt(13));
			d.setSynthetic_saree_qtn(rs.getDouble(14));
			d.setPullover(rs.getInt(15));
			d.setTotal_p_o_qtny(rs.getDouble(16));
			
			d.setH_s_cardigan(rs.getInt(17));
			d.setTotal_h_s_g_c_qtny(rs.getDouble(18));
			d.setCardigan_pcs(rs.getInt(19));
			d.setTotal_l_c_qtny(rs.getDouble(20));
			d.setScarves_pcs(rs.getInt(21));
			d.setScarves_qtn(rs.getDouble(22));
			d.setF_p_over(rs.getInt(23));
			d.setTotal_f_p_o_qtny(rs.getDouble(24));
			ladiesspdf.add(d);
		}
		return ladiesspdf;
		
	}
	
	// ...................Update Table.............................
		public int LadiesUniformUpdate(LadiesUniformPozo p) throws ClassNotFoundException, SQLException {
			// TODO Auto-generated method stub
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "System", "tiger1");
			String queryupdate = "update ladiesUniform set bookno=?, pgno=?, g_u_size=?, empno=?, ename=?, designation=?,"
					+ "gdate=?,s_saree_pcs=?, silk_saree_qtn=?, c_saree_pcs=?, crape_saree_qtn=?, syn_saree_pcs=?,"
					+ "synthetic_saree_qtn=?, pullover=?,total_p_o_qtny=?, h_s_cardigan=?, total_h_s_g_c_qtny=?,cardigan_pcs=?,"
					+ "total_l_c_qtny=?,scarves_pcs=?,scarves_qtn=?,f_p_over=?,total_f_p_o_qtny=? where  serialno=?";
			ps=conn.prepareStatement(queryupdate);
			ps.setInt(1, p.getBookno());
			ps.setInt(2, p.getPgno());
			ps.setInt(3, p.getG_u_size());
			ps.setInt(4, p.getEmpno());
			ps.setString(5, p.getEname());
			ps.setString(6, p.getDesignation());
			java.sql.Date sqldate= new java.sql.Date(p.getGdate().getTime());
			ps.setDate(7, sqldate);
			
			//ps.setString(8, p.getSerialno());
			ps.setInt(8, p.getS_saree_pcs());
			ps.setDouble(9, p.getSilk_saree_qtn());
			
			ps.setInt(10, p.getC_saree_pcs());
			ps.setDouble(11, p.getCrape_saree_qtn());
			
			ps.setInt(12, p.getSyn_saree_pcs());
			ps.setDouble(13, p.getSynthetic_saree_qtn());
			
			ps.setInt(14, p.getPullover());
			ps.setDouble(15, p.getTotal_p_o_qtny());
			
			ps.setInt(16, p.getH_s_cardigan());
			ps.setDouble(17, p.getTotal_h_s_g_c_qtny());
			
			ps.setInt(18, p.getCardigan_pcs());
			ps.setDouble(19, p.getTotal_l_c_qtny());
			
			ps.setInt(20, p.getScarves_pcs());
			ps.setDouble(21, p.getScarves_qtn());
			
			ps.setInt(22, p.getF_p_over());
			ps.setDouble(23, p.getTotal_f_p_o_qtny());
			
			ps.setString(24, p.getSerialno());
			
			int rs=ps.executeUpdate();
			return rs;
		}
	
	

}
