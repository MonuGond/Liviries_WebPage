package officeRegistration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OfficeRegistrationDao {
	private Connection conn=null;
	private PreparedStatement ps=null;
	ResultSet rs=null;

	public int OfficeRegistrationDao(OfficeRegistrationPozo p) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		System.out.println("welcome to registration page....");
		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","System","tiger1");
		String query="insert into OfficeRegisterAAI(Email,Password)values(?,?)";
		ps=conn.prepareStatement(query);
		ps.setString(1, p.getEmail());
		ps.setString(2, p.getPassword());
		int rs=ps.executeUpdate();
		return rs;
	}

}
