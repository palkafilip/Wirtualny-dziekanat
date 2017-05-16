package virtualDeanery.model;

public class Transaction
{
	private int idTransaction;
	private int idFinance;
	private String transferData;
	private String transDate;
	private int status;
	
	
	public int getIdTransaction()
	{
		return idTransaction;
	}
	public void setIdTransaction(int idTransaction)
	{
		this.idTransaction = idTransaction;
	}
	public int getIdFinance()
	{
		return idFinance;
	}
	public void setIdFinance(int idFinance)
	{
		this.idFinance = idFinance;
	}
	public String getTransferData()
	{
		return transferData;
	}
	public void setTransferData(String transferData)
	{
		this.transferData = transferData;
	}
	public String getTransDate()
	{
		return transDate;
	}
	public void setTransDate(String transDate)
	{
		this.transDate = transDate;
	}
	public int getStatus()
	{
		return status;
	}
	public void setStatus(int status)
	{
		this.status = status;
	}
	@Override
	public String toString()
	{
		return "Transaction [idTransaction=" + idTransaction + ", idFinance=" + idFinance + ", transferData="
				+ transferData + ", transDate=" + transDate + ", status=" + status + "]";
	}
	
	
}
