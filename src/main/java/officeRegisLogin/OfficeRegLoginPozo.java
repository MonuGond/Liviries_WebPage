package officeRegisLogin;

public class OfficeRegLoginPozo {
	private String Email,Password;

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

	public OfficeRegLoginPozo(String email, String password) {
		super();
		Email = email;
		Password = password;
	}
	public OfficeRegLoginPozo() {
		super();
	}

}
