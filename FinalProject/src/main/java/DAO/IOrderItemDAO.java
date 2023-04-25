package DAO;

import java.util.List;

import Model.OrderItem;

public interface IOrderItemDAO {
	List<OrderItem> findByOrderId(int orderId);
}
