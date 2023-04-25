package DAO.Impl;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Connection.Connection;
import DAO.IOrderItemDAO;
import Model.OrderItem;
import Model.Product;
import Services.IProductServices;
import Services.Impl.ProductServicesImpl;

public class OrderItemDAOImpl extends Connection implements IOrderItemDAO {
	IProductServices productServices = new ProductServicesImpl();
	@Override
	public List<OrderItem> findByOrderId(int orderId) {
		List<OrderItem> orderItems = new ArrayList<OrderItem>();
		String sql = "select * from OrderItem where orderId=" + orderId;
		try {
			java.sql.Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				OrderItem orderItem = new OrderItem();
				orderItem.setId(rs.getInt("id"));
				orderItem.setProductId(rs.getInt("productId"));
				orderItem.setOrderId(rs.getInt("orderId"));
				orderItem.setCount(rs.getInt("count"));
				orderItem.setProduct(productServices.findById(orderItem.getProductId()));
				orderItems.add(orderItem);
			}} catch (Exception e) {
				e.printStackTrace();}
		return orderItems;
	}
	
	public static void main(String[] args) {
		OrderItemDAOImpl d= new OrderItemDAOImpl();
		System.out.println(d.findByOrderId(1));
	}

}
