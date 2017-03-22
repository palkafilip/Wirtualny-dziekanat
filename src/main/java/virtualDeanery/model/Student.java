package virtualDeanery.model;

public class Student
{
	private String imie;
	private String nazwisko;
	private String adres;
	private String email;
	private long pesel;
	private int numerTel;
	
	public Student(String imie, String nazwisko, String adres, String email, long pesel, int numerTel)
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
	public long getPesel()
	{
		return pesel;
	}
	public void setPesel(long pesel)
	{
		this.pesel = pesel;
	}
	@Override
	public String toString()
	{
		return "Student [imie=" + imie + ", nazwisko=" + nazwisko + ", adres=" + adres + ", email=" + email + ", pesel="
				+ pesel + ", numerTel=" + numerTel + "]";
	}
	public int getNumerTel()
	{
		return numerTel;
	}
	public void setNumerTel(int numerTel)
	{
		this.numerTel = numerTel;
	}

}

