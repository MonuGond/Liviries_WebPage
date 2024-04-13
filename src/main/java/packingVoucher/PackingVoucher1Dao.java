package packingVoucher;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class PackingVoucher1Dao {
	private Connection conn = null;
	private PreparedStatement ps = null;
	ResultSet rs = null;

	public int PackingVoucher1Servlet(PackingVoucher1Pozo p) throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "System", "tiger1");

		String query = "insert into PackingVoucher1 values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,"
 				+ "?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		ps = conn.prepareStatement(query);
		// ps.setString(1,p.getSerialNo());packingvoucher1_sequence.NEXTVAL,
		ps.setString(1, p.getN_a_consignee());
		ps.setString(2, p.getOurreference());
		
		//ps.setInt(3, p.getIssuevoucherno());
		ps.setString(3, p.getIssuevoucherno());
		
		java.sql.Date sqldate = new java.sql.Date(p.getPdate().getTime());
		System.out.println("sql date in Dao .................." + sqldate);
		ps.setDate(4, sqldate);

		ps.setDouble(5, p.getShirting1_cloth_mtrs());
		ps.setDouble(6, p.getShirting2_cloth_mtrs());
		ps.setInt(7, p.getShirting1_cloth_pcs());
		ps.setInt(8, p.getShirting2_cloth_pcs());
		ps.setDouble(9, p.getShirting_cloth_qnt());// qty added
		ps.setDouble(10, p.getShirting_cloth_remarks());

		ps.setDouble(11, p.getPaint1_cloth_mtrs());
		ps.setDouble(12, p.getPaint2_cloth_mtrs());
		ps.setInt(13, p.getPaint1_cloth_pcs());
		ps.setInt(14, p.getPaint2_cloth_pcs());
		ps.setDouble(15, p.getPaint_cloth_qtn());// qty added
		ps.setDouble(16, p.getPaint_cloth_remarks());

		ps.setDouble(17, p.getSuit1_cloth_mtrs());
		ps.setDouble(18, p.getSuit2_cloth_mtrs());
		ps.setInt(19, p.getSuit1_cloth_pcs());
		ps.setInt(20, p.getSuit2_cloth_pcs());
		ps.setDouble(21, p.getSuit_cloth_qtn());// qty added
		ps.setDouble(22, p.getSuit_cloth_remarks());

		ps.setDouble(23, p.getBlaizer1_cloth_mtrs());
		ps.setDouble(24, p.getBlaizer2_cloth_mtrs());
		ps.setInt(25, p.getBlaizer1_cloth_pcs());
		ps.setInt(26, p.getBlaizer2_cloth_pcs());
		ps.setDouble(27, p.getBlaizer_cloth_qtn());// qty added
		ps.setDouble(28, p.getBlaizer_cloth_remarks());

		ps.setInt(29, p.getSilk_saree_pcs());
		ps.setDouble(30, p.getSilk_saree_qtn());// qty added
		ps.setDouble(31, p.getSilk_saree_remark());

		ps.setInt(32, p.getCrape_saree_pcs());
		ps.setDouble(33, p.getCrape_saree_qtn());// qty added
		ps.setDouble(34, p.getCrape_saree_remark());

		ps.setInt(35, p.getSynthetic_saree_pcs());
		ps.setDouble(36, p.getSynthetic_saree_qtn());// qty added
		ps.setDouble(37, p.getSynthetic_saree_remark());

		ps.setInt(38, p.getNeck_tie_pcs());
		ps.setDouble(39, p.getNeck_tie_qtn());// qty added
		ps.setDouble(40, p.getNeck_tie_remark());

		ps.setInt(41, p.getScarves_pcs());
		ps.setDouble(42, p.getScarves_qtn());// qty added
		ps.setDouble(43, p.getScarves_remark());
		
		int rs = ps.executeUpdate();

		return rs;

	}
	
	
	
	
	
	
	
	
	//..................Yha Pdf Dao Method Ko create Kiya Jaa Rha hai..............................................

	public ArrayList<PackingVoucher1Pozo> getPdfDataFromDao(String issue_number) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "System", "tiger1");
		String querypdf="select * from packingvoucher1 where issuevoucherno='"+issue_number+"'";
		ps=conn.prepareStatement(querypdf);
		rs=ps.executeQuery();
		ArrayList<PackingVoucher1Pozo>packingpdf=new ArrayList<>();
		while(rs.next()) {
			PackingVoucher1Pozo d = new PackingVoucher1Pozo();
			d.setN_a_consignee(rs.getString(1));
			d.setOurreference(rs.getString(2));
			//d.setIssuevoucherno(rs.getInt(3));
			d.setIssuevoucherno(rs.getString(3));
			d.setPdate(rs.getDate(4));
			
			d.setShirting1_cloth_mtrs(rs.getDouble(5));
			d.setShirting2_cloth_mtrs(rs.getDouble(6));
			d.setShirting1_cloth_pcs(rs.getInt(7));
			d.setShirting2_cloth_pcs(rs.getInt(8));
			d.setShirting_cloth_qnt(rs.getDouble(9));
			d.setShirting_cloth_remarks(rs.getDouble(10));
			
			d.setPaint1_cloth_mtrs(rs.getDouble(11));
			d.setPaint2_cloth_mtrs(rs.getDouble(12));
			d.setPaint1_cloth_pcs(rs.getInt(13));
			d.setPaint2_cloth_pcs(rs.getInt(14));
			d.setPaint_cloth_qtn(rs.getDouble(15));
			d.setPaint_cloth_remarks(rs.getDouble(16));
			
			d.setSuit1_cloth_mtrs(rs.getDouble(17));
			d.setSuit2_cloth_mtrs(rs.getDouble(18));
			d.setSuit1_cloth_pcs(rs.getInt(19));
			d.setSuit2_cloth_pcs(rs.getInt(20));
			d.setSuit_cloth_qtn(rs.getDouble(21));
			d.setSuit_cloth_remarks(rs.getDouble(22));
			
			d.setBlaizer1_cloth_mtrs(rs.getDouble(23));
			d.setBlaizer2_cloth_mtrs(rs.getDouble(24));
			d.setBlaizer1_cloth_pcs(rs.getInt(25));
			d.setBlaizer2_cloth_pcs(rs.getInt(26));
			d.setBlaizer_cloth_qtn(rs.getDouble(27));
			d.setBlaizer_cloth_remarks(rs.getDouble(28));
			
			d.setSilk_saree_pcs(rs.getInt(29));
			d.setSilk_saree_qtn(rs.getDouble(30));
			d.setSilk_saree_remark(rs.getDouble(31));
			
			d.setCrape_saree_pcs(rs.getInt(32));
			d.setCrape_saree_qtn(rs.getDouble(33));
			d.setCrape_saree_remark(rs.getDouble(34));
			
			d.setSynthetic_saree_pcs(rs.getInt(35));
			d.setSynthetic_saree_qtn(rs.getDouble(36));
			d.setSynthetic_saree_remark(rs.getDouble(37));
			
			d.setNeck_tie_pcs(rs.getInt(38));
			d.setNeck_tie_qtn(rs.getDouble(39));
			d.setNeck_tie_remark(rs.getDouble(40));
			
			d.setScarves_pcs(rs.getInt(41));
			d.setScarves_qtn(rs.getDouble(42));
			d.setScarves_remark(rs.getDouble(43));
			
			packingpdf.add(d);
			System.out.println("sending data from dao to Pdf............. ");
		}
		return packingpdf;
	}


}
