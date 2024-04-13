package packingVoucher;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class PackingVoucher2Dao {
	private Connection conn = null;
	private PreparedStatement ps = null;
	ResultSet rs = null;

	public int PackingVoucher1Servlet(PackingVoucher1Pozo p, PackingVoucher2Pozo p2)
			throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "System", "tiger1");

		String query = "insert into PackingVoucher1 values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,"
				+ "?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		ps = conn.prepareStatement(query);
		// ps.setString(1,p.getSerialNo());packingvoucher1_sequence.NEXTVAL,
		ps.setString(1, p.getN_a_consignee());
		ps.setString(2, p.getOurreference());

		// ps.setInt(3, p.getIssuevoucherno());
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

		/*
		 * String query =
		 * "insert into PackingVoucher1 values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?," +
		 * "?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"; ps =
		 * conn.prepareStatement(query); //
		 * ps.setString(1,p.getSerialNo());packingvoucher1_sequence.NEXTVAL,
		 * ps.setString(1, p.getN_a_consignee()); ps.setString(2, p.getOurreference());
		 * ps.setInt(3, p.getIssuevoucherno()); java.sql.Date sqldate = new
		 * java.sql.Date(p.getPdate().getTime());
		 * System.out.println("sql date in Dao .................." + sqldate);
		 * ps.setDate(4, sqldate);
		 * 
		 * ps.setDouble(5, p.getShirting1_cloth_mtrs()); ps.setDouble(6,
		 * p.getShirting2_cloth_mtrs()); ps.setInt(7, p.getShirting1_cloth_pcs());
		 * ps.setInt(8, p.getShirting2_cloth_pcs()); ps.setDouble(9,
		 * p.getShirting_qtn());// qty added ps.setDouble(10,
		 * p.getShirting_cloth_remarks());
		 * 
		 * ps.setDouble(11, p.getPaint1_cloth_mtrs()); ps.setDouble(12,
		 * p.getPaint2_cloth_mtrs()); ps.setInt(13, p.getPaint1_cloth_pcs());
		 * ps.setInt(14, p.getPaint2_cloth_pcs()); ps.setDouble(15, p.getPaint_qtn());//
		 * qty added ps.setDouble(16, p.getPaint_cloth_remarks());
		 * 
		 * ps.setDouble(17, p.getSuit1_cloth_mtrs()); ps.setDouble(18,
		 * p.getSuit2_cloth_mtrs()); ps.setInt(19, p.getSuit1_cloth_pcs());
		 * ps.setInt(20, p.getSuit2_cloth_pcs()); ps.setDouble(21, p.getSuit_qtn());//
		 * qty added ps.setDouble(22, p.getSuit_cloth_remarks());
		 * 
		 * ps.setDouble(23, p.getBlaizer1_cloth_mtrs()); ps.setDouble(24,
		 * p.getBlaizer2_cloth_mtrs()); ps.setInt(25, p.getBlaizer1_cloth_pcs());
		 * ps.setInt(26, p.getBlaizer2_cloth_pcs()); ps.setDouble(27,
		 * p.getBlaizer_qtn());// qty added ps.setDouble(28,
		 * p.getBlaizer_cloth_remarks());
		 * 
		 * ps.setInt(29, p.getSilk_saree_pcs()); ps.setDouble(30,
		 * p.getSilk_saree_qtn());// qty added ps.setDouble(31,
		 * p.getSilk_saree_remark());
		 * 
		 * ps.setInt(32, p.getCrape_saree_pcs()); ps.setDouble(33,
		 * p.getCrape_saree_qtn());// qty added ps.setDouble(34,
		 * p.getCrape_saree_remark());
		 * 
		 * ps.setInt(35, p.getSynthetic_saree_pcs()); ps.setDouble(36,
		 * p.getSynthetic_saree_qtn());// qty added ps.setDouble(37,
		 * p.getSynthetic_saree_remark());
		 * 
		 * ps.setInt(38, p.getNeck_tie_pcs()); ps.setDouble(39, p.getNeck_tie_qtn());//
		 * qty added ps.setDouble(40, p.getNeck_tie_remark());
		 * 
		 * ps.setInt(41, p.getScarves_pcs()); ps.setDouble(42, p.getScarves_qtn());//
		 * qty added ps.setDouble(43, p.getScarves_remark());
		 */

		int rs = ps.executeUpdate();
		if (rs != 0) {
			rs = 0;

			String query1 = "insert into PackingVoucher2 values(?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?,"
					+ "?,?,?,?,?," + "?,?,?,?,?," + "?,?,?,?,?," + "?,?,?,?,?," + "?,?,?,?,?," + "?,?,?,?,?)";
			PreparedStatement ps1 = conn.prepareStatement(query1);

			// ps1.setInt(1, p2.getIssuevoucherno());// serialNo
			ps1.setString(1, p2.getIssuevoucherno());

			ps1.setInt(2, p2.getH1_32_size());
			ps1.setInt(3, p2.getP1_32_size());
			ps1.setInt(4, p2.getF1_32_size());
			ps1.setInt(5, p2.getLc1_32_size());
			ps1.setDouble(6, p2.getRemarks_32_size());

			ps1.setInt(7, p2.getH2_34_size());
			ps1.setInt(8, p2.getP2_34_size());
			ps1.setInt(9, p2.getF2_34_size());
			ps1.setInt(10, p2.getLc2_34_size());
			ps1.setDouble(11, p2.getRemarks_34_size());

			ps1.setInt(12, p2.getH3_36_size());
			ps1.setInt(13, p2.getP3_36_size());
			ps1.setInt(14, p2.getF3_36_size());
			ps1.setInt(15, p2.getLc3_36_size());
			ps1.setDouble(16, p2.getRemarks_36_size());

			ps1.setInt(17, p2.getH4_38_size());
			ps1.setInt(18, p2.getP4_38_size());
			ps1.setInt(19, p2.getF4_38_size());
			ps1.setInt(20, p2.getLc4_38_size());
			ps1.setDouble(21, p2.getRemarks_38_size());

			ps1.setInt(22, p2.getH5_40_size());
			ps1.setInt(23, p2.getP5_40_size());
			ps1.setInt(24, p2.getF5_40_size());
			ps1.setInt(25, p2.getLc5_40_size());
			ps1.setDouble(26, p2.getRemarks_40_size());

			ps1.setInt(27, p2.getH6_42_size());
			ps1.setInt(28, p2.getP6_42_size());
			ps1.setInt(29, p2.getF6_42_size());
			ps1.setInt(30, p2.getLc6_42_size());
			ps1.setDouble(31, p2.getRemarks_42_size());

			ps1.setInt(32, p2.getH7_44_size());
			ps1.setInt(33, p2.getP7_44_size());
			ps1.setInt(34, p2.getF7_44_size());
			ps1.setInt(35, p2.getLc7_44_size());
			ps1.setDouble(36, p2.getRemarks_44_size());

			ps1.setInt(37, p2.getH8_46_size());
			ps1.setInt(38, p2.getP8_46_size());
			ps1.setInt(39, p2.getF8_46_size());
			ps1.setInt(40, p2.getLc8_46_size());
			ps1.setDouble(41, p2.getRemarks_46_size());

			ps1.setInt(42, p2.getH9_48_size());
			ps1.setInt(43, p2.getP9_48_size());
			ps1.setInt(44, p2.getF9_48_size());
			ps1.setInt(45, p2.getLc9_48_size());
			ps1.setDouble(46, p2.getRemarks_48_size());

			ps1.setDouble(47, p2.getTotal_h_s_g_c_qtny());
			ps1.setDouble(48, p2.getTotal_p_o_qtny());
			ps1.setDouble(49, p2.getTotal_f_p_o_qtny());
			ps1.setDouble(50, p2.getTotal_l_c_qtny());
			ps1.setDouble(51, p2.getTotal_remarks());

			rs = ps1.executeUpdate();
		}
		return rs;
	}

	// ..................Yha Pdf Dao Method Ko create Kiya Jaa Rha
	// hai..............................................

	public ArrayList<PackingVoucher1Pozo> getPdfDataFromDao(String issue_number)
			throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub

		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "System", "tiger1");
		String querypdf = "select * from packingvoucher1 where issuevoucherno ='" + issue_number + "'";
		ps = conn.prepareStatement(querypdf);
		rs = ps.executeQuery();
		ArrayList<PackingVoucher1Pozo> packingpdf = new ArrayList<>();
		while (rs.next()) {
			PackingVoucher1Pozo d = new PackingVoucher1Pozo();
			d.setN_a_consignee(rs.getString(1));
			d.setOurreference(rs.getString(2));
			// d.setIssuevoucherno(rs.getInt(3));
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

	// ...............PDF DATA SENT FROM
	public ArrayList<PackingVoucher2Pozo> getDataFromDao2(String issuevoucherno)
			throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "System", "tiger1");

		String querypdf2 = "select * from packingvoucher2 where issuevoucherno = '" + issuevoucherno + "'";
		ps = conn.prepareStatement(querypdf2);
		rs = ps.executeQuery();
		ArrayList<PackingVoucher2Pozo> packing2pdf = new ArrayList<>();
		while (rs.next()) {
			PackingVoucher2Pozo d2 = new PackingVoucher2Pozo();
			d2.setH1_32_size(rs.getInt(2));
			// d2.setP1_32_size(rs.getInt(3));
			// d2.setF1_32_size(rs.getInt(4));
			// d2.setLc1_32_size(rs.getInt(5));
			d2.setH2_34_size(rs.getInt(7));
			d2.setH3_36_size(rs.getInt(12));
			d2.setH4_38_size(rs.getInt(17));
			d2.setH5_40_size(rs.getInt(22));
			d2.setH6_42_size(rs.getInt(27));
			d2.setH7_44_size(rs.getInt(32));
			d2.setH8_46_size(rs.getInt(37));
			d2.setH9_48_size(rs.getInt(42));
			d2.setTotal_h_s_g_c_qtny(rs.getDouble(47));
			// d2.setRemarks_32_size(rs.getDouble(6));

			// .........pull over.........

			d2.setP1_32_size(rs.getInt(3));
			d2.setP2_34_size(rs.getInt(8));
			d2.setP3_36_size(rs.getInt(13));
			d2.setP4_38_size(rs.getInt(18));
			d2.setP5_40_size(rs.getInt(23));
			d2.setP6_42_size(rs.getInt(28));
			d2.setP7_44_size(rs.getInt(33));
			d2.setP8_46_size(rs.getInt(38));
			d2.setP9_48_size(rs.getInt(43));
			d2.setTotal_p_o_qtny(rs.getDouble(48));
			// d2.setRemarks_34_size(rs.getDouble(11));

			// ......... Fire Pull Over ....................

			d2.setF1_32_size(rs.getInt(4));
			d2.setF2_34_size(rs.getInt(9));
			d2.setF3_36_size(rs.getInt(14));
			d2.setF4_38_size(rs.getInt(19));
			d2.setF5_40_size(rs.getInt(24));
			d2.setF6_42_size(rs.getInt(29));
			d2.setF7_44_size(rs.getInt(34));
			d2.setF8_46_size(rs.getInt(39));
			d2.setF9_48_size(rs.getInt(44));
			d2.setTotal_f_p_o_qtny(rs.getDouble(49));
			// d2.setRemarks_36_size(rs.getDouble(16));

			// .......... Ladies Cardigan .........

			d2.setLc1_32_size(rs.getInt(5));
			d2.setLc2_34_size(rs.getInt(10));
			d2.setLc3_36_size(rs.getInt(15));
			d2.setLc4_38_size(rs.getInt(20));
			d2.setLc5_40_size(rs.getInt(25));
			d2.setLc6_42_size(rs.getInt(30));
			d2.setLc7_44_size(rs.getInt(35));
			d2.setLc8_46_size(rs.getInt(40));
			d2.setLc9_48_size(rs.getInt(45));
			d2.setTotal_l_c_qtny(rs.getDouble(50));

			// ....................Total remarks...............
			d2.setRemarks_32_size(rs.getDouble(6));
			d2.setRemarks_34_size(rs.getDouble(11));
			d2.setRemarks_36_size(rs.getDouble(16));
			d2.setRemarks_38_size(rs.getDouble(21));
			d2.setRemarks_40_size(rs.getDouble(26));
			d2.setRemarks_42_size(rs.getDouble(31));
			d2.setRemarks_44_size(rs.getDouble(36));
			d2.setRemarks_46_size(rs.getDouble(41));
			d2.setRemarks_48_size(rs.getDouble(46));
			d2.setTotal_remarks(rs.getDouble(51));
			packing2pdf.add(d2);
		}
		return packing2pdf;
	}

	// ..................................Update Data Query Start
	// Here.................................................

	public int UpdatePackingVoucher1and2(PackingVoucher1Pozo p, PackingVoucher2Pozo p2)
			throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub

		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "System", "tiger1");

		String query = "update PackingVoucher1 set n_a_consignee=?,ourreference=?,pdate=?,"
				+ "shirting1_cloth_mtrs=?,shirting2_cloth_mtrs=?,shirting1_cloth_pcs=?,shirting2_cloth_pcs=?,shirting_cloth_qnt=?,shirting_cloth_remarks=?,"
				+ "paint1_cloth_mtrs=?,paint2_cloth_mtrs=?,paint1_cloth_pcs=?,paint2_cloth_pcs=?,paint_cloth_qtn=?,paint_cloth_remarks=?,"
				+ "suit1_cloth_mtrs=?,suit2_cloth_mtrs=?,suit1_cloth_pcs=?,suit2_cloth_pcs=?,suit_cloth_qtn=?,suit_cloth_remarks=?,"
				+ "blaizer1_cloth_mtrs=?,blaizer2_cloth_mtrs=?,blaizer1_cloth_pcs=?,blaizer2_cloth_pcs=?,blaizer_cloth_qtn=?,blaizer_cloth_remarks=?,"
				+ "silk_saree_pcs=?,silk_saree_qtn=?,silk_saree_remark=?,crape_saree_pcs=?,crape_saree_qtn=?,crape_saree_remark=?,synthetic_saree_pcs=?,"
				+ "synthetic_saree_qtn=?,synthetic_saree_remark=?,neck_tie_pcs=?,neck_tie_qtn=?,neck_tie_remark=?,scarves_pcs=?,"
				+ "scarves_qtn=?,scarves_remark=? where issuevoucherno=?";
		ps = conn.prepareStatement(query);
		// ps.setString(1,p.getSerialNo());packingvoucher1_sequence.NEXTVAL,
		ps.setString(1, p.getN_a_consignee());
		ps.setString(2, p.getOurreference());

		// ps.setInt(3, p.getIssuevoucherno());
		/* ps.setString(3, p.getIssuevoucherno()); */

		java.sql.Date sqldate = new java.sql.Date(p.getPdate().getTime());
		System.out.println("sql date in Dao .................." + sqldate);
		ps.setDate(3, sqldate);

		ps.setDouble(4, p.getShirting1_cloth_mtrs());
		ps.setDouble(5, p.getShirting2_cloth_mtrs());
		ps.setInt(6, p.getShirting1_cloth_pcs());
		ps.setInt(7, p.getShirting2_cloth_pcs());
		ps.setDouble(8, p.getShirting_cloth_qnt());// qty added
		ps.setDouble(9, p.getShirting_cloth_remarks());

		ps.setDouble(10, p.getPaint1_cloth_mtrs());
		ps.setDouble(11, p.getPaint2_cloth_mtrs());
		ps.setInt(12, p.getPaint1_cloth_pcs());
		ps.setInt(13, p.getPaint2_cloth_pcs());
		ps.setDouble(14, p.getPaint_cloth_qtn());// qty added
		ps.setDouble(15, p.getPaint_cloth_remarks());

		ps.setDouble(16, p.getSuit1_cloth_mtrs());
		ps.setDouble(17, p.getSuit2_cloth_mtrs());
		ps.setInt(18, p.getSuit1_cloth_pcs());
		ps.setInt(19, p.getSuit2_cloth_pcs());
		ps.setDouble(20, p.getSuit_cloth_qtn());// qty added
		ps.setDouble(21, p.getSuit_cloth_remarks());

		ps.setDouble(22, p.getBlaizer1_cloth_mtrs());
		ps.setDouble(23, p.getBlaizer2_cloth_mtrs());
		ps.setInt(24, p.getBlaizer1_cloth_pcs());
		ps.setInt(25, p.getBlaizer2_cloth_pcs());
		ps.setDouble(26, p.getBlaizer_cloth_qtn());// qty added
		ps.setDouble(27, p.getBlaizer_cloth_remarks());

		ps.setInt(28, p.getSilk_saree_pcs());
		ps.setDouble(29, p.getSilk_saree_qtn());// qty added
		ps.setDouble(30, p.getSilk_saree_remark());

		ps.setInt(31, p.getCrape_saree_pcs());
		ps.setDouble(32, p.getCrape_saree_qtn());// qty added
		ps.setDouble(33, p.getCrape_saree_remark());

		ps.setInt(34, p.getSynthetic_saree_pcs());
		ps.setDouble(35, p.getSynthetic_saree_qtn());// qty added
		ps.setDouble(36, p.getSynthetic_saree_remark());

		ps.setInt(37, p.getNeck_tie_pcs());
		ps.setDouble(38, p.getNeck_tie_qtn());// qty added
		ps.setDouble(39, p.getNeck_tie_remark());

		ps.setInt(40, p.getScarves_pcs());
		ps.setDouble(41, p.getScarves_qtn());// qty added
		ps.setDouble(42, p.getScarves_remark());
		
		ps.setString(43, p.getIssuevoucherno());

		int rs = ps.executeUpdate();
		if (rs != 0) {
			rs = 0;

	String query1 = "update PackingVoucher2 set h1_32_size=?,p1_32_size=?,f1_32_size=?,lc1_32_size=?,remarks_32_size=?,"
					+ "h2_34_size=?,p2_34_size=?,f2_34_size=?,lc2_34_size=?,remarks_34_size=?,"
					+ "h3_36_size=?,p3_36_size=?,f3_36_size=?,lc3_36_size=?,remarks_36_size=?,"
					+ "h4_38_size=?,p4_38_size=?,f4_38_size=?,lc4_38_size=?,remarks_38_size=?,"
					+ "h5_40_size=?,p5_40_size=?,f5_40_size=?,lc5_40_size=?,remarks_40_size=?,"
					+ "h6_42_size=?,p6_42_size=?,f6_42_size=?,lc6_42_size=?,remarks_42_size=?,"
					+ "h7_44_size=?,p7_44_size=?,f7_44_size=?,lc7_44_size=?,remarks_44_size=?,"
					+ "h8_46_size=?,p8_46_size=?,f8_46_size=?,lc8_46_size=?,remarks_46_size=?,"
					+ "h9_48_size=?,p9_48_size=?,f9_48_size=?,lc9_48_size=?,remarks_48_size=?,"
	+ "total_h_s_g_c_qtny=?,total_p_o_qtny=?,total_f_p_o_qtny=?,total_l_c_qtny=?,total_remarks=? where issuevoucherno=?";
			PreparedStatement ps1 = conn.prepareStatement(query1);

			// ps1.setInt(1, p2.getIssuevoucherno());// serialNo
			/* ps1.setString(1, p2.getIssuevoucherno()); */

			ps1.setInt(1, p2.getH1_32_size());
			ps1.setInt(2, p2.getP1_32_size());
			ps1.setInt(3, p2.getF1_32_size());
			ps1.setInt(4, p2.getLc1_32_size());
			ps1.setDouble(5, p2.getRemarks_32_size());

			ps1.setInt(6, p2.getH2_34_size());
			ps1.setInt(7, p2.getP2_34_size());
			ps1.setInt(8, p2.getF2_34_size());
			ps1.setInt(9, p2.getLc2_34_size());
			ps1.setDouble(10, p2.getRemarks_34_size());

			ps1.setInt(11, p2.getH3_36_size());
			ps1.setInt(12, p2.getP3_36_size());
			ps1.setInt(13, p2.getF3_36_size());
			ps1.setInt(14, p2.getLc3_36_size());
			ps1.setDouble(15, p2.getRemarks_36_size());

			ps1.setInt(16, p2.getH4_38_size());
			ps1.setInt(17, p2.getP4_38_size());
			ps1.setInt(18, p2.getF4_38_size());
			ps1.setInt(19, p2.getLc4_38_size());
			ps1.setDouble(20, p2.getRemarks_38_size());

			ps1.setInt(21, p2.getH5_40_size());
			ps1.setInt(22, p2.getP5_40_size());
			ps1.setInt(23, p2.getF5_40_size());
			ps1.setInt(24, p2.getLc5_40_size());
			ps1.setDouble(25, p2.getRemarks_40_size());

			ps1.setInt(26, p2.getH6_42_size());
			ps1.setInt(27, p2.getP6_42_size());
			ps1.setInt(28, p2.getF6_42_size());
			ps1.setInt(29, p2.getLc6_42_size());
			ps1.setDouble(30, p2.getRemarks_42_size());

			ps1.setInt(31, p2.getH7_44_size());
			ps1.setInt(32, p2.getP7_44_size());
			ps1.setInt(33, p2.getF7_44_size());
			ps1.setInt(34, p2.getLc7_44_size());
			ps1.setDouble(35, p2.getRemarks_44_size());

			ps1.setInt(36, p2.getH8_46_size());
			ps1.setInt(37, p2.getP8_46_size());
			ps1.setInt(38, p2.getF8_46_size());
			ps1.setInt(39, p2.getLc8_46_size());
			ps1.setDouble(40, p2.getRemarks_46_size());

			ps1.setInt(41, p2.getH9_48_size());
			ps1.setInt(42, p2.getP9_48_size());
			ps1.setInt(43, p2.getF9_48_size());
			ps1.setInt(44, p2.getLc9_48_size());
			ps1.setDouble(45, p2.getRemarks_48_size());

			ps1.setDouble(46, p2.getTotal_h_s_g_c_qtny());
			ps1.setDouble(47, p2.getTotal_p_o_qtny());
			ps1.setDouble(48, p2.getTotal_f_p_o_qtny());
			ps1.setDouble(49, p2.getTotal_l_c_qtny());
			ps1.setDouble(50, p2.getTotal_remarks());
			
			ps1.setString(51, p2.getIssuevoucherno());

			rs = ps1.executeUpdate();
		}
		return rs;
	}

}
