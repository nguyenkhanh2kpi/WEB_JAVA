package DAO.Impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Connection.Connection;
import DAO.IOrderDAO;
import Model.Order;

public class OrderDAOImpl extends Connection implements IOrderDAO {

	@Override
	public List<Order> findByStore(int idStore) {
		List<Order> orders = new ArrayList<Order>();
		String sql = "select * from _Order where StoreId=" + idStore;
		try {
			java.sql.Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Order order = new Order();
				order.setId(rs.getInt("id"));
				order.setUserId(rs.getInt("userId"));
				order.setDeliveryId(rs.getInt("deliveryId"));
				order.setStoreId(rs.getInt("StoreId"));
				order.setCommissionId(rs.getInt("commissionId"));
				order.setAddress(rs.getString("address"));
				order.setPhone(rs.getString("phone"));
				order.setStatus(rs.getString("status"));
				order.setPaidBefore(rs.getBoolean("isPaidBefore"));
				order.setAmountFromUser(rs.getInt("amountFromUser"));
				order.setAmountFromStore(rs.getInt("amountFromStore"));
				order.setAmountToGD(rs.getInt("amountToGD"));
				order.setAmountToStore(rs.getInt("amountToStore"));
				order.setCreatedAt(rs.getDate("createdAt"));
				order.setUpdatedAt(rs.getDate("updatedAt"));
				orders.add(order);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return orders;
	}
	@Override
	public List<Order> findByStoreWithStatus(int idStore, String status) {
		List<Order> orders = new ArrayList<Order>();
		
		String sql = "execute sp_SelectOrder "+idStore+",'" +status+"'";
//		if(status.toString().toLowerCase().trim()=="all") {
//			sql="select * from _Order where StoreId=" + idStore;
//		}
		try {
			java.sql.Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Order order = new Order();
				order.setId(rs.getInt("id"));
				order.setUserId(rs.getInt("userId"));
				order.setDeliveryId(rs.getInt("deliveryId"));
				order.setStoreId(rs.getInt("StoreId"));
				order.setCommissionId(rs.getInt("commissionId"));
				order.setAddress(rs.getString("address"));
				order.setPhone(rs.getString("phone"));
				order.setStatus(rs.getString("status"));
				order.setPaidBefore(rs.getBoolean("isPaidBefore"));
				order.setAmountFromUser(rs.getInt("amountFromUser"));
				order.setAmountFromStore(rs.getInt("amountFromStore"));
				order.setAmountToGD(rs.getInt("amountToGD"));
				order.setAmountToStore(rs.getInt("amountToStore"));
				order.setCreatedAt(rs.getDate("createdAt"));
				order.setUpdatedAt(rs.getDate("updatedAt"));
				orders.add(order);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return orders;
	}

	@Override
	public Order findById(int orderId) {
		Order order = new Order();
		String sql = "select * from _Order where id=" + orderId;
		try {
			java.sql.Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				order.setId(rs.getInt("id"));
				order.setUserId(rs.getInt("userId"));
				order.setDeliveryId(rs.getInt("deliveryId"));
				order.setStoreId(rs.getInt("StoreId"));
				order.setCommissionId(rs.getInt("commissionId"));
				order.setAddress(rs.getString("address"));
				order.setPhone(rs.getString("phone"));
				order.setStatus(rs.getString("status"));
				order.setPaidBefore(rs.getBoolean("isPaidBefore"));
				order.setAmountFromUser(rs.getInt("amountFromUser"));
				order.setAmountFromStore(rs.getInt("amountFromStore"));
				order.setAmountToGD(rs.getInt("amountToGD"));
				order.setAmountToStore(rs.getInt("amountToStore"));
				order.setCreatedAt(rs.getDate("createdAt"));
				order.setUpdatedAt(rs.getDate("updatedAt"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return order;
	}
	@Override
	public void ChangeStatus(int orderId, String status) {
		String sql= "UPDATE _Order set status=? WHERE id  = ?;";
		try {
			java.sql.Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,status);
			ps.setInt(2, orderId);
			ps.executeUpdate();
			} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void Delivered(int orderId, String status) {
		String sql = "execute sp_delivered ?, ?";
		try {
			java.sql.Connection conn = super.getConnection(); 
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, orderId);
			ps.setString(2, status);
			ps.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		OrderDAOImpl d = new OrderDAOImpl();
		System.out.println(d.findByStore(1));
	}
}
