package Services;

import java.util.List;

import Model.Trasaction;

public interface ITransactionServices {
	List<Trasaction> findAll();
	List<Trasaction> findByUserId(int userId);
	void CreateTransaction(Trasaction transaction);
}
