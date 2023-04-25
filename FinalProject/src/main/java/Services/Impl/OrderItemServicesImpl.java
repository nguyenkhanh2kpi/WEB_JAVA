package Services.Impl;
import java.util.List;

import DAO.IOrderItemDAO;
import DAO.Impl.OrderItemDAOImpl;
import Model.OrderItem;
import Services.IOrderItemServices;


public class OrderItemServicesImpl implements IOrderItemServices{
	IOrderItemDAO orderItemDAO = new OrderItemDAOImpl();
	@Override
	public List<OrderItem> findByOrderId(int orderId) {
		return orderItemDAO.findByOrderId(orderId);
	}

	
	
}
