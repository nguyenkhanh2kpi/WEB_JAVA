package Services.Impl;

import DAO.IUserDAO;
import DAO.Impl.UserDAOImpl;
import Model.User;
import Services.IUserServicesVendor;

public class UserServicesVendorImpl implements IUserServicesVendor {
	IUserDAO userDAO = new UserDAOImpl();
	
	@Override
	public User findById(int userId) {
		return userDAO.findById(userId);
	}
}
