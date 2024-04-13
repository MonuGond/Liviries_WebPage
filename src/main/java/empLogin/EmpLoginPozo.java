package empLogin;

public class EmpLoginPozo {
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
	public EmpLoginPozo(String eusername, String epassword) {
		super();
		this.eusername = eusername;
		this.epassword = epassword;
	}
	public EmpLoginPozo() {
		super();
	}

}
