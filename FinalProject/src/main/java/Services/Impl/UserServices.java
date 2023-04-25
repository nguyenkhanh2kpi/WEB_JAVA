package Services.Impl;

import java.util.List;

import DAO.IUserDAO;
import DAO.Impl.UserDAOImpl;
import Model.RoleUser;
import Model.User;
import Services.IUserServices;

public class UserServices implements IUserServices{
	IUserDAO user = new UserDAOImpl();
	
	@Override
	public User findById(int id) {
		return user.findById(id);
	}
	@Override
	public List<User> findAll(){
		return user.findAll();
	}
	@Override
	public List<User> findAllUserByRoleId(int idRole){
		return user.findUserByIdRole(idRole);
	}
	
	@Override
	public void blockUser(int id){
		user.blockUser(id);
	}
	
	@Override
	public void unblockUser(int id){
		user.unblockUser(id);
	}
	@Override
	public void editUser(User newUser) {
		user.editUser(newUser);
	}
	@Override
	public void updateUser(User newUser) {
		user.updateUser(newUser);
	}
	@Override
	public List<RoleUser> findAllRole(){
		return user.findAllIdRole();
	}
	@Override
	public void updateRole(int idRole, int id) {
		user.updateRole(idRole, id);
	}
	@Override
	public void insertUser(User _user) {
		user.insertUser(_user);
	}
	@Override
	public User loginUser(String account, String password) {
		return user.loginUser(account, password);
	}
}
