package Services.Impl;

import DAO.IUserDAO;
import DAO.Impl.UserDAOImpl;
import Model.User;
import Services.LoginVendorServices;

public class LoginVendorServicesImpl implements LoginVendorServices {
	IUserDAO userDAO = new UserDAOImpl();
	@Override
	public User login(String username, String password) {
		User user = userDAO.findByUserName(username);
		if(user !=null && password.equals(user.getPassword())) {
			return user;
		}
		return null;
	}
	

}
