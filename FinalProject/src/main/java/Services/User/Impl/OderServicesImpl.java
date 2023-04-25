package Services.User.Impl;

import java.util.List;

import DAO.User.IOderDAO;
import DAO.User.UserDaoImpl.OderDAOImpl;
import Model.Delivery;
import Model.Order;
import Model.OrderItem;
import Services.User.IOderServices;

public class OderServicesImpl implements IOderServices{
	IOderDAO orders = new OderDAOImpl();
	@Override
	public void insert(Order order) {
		// TODO Auto-generated method stub
		orders.insert(order);
		return;
	}

	@Override
	public List<Order> getAllOrderByUser(int userId) {
		// TODO Auto-generated method stub
		return orders.getAllOrderByUser(userId);
	}

	@Override
	public void insertOrderItem(OrderItem oderItem) {
		// TODO Auto-generated method stub
		orders.insertOrderItem(oderItem);
		return;
		
	}

	@Override
	public List<OrderItem> getAllOrderItemByOrderId(int orderId) {
		// TODO Auto-generated method stub
		return orders.getAllOrderItemByOrderId(orderId);
	}

	@Override
	public Delivery getDelivery(int id) {
		// TODO Auto-generated method stub
		return orders.getDelivery(id);
	}

	@Override
	public Order getOrderById(int userId, int storeId) {
		// TODO Auto-generated method stub
		return orders.getOrderById(userId, storeId);
	}

}
