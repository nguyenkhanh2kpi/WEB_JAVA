package Services.Impl;

import java.util.List;

import DAO.IOrderDAO;
import DAO.Impl.OrderDAOImpl;
import Model.Order;
import Services.IOrderServices;

public class OrderServicesImpl implements IOrderServices{
	IOrderDAO orderDAO = new OrderDAOImpl();
	@Override
	public List<Order> findByStore(int storeId) {
		return orderDAO.findByStore(storeId);
	}
	@Override
	public List<Order> findByStoreWithStatus(int idStore, String status) {
		// TODO Auto-generated method stub
		return orderDAO.findByStoreWithStatus(idStore, status);
	}
	@Override
	public Order findById(int orderId) {
		// TODO Auto-generated method stub
		return orderDAO.findById(orderId);
	}
	@Override
	public void changOrderStatus(int orderId, String status) {
		orderDAO.ChangeStatus(orderId, status);
		
	}
	@Override
	public void Delivered(int orderId, String status) {
		orderDAO.Delivered(orderId, status);
		
	}
}
