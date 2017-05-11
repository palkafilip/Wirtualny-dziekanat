package virtualDeanery.model.repository;

import java.util.List;

import virtualDeanery.model.Transaction;

public interface TransactionRepository
{
	List<Transaction> getTransactionsByIdFinance(int idFinance);
}
