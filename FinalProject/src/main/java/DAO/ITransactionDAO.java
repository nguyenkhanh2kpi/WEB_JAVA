package DAO;

import java.util.List;

import Model.Trasaction;


public interface ITransactionDAO {
	List<Trasaction> findAll();
	List<Trasaction> findByUserId(int userId);
	void CreateTransaction(Trasaction transaction);
}
