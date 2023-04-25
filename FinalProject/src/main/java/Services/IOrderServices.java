package Services;

import java.util.List;

import Model.Order;

public interface IOrderServices  {
	List<Order> findByStore(int storeId); 
	List<Order> findByStoreWithStatus(int idStore, String status); 
	Order findById(int orderId);
	void changOrderStatus(int orderId, String status);
	void Delivered(int orderId,String status);
}