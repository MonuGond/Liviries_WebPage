package empLogin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class EmpLoginDao {

	public static boolean validate(String eusername, String epassword) {
		// TODO Auto-generated method stub
		boolean status=false;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","System","tiger1");
			PreparedStatement ps= conn.prepareStatement("select * from empregister where eusername=? and epassword=?");
			ps.setString(1, eusername);
			ps.setString(2, epassword);
			ResultSet rs=ps.executeQuery();
			status=rs.next();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		
		
		return status;
	}

}
