package DAO.Impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Connection.Connection;
import DAO.ITransactionDAO;
import Model.Store;
import Model.Trasaction;

public class TransactionDAOImpl extends Connection implements ITransactionDAO {

	@Override
	public List<Trasaction> findAll() {
		List<Trasaction> transactions = new ArrayList<Trasaction>();
		String sql = "select * from _Transaction";
		try {
			java.sql.Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Trasaction transaction = new Trasaction();
				transaction.setId(rs.getInt("id"));
				transaction.setUserId(rs.getInt("userId"));
				transaction.setStoreId(rs.getInt("StoreId"));
				transaction.setUp(rs.getBoolean("isUp"));
				transaction.setAmount(rs.getInt("amount"));
				transaction.setCreatedAt(rs.getDate("createdAt"));
				transaction.setUpdatedAt(rs.getDate("updatedAt"));
				transactions.add(transaction);
			}} catch (Exception e) {
				e.printStackTrace();}
		return transactions;
	}

	@Override
	public List<Trasaction> findByUserId(int userId) {
		List<Trasaction> transactions = new ArrayList<Trasaction>();
		String sql = "select * from _Transaction where userId="+userId;
		try {
			java.sql.Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Trasaction transaction = new Trasaction();
				transaction.setId(rs.getInt("id"));
				transaction.setUserId(rs.getInt("userId"));
				transaction.setStoreId(rs.getInt("storeId"));
				transaction.setUp(rs.getBoolean("isUp"));
				transaction.setAmount(rs.getInt("amount"));
				transaction.setCreatedAt(rs.getDate("createdAt"));
				transaction.setUpdatedAt(rs.getDate("updatedAt"));
				transactions.add(transaction);
			}} catch (Exception e) {
				e.printStackTrace();}
		return transactions;
	}
	
	@Override
	public void CreateTransaction(Trasaction transaction) {
		String sql="insert into _Transaction(userId,StoreId,isUp,amount) values (?,?,?,?)";
		try {
			java.sql.Connection conn = super.getConnection(); 
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, transaction.getUserId());
			ps.setInt(2, transaction.getStoreId());
			ps.setBoolean(3, transaction.isUp());
			ps.setFloat(4, transaction.getAmount());
			ps.execute();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		TransactionDAOImpl d = new TransactionDAOImpl();
		List<Trasaction> transactions = new ArrayList<Trasaction>();
		transactions = d.findAll();
		for (Trasaction trasaction : transactions) {
			System.out.println(trasaction.isUp());
		}
		System.out.println(d.findAll());

	}



}
