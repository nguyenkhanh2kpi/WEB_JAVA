package DAO;

import java.util.List;

import Model.Income;

public interface IIncomeDAO {
	List<Income> IncomeUserId(int userId);
}
