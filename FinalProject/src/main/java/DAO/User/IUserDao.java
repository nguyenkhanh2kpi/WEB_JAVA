package DAO.User;

import java.util.List;

import Model.Location;
import Model.User;

public interface IUserDao {
	User findByUserName(String slug);
	void insert(User user);
	boolean checkExistSlug(String slug);
	boolean checkExistPhone(String phone);
	boolean checkExistIdCard(String id_card);
	void updatepPass(String password,String full_name);
	void updateInfor(String full_name, String id_card,String phone,String avatar ,String curr_name);
	void insertLocation(String slug, String diaChi);
	List<Location> findAllLocation();
}
