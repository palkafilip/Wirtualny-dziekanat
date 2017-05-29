package virtualDeanery.model;

public class User {
	private int niu;
	private String firstname;
	private String lastname;
	private String pesel;
	private String address;
	private String city;
	private String post_code;
	private String email;
	private String phone;
	private String account_type;

	@Override
	public boolean equals(Object obj) {
		User u = (User) obj;
		if (this.firstname.equals(u.getFirstname()) && this.account_type.equals(u.getAccount_type())
				&& this.address.equals(u.getAddress()) && this.city.equals(u.getCity())
				&& this.email.equals(u.getEmail()) && this.lastname.equals(u.getLastname())
				&& this.pesel.equals(u.getPesel()) && this.phone.equals(u.getPhone())
				&& this.post_code.equals(u.getPost_code())) return true;
		else return false;
	}

	public int getId() {
		return niu;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPesel() {
		return pesel;
	}

	public void setPesel(String pesel) {
		this.pesel = pesel;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPost_code() {
		return post_code;
	}

	public void setPost_code(String post_code) {
		this.post_code = post_code;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAccount_type() {
		return account_type;
	}

	public void setAccount_type(String account_type) {
		this.account_type = account_type;
	}

	@Override
	public String toString() {
		return "User [niu=" + niu + ", firstname=" + firstname + ", lastname=" + lastname + ", pesel=" + pesel
				+ ", address=" + address + ", city=" + city + ", post_code=" + post_code + ", email=" + email
				+ ", phone=" + phone + ", account_type=" + account_type + "]";
	}

}
