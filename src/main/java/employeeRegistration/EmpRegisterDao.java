package employeeRegistration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmpRegisterDao {
	private Connection conn=null;
	private PreparedStatement ps=null;
	ResultSet rs=null;
	public int EmpRegisterDao(EmpRegisterPozo p) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","System","tiger1");
		String query="insert into empregister(eusername, epassword)values(?,?)";
		ps=conn.prepareStatement(query);
		ps.setString(1, p.getEusername());
		ps.setString(2, p.getEpassword());
		int rs=ps.executeUpdate();
		return rs;
	}
	
	

}
