package Services.User.Impl;

import java.util.List;

import DAO.User.IUserDao;
import DAO.User.UserDaoImpl.UserDaoImpl;
import Model.Location;
import Model.User;
import Services.User.IUserServices;


public class UserServicesImpl implements IUserServices{
	IUserDao userDao = new UserDaoImpl();
	@Override
	public User login(String slug, String password) {
		User user = this.findByUserName(slug);
		if (user != null && password.equals(user.getPassword())) {
			return user;
		}
		return null;
	}
	@Override
	public User findByUserName(String slug) {
		// TODO Auto-generated method stub
		return userDao.findByUserName(slug);
	}
	@Override
	public boolean register(String full_name, String slug, String id_card, String phone, String password) {
		if (userDao.checkExistSlug(slug))
		{
			return false;
		}
		if(userDao.checkExistIdCard(id_card))
		{
			return false;
		}
		if(userDao.checkExistPhone(phone))
		{
			return false;
		}
		return true;
	}
	@Override
	public void insert(User user) {
		// TODO Auto-generated method stub
		userDao.insert(user);
		return ;
		
	}
	@Override
	public boolean checkExistSlug(String slug) {
		// TODO Auto-generated method stub
		return userDao.checkExistSlug(slug);
	}
	@Override
	public boolean checkExistPhone(String phone) {
		// TODO Auto-generated method stub
		return userDao.checkExistPhone(phone);
	}
	@Override
	public boolean checkExistIdCard(String id_card) {
		// TODO Auto-generated method stub
		return userDao.checkExistIdCard(id_card);
	}
	@Override
	public void updatepPass(String password, String full_name) {
		// TODO Auto-generated method stub
		userDao.updatepPass(password, full_name);
		return;
		
	}
	@Override
	public void insertLocation(String slug, String diaChi) {
		// TODO Auto-generated method stub
		userDao.insertLocation(slug, diaChi);
		return;
		
	}
	@Override
	public void updateInfor(String full_name, String id_card, String phone, String avatar, String curr_name) {
		// TODO Auto-generated method stub
		userDao.updateInfor(full_name, id_card, phone, avatar, curr_name);
		return;
		
	}
	@Override
	public List<Location> findAllLocation() {
		// TODO Auto-generated method stub
		return userDao.findAllLocation();
	}

}
