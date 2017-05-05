package virtualDeanery.model;

public class User_Account {
	/* przysloniecie bo testy zle porownoja */
	@Override
	public boolean equals(Object obj) {
		User_Account ua = (User_Account) obj;
		if (ua.getNiu() == this.niu && ua.getPassword().equals(this.password))
			return true;
		else return false;
	}

	private int niu;
	private String password;

	public int getNiu() {
		return niu;
	}

	public void setNiu(int niu) {
		this.niu = niu;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User_Account [niu=" + niu + ", password=" + password + "]";
	}

}
