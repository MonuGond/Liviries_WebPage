package sendReceive;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class SenderReceiverDao {
	private Connection conn = null;
	private PreparedStatement ps=null;
	private ResultSet rs=null;
	
	public int locationKolkataAirport(SenderReceiverPozo sr) throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "System", "tiger1");
		String query="insert into senderreceiver values (?,?)";
		ps=conn.prepareStatement(query);
		ps.setString(1, sr.getT_receiver());
		ps.setString(2, sr.getF_sender());
		int rs = ps.executeUpdate();
		return rs;
		
	}
//....................................PDF DATA.................................................................
	public ArrayList<SenderReceiverPozo> getpdfdataFromSenderReceiver(String t_receiver) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "System", "tiger1");
		String querypdf="select * from  senderreceiver where t_receiver='"+t_receiver+"'";
		ps=conn.prepareStatement(querypdf);		
		rs=ps.executeQuery();
		ArrayList<SenderReceiverPozo>srpdf=new ArrayList<>();
		while(rs.next()) {
			SenderReceiverPozo d=new SenderReceiverPozo();
			d.setT_receiver(rs.getString(1));
			d.setF_sender(rs.getString(2));
			srpdf.add(d);
		}
		return srpdf;
	}

}
