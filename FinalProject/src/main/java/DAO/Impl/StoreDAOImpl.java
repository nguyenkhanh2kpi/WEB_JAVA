package DAO.Impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Connection.Connection;
import DAO.IStoreDAO;
import Model.Store;

public class StoreDAOImpl extends Connection implements IStoreDAO {

	@Override
	public List<Store> finALL() {
		List<Store> stores = new ArrayList<Store>();
		String sql = "select * from Store";
		try {
			java.sql.Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Store store = new Store();
				store.setId(rs.getInt("id"));
				store.setName(rs.getString("name"));
				store.setBio(rs.getString("bio"));
				store.setSlug(rs.getString("slug"));
				store.setOwnerId(rs.getInt("ownerId"));
				store.setActive(rs.getBoolean("isActive"));
				store.setAvatar(rs.getString("avatar"));
				store.setCommissionId(rs.getInt("commissionId"));
				store.setE_wallet(rs.getFloat("e_wallet"));
				store.setCreatedAt(rs.getDate("createdAt"));
				store.setUpdatedAt(rs.getDate("updatedAt"));
				stores.add(store);
			}} catch (Exception e) {
				e.printStackTrace();}
		return stores;
	}

	@Override
	public void Insert(Store store) {
		String sql = "insert into Store (name,bio,slug,ownerId,isActive,avatar,commissionId,e_wallet) values (?,"
				+ "?,?,?,?,?,?,?)";
		try {
			java.sql.Connection conn = super.getConnection(); 
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, store.getName());
			ps.setString(2, store.getBio());
			ps.setString(3, store.getSlug());
			ps.setInt(4, store.getOwnerId());
			ps.setBoolean(5, store.isActive());
			ps.setString(6, store.getAvatar());
			ps.setInt(7, store.getCommissionId());
			ps.setFloat(8, store.getE_wallet());
//			ps.setDate(9, store.getCreatedAt()); 
//			ps.setDate(10, store.getUpdatedAt());
			ps.execute();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void Delete(int storeId) {
		String sql = "delete from Store where id = ?";
		try {
		java.sql.Connection con = super.getConnection();
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, storeId);
		ps.executeUpdate();
		} catch (Exception e) {
		e.printStackTrace();
		}
	}

	@Override
	public void EditStore(Store store) {
		String sql= "UPDATE Store SET name = ?, bio = ?, avatar = ? WHERE id  = ?;";
		try {
			java.sql.Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,store.getName());
			ps.setString(2, store.getBio());
			ps.setString(3, store.getAvatar());
			ps.setInt(4, store.getId());
			ps.executeUpdate();
			} catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public Store FindById(int id) {
		Store store = new Store();
		String sql = "select * from Store where id=" + id;
		try {
			java.sql.Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				store.setId(rs.getInt("id"));
				store.setName(rs.getString("name"));
				store.setBio(rs.getString("bio"));
				store.setSlug(rs.getString("slug"));
				store.setOwnerId(rs.getInt("ownerId"));
				store.setActive(rs.getBoolean("isActive"));
				store.setAvatar(rs.getString("avatar"));
				store.setCommissionId(rs.getInt("commissionId"));
				store.setE_wallet(rs.getFloat("e_wallet"));
				store.setCreatedAt(rs.getDate("createdAt"));
				store.setUpdatedAt(rs.getDate("updatedAt"));
			}} catch (Exception e) {
				e.printStackTrace();}
		return store;
	}
	@Override
	public List<Store> finByUser(int userId) {
		List<Store> stores = new ArrayList<Store>();
		String sql = "select * from Store where ownerId=" + userId;
		try {
			java.sql.Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Store store = new Store();
				store.setId(rs.getInt("id"));
				store.setName(rs.getString("name"));
				store.setBio(rs.getString("bio"));
				store.setSlug(rs.getString("slug"));
				store.setOwnerId(rs.getInt("ownerId"));
				store.setActive(rs.getBoolean("isActive"));
				store.setAvatar(rs.getString("avatar"));
				store.setCommissionId(rs.getInt("commissionId"));
				store.setE_wallet(rs.getFloat("e_wallet"));
				store.setCreatedAt(rs.getDate("createdAt"));
				store.setUpdatedAt(rs.getDate("updatedAt"));
				stores.add(store);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return stores;
	}
	
	@Override
	public List<Store> storeProductList(){
		List<Store> stores = new ArrayList<Store>();
		String sql = "SELECT K.id, K.name, K.bio, K.slug, U.full_name, K.isActive, K.avatar, C.name as nameCommision, e_wallet, K.createdAt, K.updatedAt, S.numberProductActive, S.numberProductInactive\r\n"
				+ "FROM Store K \r\n"
				+ "	INNER JOIN (SELECT P.storeId, K.numberProductActive, COUNT(case when isActive = 'False' then 1 else null end) as numberProductInactive\r\n"
				+ "	FROM Product P FULL OUTER JOIN (SELECT storeId, COUNT(*) as numberProductActive\r\n"
				+ "	FROM Product\r\n"
				+ "	WHERE isActive = 1\r\n"
				+ "	GROUP BY storeId) K on K.storeId = P.storeId\r\n"
				+ "	GROUP BY P.storeId, K.numberProductActive) S \r\n"
				+ "	ON S.storeId = K.id\r\n"
				+ "	INNER JOIN\r\n"
				+ "	Commission as C \r\n"
				+ "	ON C.id = K.commissionId\r\n"
				+ "	INNER JOIN\r\n"
				+ "	_User as U\r\n"
				+ "	ON K.ownerId = U.id";
		try {
			java.sql.Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Store store = new Store();
				store.setId(rs.getInt("id"));
				store.setName(rs.getString("name"));
				store.setBio(rs.getString("bio"));
				store.setSlug(rs.getString("slug"));
				store.setNameOwner(rs.getNString("full_name"));
				store.setActive(rs.getBoolean("isActive"));
				store.setAvatar(rs.getString("avatar"));
				store.setNameCommission(rs.getString("nameCommision"));
				store.setE_wallet(rs.getFloat("e_wallet"));
				store.setCreatedAt(rs.getDate("createdAt"));
				store.setUpdatedAt(rs.getDate("updatedAt"));
				store.setNumberProductActive(rs.getInt("numberProductActive"));
				store.setNumberProductInactive(rs.getInt("numberProductInactive"));
				stores.add(store);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return stores;
	}
	@Override
	public void blockStore(int id) {
		String sql = "UPDATE Store\r\n"
				+ "SET isActive=0\r\n"
				+ "WHERE id = ?";
		try {
			java.sql.Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void unblockStore(int id) {
		String sql = "UPDATE Store\r\n"
				+ "SET isActive=1\r\n"
				+ "WHERE Store.id = ?";
		try {
			java.sql.Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		IStoreDAO storeDAO = new StoreDAOImpl();
		storeDAO.finByUser(2);
		System.out.println(storeDAO.finByUser(1).toString());
	}


}
