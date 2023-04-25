package DAO.Impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Connection.Connection;
import DAO.IIncomeDAO;
import Model.Income;
public class IncomeDAOImpl extends Connection implements IIncomeDAO {

	@Override
	public List<Income> IncomeUserId(int userId) {
		List<Income> incomes = new ArrayList<Income>();
		String sql = "execute sp_income_thisyear " + userId;
		try {
			java.sql.Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Income income = new Income();
				income.setStoreId(rs.getInt("StoreUserID"));
				income.setOrderId(rs.getInt("orderId"));
				income.setOrderUserId(rs.getInt("OrderUserID"));
				income.setIncome(rs.getInt("income"));
				income.setDateComplete(rs.getDate("completeDate"));
				incomes.add(income);
			}} catch (Exception e) {
				e.printStackTrace();}
		return incomes;
	}
	
	public static void main(String[] args) {
		IncomeDAOImpl d = new IncomeDAOImpl();
		List<Income> incomes = d.IncomeUserId(1);
		for (Income income : incomes) {
			System.out.println(income.getDateComplete());
		}
		
	}
}
