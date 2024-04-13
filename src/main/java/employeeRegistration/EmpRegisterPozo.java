package employeeRegistration;

public class EmpRegisterPozo {
	private String eusername;
	private String epassword;
	public String getEusername() {
		return eusername;
	}
	public void setEusername(String eusername) {
		this.eusername = eusername;
	}
	public String getEpassword() {
		return epassword;
	}
	public void setEpassword(String epassword) {
		this.epassword = epassword;
	}
	public EmpRegisterPozo(String eusername, String epassword) {
		super();
		this.eusername = eusername;
		this.epassword = epassword;
	}
	public EmpRegisterPozo() {
		super();
	}
	

}
