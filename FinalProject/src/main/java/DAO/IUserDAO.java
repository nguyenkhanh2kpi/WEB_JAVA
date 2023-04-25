package DAO;

import java.util.List;

import Model.RoleUser;
import Model.User;

public interface IUserDAO {
	public User findById(int id);

	List<User> findAll();

	void blockUser(int id);

	void unblockUser(int id);

	void editUser(User newUser);

	void updateUser(User user);

	List<RoleUser> findAllIdRole();

	void updateRole(int idRole, int id);

	void insertUser(User user);

	User loginUser(String account, String password);

	List<User> findUserByIdRole(int idRole);

	User findByUserName(String username);

}
