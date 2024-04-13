package otherAirportLocation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class LocationOtherAirport1Dao {
	private Connection conn = null;
	private PreparedStatement ps=null;
	private ResultSet result=null;
	
	public int LocationOtherAirport1(LocationOtherAirport1Pozo p) throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "System", "tiger1");
		
		String queryotherairport="insert into location_Other_Airport1 values( ?, ?,)";
		ps = conn.prepareStatement(queryotherairport);
		//ps.setInt(1, p.getLocationOtherAirportid());
		ps.setString(1, p.getAirportname());
		ps.setString(2, p.getAirportaddress());
		int rs=ps.executeUpdate();
		return rs;
	}
		
	
		// .............Yha pe data ko pdf me send kiya jaa rha hai.............
	public ArrayList<LocationOtherAirport1Pozo> getPdfDataFromDao( String airportname ) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "System", "tiger1");
		//String querypdf="select * from location_Other_Airport1 where airportname="+airportname;
		String querypdf="select * from location_Other_Airport1 where airportname='"+airportname+"'";
		ps = conn.prepareStatement(querypdf);
		result=ps.executeQuery();
		ArrayList<LocationOtherAirport1Pozo>loapdf = new ArrayList<>();
		while(result.next()) {
			LocationOtherAirport1Pozo d = new LocationOtherAirport1Pozo();
			d.setAirportname(result.getString(1));
			d.setAirportaddress(result.getString(2));
			loapdf.add(d);
			System.out.println("Pdf Dao Run Successfully...........");
		}
		return loapdf;
	}

}
