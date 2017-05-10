package virtualDeanery.model;

public class User_Finances
{
	
	private int idFinance;
	private int niu;
	private double saldo;
	private String accountNumber;
	
	public int getIdFinance()
	{
		return idFinance;
	}
	public void setIdFinance(int idFinance)
	{
		this.idFinance = idFinance;
	}
	public int getNiu()
	{
		return niu;
	}
	public void setNiu(int niu)
	{
		this.niu = niu;
	}
	public double getSaldo()
	{
		return saldo;
	}
	public void setSaldo(double saldo)
	{
		this.saldo = saldo;
	}
	public String getAccountNumber()
	{
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber)
	{
		this.accountNumber = accountNumber;
	}
	@Override
	public String toString()
	{
		return "User_Finances [idFinance=" + idFinance + ", niu=" + niu + ", saldo=" + saldo + ", accountNumber="
				+ accountNumber + "]";
	}

}
