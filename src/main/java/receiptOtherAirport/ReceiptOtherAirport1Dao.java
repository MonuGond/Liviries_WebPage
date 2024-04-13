package receiptOtherAirport;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class ReceiptOtherAirport1Dao {
	private Connection conn=null;
	private PreparedStatement ps = null;
	private ResultSet rs=null;
	
	
	
	public int ReceiptOtherAirport1(ReceiptOtherAirport1Pozo p) throws SQLException, ClassNotFoundException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "System", "tiger1");
		String query="insert into ReceiptOtherAirport1 values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,"
															+ "?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,"
															+ "?,?,?,?,?)";
		/*ReceiptOtherAirport1_sequence.NEXTVAL,*/
		ps=conn.prepareStatement(query);
		ps.setString(1, p.getT_receiver());
		ps.setString(2, p.getT_airportname());
		ps.setString(3, p.getT_airportaddress());
		
		ps.setString(4, p.getF_sender());
		ps.setString(5, p.getF_airportname());
		ps.setString(6, p.getF_airportaddress());
 		//ps.setInt(3, p.getIssue_vr_no());
		ps.setString(7, p.getIssue_vr_no());
		//for date
		java.sql.Date sqldate= new java.sql.Date(p.getIssue_date().getTime());
		System.out.println("sql date in Dao .................."+sqldate);
		ps.setDate(8, sqldate);
		
		ps.setDouble(9, p.getShirting1_cloth_mtrs());
		ps.setInt(10, p.getShirting1_cloth_pcs());
		ps.setDouble(11, p.getShirting2_cloth_mtrs());
		ps.setInt(12, p.getShirting2_cloth_pcs());
		ps.setDouble(13, p.getShirting_cloth_qnt());
		ps.setDouble(14, p.getShirting_cloth_remarks());
		
		ps.setDouble(15, p.getPaint1_cloth_mtrs());
		ps.setInt(16, p.getPaint1_cloth_pcs());
		ps.setDouble(17, p.getPaint2_cloth_mtrs());
		ps.setInt(18, p.getPaint2_cloth_pcs());
		ps.setDouble(19, p.getPaint_cloth_qtn());
		ps.setDouble(20, p.getPaint_cloth_remarks());
		
		ps.setDouble(21, p.getSuit1_cloth_mtrs());
		ps.setInt(22, p.getSuit1_cloth_pcs());
		ps.setDouble(23, p.getSuit2_cloth_mtrs());
		ps.setInt(24, p.getSuit2_cloth_pcs());
		ps.setDouble(25, p.getSuit_cloth_qtn());
		ps.setDouble(26, p.getSuit_cloth_remarks());
		
		ps.setDouble(27, p.getBlaizer1_cloth_mtrs());
		ps.setInt(28, p.getBlaizer1_cloth_pcs());
		ps.setDouble(29, p.getBlaizer2_cloth_mtrs());
		ps.setInt(30, p.getBlaizer2_cloth_pcs());
		ps.setDouble(31, p.getBlaizer_cloth_qtn());
		ps.setDouble(32, p.getBlaizer_cloth_remarks());
		
		ps.setInt(33, p.getSilk_saree_pcs());
		ps.setDouble(34, p.getSilk_saree_qtn());
		ps.setDouble(35, p.getSilk_saree_remark());
		
		ps.setInt(36, p.getCrape_saree_pcs());
		ps.setDouble(37, p.getCrape_saree_qtn());
		ps.setDouble(38, p.getCrape_saree_remark());
		
		ps.setInt(39, p.getSynthetic_saree_pcs());
		ps.setDouble(40, p.getSynthetic_saree_qtn());
		ps.setDouble(41, p.getSynthetic_saree_remark());
		
		ps.setInt(42, p.getNeck_tie_pcs());
		ps.setDouble(43, p.getNeck_tie_qtn());
		ps.setDouble(44, p.getNeck_tie_remark());
		
		ps.setInt(45, p.getScarves_pcs());
		ps.setDouble(46, p.getScarves_qtn());
		ps.setDouble(47, p.getScarves_remark());
		
		int rs=ps.executeUpdate();
		//............................................................
	/*	String query1="SELECT ReceiptOtherAirport1_sequence.CURRVAL from dual";
		PreparedStatement ps1= conn.prepareStatement(query1);
		ResultSet rs1= ps1.executeQuery();
		int issue_vr_no=0;
		while (rs1.next()) {
			issue_vr_no=rs1.getInt(1);
		}       */
		return rs;
	}


	// ............................................pdf data..................................

	public ArrayList<ReceiptOtherAirport1Pozo> getPdfDataFromReceiptOther(String issue_vr_no) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "System", "tiger1");
		String querypdfreceipt = "select * from ReceiptOtherAirport1 where issue_vr_no='"+issue_vr_no+"'";
		ps=conn.prepareStatement(querypdfreceipt);
		rs=ps.executeQuery();
		ArrayList<ReceiptOtherAirport1Pozo> roapdf=new ArrayList<>();
		while(rs.next()) {
			ReceiptOtherAirport1Pozo d = new ReceiptOtherAirport1Pozo();
			//d.setAirportname(rs.getString(1));
			//d.setAirportaddress(rs.getString(2));
			//d.setIssue_vr_no(rs.getInt(3));
			d.setT_receiver(rs.getString(1));
			d.setT_airportname(rs.getString(2));
			d.setT_airportaddress(rs.getString(3));
			d.setF_sender(rs.getString(4));
			d.setF_airportname(rs.getString(5));
			d.setF_airportaddress(rs.getString(6));
			d.setIssue_vr_no(rs.getString(7));
			d.setIssue_date(rs.getDate(8));
			
			d.setShirting1_cloth_mtrs(rs.getDouble(9));
			d.setShirting1_cloth_pcs(rs.getInt(10));
			d.setShirting2_cloth_mtrs(rs.getDouble(11));
			d.setShirting2_cloth_pcs(rs.getInt(12));
			d.setShirting_cloth_qnt(rs.getDouble(13));
			d.setShirting_cloth_remarks(rs.getDouble(14));
			
			d.setPaint1_cloth_mtrs(rs.getDouble(15));
			d.setPaint1_cloth_pcs(rs.getInt(16));
			d.setPaint2_cloth_mtrs(rs.getDouble(17));
			d.setPaint2_cloth_pcs(rs.getInt(18));
			d.setPaint_cloth_qtn(rs.getDouble(19));
			d.setPaint_cloth_remarks(rs.getDouble(20));
			
			d.setSuit1_cloth_mtrs(rs.getDouble(21));
			d.setSuit1_cloth_pcs(rs.getInt(22));
			d.setSuit2_cloth_mtrs(rs.getDouble(23));
			d.setSuit2_cloth_pcs(rs.getInt(24));
			d.setSuit_cloth_qtn(rs.getDouble(25));
			d.setSuit_cloth_remarks(rs.getDouble(26));
			
			d.setBlaizer1_cloth_mtrs(rs.getDouble(27));
			d.setBlaizer1_cloth_pcs(rs.getInt(28));
			d.setBlaizer2_cloth_mtrs(rs.getDouble(29));
			d.setBlaizer2_cloth_pcs(rs.getInt(30));
			d.setBlaizer_cloth_qtn(rs.getDouble(31));
			d.setBlaizer_cloth_remarks(rs.getDouble(32));
			
			d.setSilk_saree_pcs(rs.getInt(33));
			d.setSilk_saree_qtn(rs.getDouble(34));
			d.setSilk_saree_remark(rs.getDouble(35));
			
			d.setCrape_saree_pcs(rs.getInt(36));
			d.setCrape_saree_qtn(rs.getDouble(37));
			d.setCrape_saree_remark(rs.getDouble(38));
			
			d.setSynthetic_saree_pcs(rs.getInt(39));
			d.setSynthetic_saree_qtn(rs.getDouble(40));
			d.setSynthetic_saree_remark(rs.getDouble(41));
			
			d.setNeck_tie_pcs(rs.getInt(42));
			d.setNeck_tie_qtn(rs.getDouble(43));
			d.setNeck_tie_remark(rs.getDouble(44));
			
			d.setScarves_pcs(rs.getInt(45));
			d.setScarves_qtn(rs.getDouble(46));
			d.setScarves_remark(rs.getDouble(47));
			
			
			roapdf.add(d);
			System.out.println("Successfully added in Receipt Pdf..........data.");
		}
		
		
		
		return roapdf;
	}

}
