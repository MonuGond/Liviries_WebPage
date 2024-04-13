package officeRegistration;

public class OfficeRegistrationPozo {
	private String Email;
	private String Password;
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public OfficeRegistrationPozo(String email, String password) {
		super();
		Email = email;
		Password = password;
	}
	public OfficeRegistrationPozo() {
		super();
	}
	
	

}
