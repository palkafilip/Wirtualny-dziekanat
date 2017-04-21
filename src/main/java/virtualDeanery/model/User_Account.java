package virtualDeanery.model;

public class User_Account
{
	private int niu;
	private String password;

	public int getNiu()
	{
		return niu;
	}

	public void setNiu(int niu)
	{
		this.niu = niu;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	@Override
	public String toString()
	{
		return "User_Account [niu=" + niu + ", password=" + password + "]";
	}
	

}
