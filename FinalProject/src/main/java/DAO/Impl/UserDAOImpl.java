package DAO.Impl;


import java.io.File;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Connection.Connection;
import DAO.IUserDAO;
import Model.RoleUser;
import Model.User;
import Utils.Constant;

public class UserDAOImpl extends Connection implements IUserDAO {

	java.sql.Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	@Override
	public User findById(int id) {
		String sql = "select * from _User where id =?";
		try {
			conn = super.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setId_role(rs.getInt("id_role"));
				user.setFull_name(rs.getString("full_name"));
				user.setSlug(rs.getString("slug"));
				user.setId_card(rs.getString("id_card"));
				user.setPhone(rs.getString("phone"));
				user.setPassword(rs.getString("password"));
				user.setAvatar(rs.getString("avatar"));
				user.setActive(rs.getBoolean("isActive"));
				return user;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public List<User> findAll() {
		List<User> users = new ArrayList<User>();
		String sql = "Select * From _User";
		try {
			conn = super.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setId_role(rs.getInt("id_role"));
				user.setFull_name(rs.getString("full_name"));
				user.setSlug(rs.getString("slug"));
				user.setId_card(rs.getString("id_card"));
				user.setPhone(rs.getString("phone"));
				user.setPassword(rs.getString("password"));
				user.setAvatar(rs.getString("avatar"));
				user.setActive(rs.getBoolean("isActive"));
				user.setCreatedAt(rs.getDate("createdAt"));
				user.setUpdatedAt(rs.getDate("updatedAt"));
				user.setAvatar(rs.getString("avatar"));
				users.add(user);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return users;
		
	}
	@Override
	public List<User> findUserByIdRole(int idRole) {
		List<User> users = new ArrayList<User>();
		String sql = "Select * From _User Where id_role=?";
		try {
			conn = super.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, idRole);
			rs = ps.executeQuery();
			while(rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setId_role(rs.getInt("id_role"));
				user.setFull_name(rs.getString("full_name"));
				user.setSlug(rs.getString("slug"));
				user.setId_card(rs.getString("id_card"));
				user.setPhone(rs.getString("phone"));
				user.setPassword(rs.getString("password"));
				user.setAvatar(rs.getString("avatar"));
				user.setActive(rs.getBoolean("isActive"));
				user.setCreatedAt(rs.getDate("createdAt"));
				user.setUpdatedAt(rs.getDate("updatedAt"));
				user.setAvatar(rs.getString("avatar"));
				users.add(user);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return users;
		
	}
	
	@Override
	public void blockUser(int id) {
		String sql = "UPDATE _User\r\n"
				+ "SET isActive=0\r\n"
				+ "WHERE _User.id = ?";
		try {
			conn = super.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void unblockUser(int id) {
		String sql = "UPDATE _User\r\n"
				+ "SET isActive=1\r\n"
				+ "WHERE _User.id = ?";
		try {
			conn = super.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateRole(int idRole, int id) {
		String sql = "Update _User SET id_role=? where id=?";
		try {
			conn = super.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, idRole);
			ps.setInt(2, id);
			ps.executeUpdate();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	@Override
	public void updateUser(User user) {
		String sql = "Update _User SET full_name=?, avatar=?, id_card=?, phone=?, id_role=?, password =?, slug=?, updatedAt=GETDATE() where id=?";
		try {
			conn = super.getConnection();
			ps = conn.prepareStatement(sql);

			ps.setString(1, user.getFull_name());
			ps.setString(2, user.getAvatar());
			ps.setString(3, user.getId_card());
			ps.setString(4, user.getPhone());
			ps.setInt(5, user.getId_role());
			ps.setString(6, user.getPassword());
			ps.setString(7, user.getSlug());
			ps.setInt(8, user.getId());
			ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void editUser(User newUser) {
		User oldUser = this.findById(newUser.getId()); 
		oldUser.setFull_name(newUser.getFull_name());
		oldUser.setId_card(newUser.getId_card());
		oldUser.setPhone(newUser.getPhone());
		oldUser.setId_role(newUser.getId_role());
		oldUser.setSlug(newUser.getSlug());
		oldUser.setPassword(newUser.getPassword());
		if (newUser.getAvatar() != null) {
			// XOA ANH CU DI
			String fileName = oldUser.getAvatar();
			final String dir = Constant.DIR;
			File file = new File(dir + "/category" + fileName);
			if (file.exists()) {
				file.delete();
			}
			oldUser.setAvatar(newUser.getAvatar());
		}
		this.updateUser(oldUser);
	}
	
	@Override
	public List<RoleUser> findAllIdRole() {
		List<RoleUser> roleList = new ArrayList<RoleUser>();
		String sql = "Select * From Role_user";
		try {
			conn = super.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				RoleUser role = new RoleUser();
				role.setId(rs.getInt("id"));
				role.setRoleName(rs.getString("role_name"));
				roleList.add(role);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return roleList;
	}

	@Override
	public void insertUser(User user) {
		/*
		 * String sql =
		 * "Update _User SET full_name=?, avatar=?, id_card=?, phone=?, id_role=?, password =?, slug=?, updatedAt=GETDATE() where id=?"
		 * ;
		 */
		
		String sql = "INSERT INTO _User(id_role, full_name, slug, id_card, phone, password, avatar, point, createdAt, updatedAt) VALUES (?,?,?,?,?,?,?,0,GETDATE(),NULL)";
		try {
			conn = super.getConnection();
			ps = conn.prepareStatement(sql);

			ps.setInt(1, user.getId_role());
			ps.setString(2, user.getFull_name());
			ps.setString(3, user.getSlug());
			ps.setString(4, user.getId_card());
			ps.setString(5, user.getPhone());
			ps.setString(6, user.getPassword());
			ps.setString(7, user.getAvatar());
			ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public User loginUser(String account, String password) {
		String sql = "SELECT * FROM _USER WHERE slug=? and password=?";
		try {
			conn = super.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, account);
			ps.setString(2, password);
			rs = ps.executeQuery();
			while(rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setId_role(rs.getInt("id_role"));
				user.setFull_name(rs.getString("full_name"));
				user.setSlug(rs.getString("slug"));
				user.setId_card(rs.getString("id_card"));
				user.setPhone(rs.getString("phone"));
				user.setPassword(rs.getString("password"));
				user.setAvatar(rs.getString("avatar"));
				user.setActive(rs.getBoolean("isActive"));
				return user;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public User findByUserName(String username) {
		String sql = "SELECT * FROM _User WHERE slug = ? ";
		try {
		java.sql.Connection conn = super.getConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, username);
		ResultSet  rs = ps.executeQuery();
		while (rs.next()) {
		User user = new User();
		user.setId(rs.getInt("id"));
		user.setId_role(rs.getInt("id_role"));
		user.setSlug(rs.getString("slug"));
		user.setId_card(rs.getString("id_card"));
		user.setFull_name(rs.getString("full_name"));
		user.setPassword(rs.getString("password"));
		user.setAvatar(rs.getString("avatar"));
		user.setPhone(rs.getString("phone"));
		user.setCreatedAt(rs.getDate("createdAt"));
		return user;}
		} catch (Exception e) {e.printStackTrace();}
		return null;
	}
}
