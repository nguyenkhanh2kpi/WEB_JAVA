package Services.Impl;

import java.util.List;

import DAO.ITransactionDAO;
import DAO.Impl.TransactionDAOImpl;
import Model.Trasaction;
import Services.ITransactionServices;

public class TransactionServicesImpl implements ITransactionServices {
	ITransactionDAO transactionDAO = new TransactionDAOImpl();
	@Override
	public List<Trasaction> findAll() {
		return transactionDAO.findAll();
	}
	@Override
	public List<Trasaction> findByUserId(int userId) {
		// TODO Auto-generated method stub
		return transactionDAO.findByUserId(userId);
	}
	@Override
	public void CreateTransaction(Trasaction transaction) {
		transactionDAO.CreateTransaction(transaction);
		
	}
}
