package Services;

import java.util.List;

import Model.RoleUser;
import Model.User;

public interface IUserServices {

	List<User> findAll();

	void blockUser(int id);

	void unblockUser(int id);

	User findById(int id);

	void updateUser(User newUser);

	void editUser(User newUser);

	List<RoleUser> findAllRole();

	void updateRole(int idRole, int id);

	void insertUser(User user);

	User loginUser(String account, String password);

	List<User> findAllUserByRoleId(int idRole);

}
