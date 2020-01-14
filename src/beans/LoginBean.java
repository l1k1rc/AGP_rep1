package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class LoginBean {

	private String login;
	private String password;
	private boolean connected = false;

	/*public String verify() {
		String results;
		if (MockCore.exist(login)) {
			if (MockCore.isValid(login, password)) {
				results = "valid";
				connected = true;
			} else {
				results = "invalid";
			}
		} else {
			results = "no-such-user";
		}

		return results;
	}*/
	public String returnAction_second() {
		System.out.println("Redirection");
		
		return "index";
	}
	public LoginBean() {
		password="Password";
		System.out.println("Test constructeur");
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isConnected() {
		return connected;
	}

	public void setConnected(boolean connected) {
		this.connected = connected;
	}

}
