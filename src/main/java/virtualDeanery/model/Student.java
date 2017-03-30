package virtualDeanery.model;

public class Student
{
	private String imie;
	private String nazwisko;
	private String adres;
	private String email;
	private String pesel;
	private String numerTel;
	
	
	public Student()
	{
		
	}
	public Student(String imie, String nazwisko, String adres, String email, String pesel, String numerTel)
	{
		super();
		this.imie = imie;
		this.nazwisko = nazwisko;
		this.adres = adres;
		this.email = email;
		this.pesel = pesel;
		this.numerTel = numerTel;
	}
	public String getImie()
	{
		return imie;
	}
	public void setImie(String imie)
	{
		this.imie = imie;
	}
	public String getNazwisko()
	{
		return nazwisko;
	}
	public void setNazwisko(String nazwisko)
	{
		this.nazwisko = nazwisko;
	}
	public String getAdres()
	{
		return adres;
	}
	public void setAdres(String adres)
	{
		this.adres = adres;
	}
	public String getEmail()
	{
		return email;
	}
	public void setEmail(String email)
	{
		this.email = email;
	}
	public String getPesel()
	{
		return pesel;
	}
	public void setPesel(String pesel)
	{
		this.pesel = pesel;
	}
	@Override
	public String toString()
	{
		return "Student [imie=" + imie + ", nazwisko=" + nazwisko + ", adres=" + adres + ", email=" + email + ", pesel="
				+ pesel + ", numerTel=" + numerTel + "]";
	}
	public String getNumerTel()
	{
		return numerTel;
	}
	public void setNumerTel(String numerTel)
	{
		this.numerTel = numerTel;
	}

}

