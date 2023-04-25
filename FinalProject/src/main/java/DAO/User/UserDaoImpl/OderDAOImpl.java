package DAO.User.UserDaoImpl;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Connection.Connection;
import DAO.User.IOderDAO;
import Model.Delivery;
import Model.Order;
import Model.OrderItem;
import Services.IProductServices;
import Services.Impl.ProductServicesImpl;

public class OderDAOImpl extends Connection implements IOderDAO{
	IProductServices productServices = new ProductServicesImpl();
	@Override
	public void insert(Order order) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO _Order (userId, deliveryId, StoreId, address, phone, status,isPaidBefore,amountToStore) "
				+ "VALUES (?,?,?,?,?,?,?,?)";
		try {
			java.sql.Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, order.getUserId());
			ps.setInt(2, order.getDeliveryId());
			ps.setInt(3, order.getStoreId());
			ps.setString(4, order.getAddress());
			ps.setString(5, order.getPhone());
			ps.setString(6, order.getStatus());
			ps.setBoolean(7, false);
			ps.setFloat(8, order.getAmountToStore());
			ps.executeUpdate();
			} 
		catch (Exception e) {
			e.printStackTrace();}
		
	}

	@Override
	public List<Order> getAllOrderByUser(int userId) {
		// TODO Auto-generated method stub
		List<Order> orders = new ArrayList<Order>();
		String sql = "SELECT * from _Order Where userId=? and (status = 'wait_confirmation' or status = 'wait_goods' or status = 'delivering')";
		try {
			java.sql.Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, userId);
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
	public void insertOrderItem(OrderItem orderItem) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO OrderItem (productId, orderId, count) "
				+ "VALUES (?,?,?)";
		try {
			java.sql.Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, orderItem.getProductId());
			ps.setInt(2, orderItem.getOrderId());
			ps.setInt(3, orderItem.getCount());
			ps.executeUpdate();
			} 
		catch (Exception e) {
			e.printStackTrace();}
		
	}
	@Override
	public Delivery getDelivery(int id) {
		// TODO Auto-generated method stub
		String sql = "SELECT * from Delivery Where id=?";
		try {
			java.sql.Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Delivery delivery = new Delivery();
				delivery.setId(rs.getInt("id"));
				delivery.setPrice(rs.getInt("price"));
				return delivery;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Order getOrderById(int userId, int StoreId) {
		// TODO Auto-generated method stub
		String sql = "SELECT * from _Order Where userId=? and StoreId=? and status = 'wait_confirmation' ORDER BY id DESC";
		try {
			java.sql.Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, userId);
			ps.setInt(2, StoreId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Order order = new Order();
				order.setId(rs.getInt("id"));
				return order;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<OrderItem> getAllOrderItemByOrderId(int orderId) {
		// TODO Auto-generated method stub
		List<OrderItem> orderItems = new ArrayList<OrderItem>();
		String sql = "SELECT * from OrderItem Where orderId=?";
		try {
			java.sql.Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, orderId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				OrderItem orderItem = new OrderItem();
				orderItem.setId(rs.getInt("id"));
				orderItem.setProductId(rs.getInt("productId"));
				orderItem.setOrderId(rs.getInt("orderId"));
				orderItem.setCount(rs.getInt("count"));
				orderItem.setProduct(productServices.findById(orderItem.getProductId()));
				orderItems.add(orderItem);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return orderItems;
	}

}
