package Services.User;

import java.util.List;

import Model.Delivery;
import Model.Order;
import Model.OrderItem;

public interface IOderServices {
	void insert(Order order);
	List<Order> getAllOrderByUser(int userId);
	Order getOrderById(int userId,int storeId);
	void insertOrderItem(OrderItem oderItem);
	List<OrderItem> getAllOrderItemByOrderId(int orderId);
	Delivery getDelivery(int id);
}
