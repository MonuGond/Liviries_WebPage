package officeRegisLogin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class OfficeRegLoginDao {

	public static boolean validate(String email, String password) {
		// TODO Auto-generated method stub
		boolean status= false;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","System","tiger1");
			PreparedStatement ps=conn.prepareStatement("select * from OfficeRegisterAAI where Email=? and Password=?");
			ps.setString(1, email);
			ps.setString(2, password);
			ResultSet rs=ps.executeQuery();
			status=rs.next();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		
		return status;
	}

}
