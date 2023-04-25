package DAO;

import java.util.List;

import Model.Order;

public interface IOrderDAO {
	List<Order> findByStore(int idStore); 
	List<Order> findByStoreWithStatus(int idStore, String status); 
	Order findById(int orderId);
	void ChangeStatus(int orderId, String status);
	void Delivered(int orderId,String status);
}
