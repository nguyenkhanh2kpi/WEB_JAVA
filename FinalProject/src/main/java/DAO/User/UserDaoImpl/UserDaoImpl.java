package DAO.User.UserDaoImpl;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Connection.Connection;
import DAO.User.IUserDao;
import Model.Location;
import Model.User;

public class UserDaoImpl extends Connection implements IUserDao{

	@Override
	public User findByUserName(String slug) {
		String sql = "SELECT * FROM _User WHERE slug = ? ";
		try {
		java.sql.Connection conn = super.getConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, slug);
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

	@Override
	public void insert(User user) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO _User (id_role, full_name, slug, id_card, phone, password, point, isActive) "
				+ "VALUES (1,?,?,?,?,?,100,1)";
		try {
			java.sql.Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user.getFull_name());
			ps.setString(2, user.getSlug());
			ps.setString(3, user.getId_card());
			ps.setString(4, user.getPhone());
			ps.setString(5, user.getPassword());
			ps.executeUpdate();
			} 
		catch (Exception e) {
			e.printStackTrace();}
		
	}

	@Override
	public boolean checkExistSlug(String slug) {
		boolean duplicate = false;
		String query = "select * from _User where slug = ?";
		try {
		java.sql.Connection conn = super.getConnection();
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1, slug);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
		duplicate = true;
		}
		ps.close();
		conn.close();
		} catch (Exception ex) {}
		return duplicate;
	}

	@Override
	public boolean checkExistPhone(String phone) {
		boolean duplicate = false;
		String query = "select * from _User where phone = ?";
		try {
		java.sql.Connection conn = super.getConnection();
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1, phone);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
		duplicate = true;
		}
		ps.close();
		conn.close();
		} catch (Exception ex) {}
		return duplicate;
	}

	@Override
	public boolean checkExistIdCard(String id_card) {
		boolean duplicate = false;
		String query = "select * from _User where id_card = ?";
		try {
		java.sql.Connection conn = super.getConnection();
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1, id_card);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
		duplicate = true;
		}
		ps.close();
		conn.close();
		} catch (Exception ex) {}
		return duplicate;
	}

	@Override
	public void updatepPass(String password,String full_name) {
		String sql = "UPDATE _User SET Password = ? Where full_name = ?";
		try {
			java.sql.Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, password);
			ps.setString(2, full_name);
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
	}


	@Override
	public void updateInfor(String full_name, String id_card, String phone,String avatar, String curr_name) {
		// TODO Auto-generated method stub
		String sql = "UPDATE _User SET full_name = ?, id_card=?, phone=?, avatar=? Where full_name = ?";
		try {
			java.sql.Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, full_name);
			ps.setString(2, id_card);
			ps.setString(3, phone);
			ps.setString(4, avatar);
			ps.setString(5, curr_name);
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void insertLocation(String slug, String diaChi) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO Locations (DiaChi, slug) "
				+ "VALUES (?,?)";
		try {
			java.sql.Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, diaChi);
			ps.setString(2, slug);
			ps.executeUpdate();
			} 
		catch (Exception e) {
			e.printStackTrace();}
		
	}

	@Override
	public List<Location> findAllLocation() {
		// TODO Auto-generated method stub
		List<Location> locations = new ArrayList<Location>();
		String sql = "SELECT * from Locations";
		try {
			java.sql.Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Location location = new Location();
				location.setId(rs.getInt("id"));
				location.setDiaChi(rs.getString("DiaChi"));
				location.setSlug(rs.getString("slug"));
				locations.add(location);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return locations;
	}
}
