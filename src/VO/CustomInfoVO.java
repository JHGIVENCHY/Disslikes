package VO;

public class CustomInfoVO { //유저 정보를 담는 세션.

	private String SEmail;
	private String password;
	
	public String getEmail() {
		return SEmail;
	}
	public void setEmail(String SEmail) {
		this.SEmail = SEmail;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
