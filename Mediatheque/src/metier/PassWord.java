package metier;

public class PassWord {
	
	private String password;
	
	public PassWord(String pw) {
		// creer ici l'algo pour crypter
		this.password = pw;
	}

//	public String getPassword() {
//		return password;
//	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String decode() {
		return password;
	}

	public boolean verifPW(PassWord pw) {
		boolean reponse = false;
		if (password != null && pw != null) reponse = password.equals(pw.password);
		return reponse;
	}

	// TODO : A enlever - ATTENTION : que pour les tests
	@Override
	public String toString() {
		return "PassWord [password=" + password + "]";
	}
	}
