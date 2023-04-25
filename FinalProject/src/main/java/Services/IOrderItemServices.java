package Services;

import java.util.List;

import Model.OrderItem;

public interface IOrderItemServices {
	List<OrderItem> findByOrderId(int orderId);

}
