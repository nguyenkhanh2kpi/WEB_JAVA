package DAO.User.UserDaoImpl;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Connection.Connection;
import DAO.User.IShopDAO;
import Model.Product;
import Model.Store;
import Model.SubStore;

public class ShopImpl extends Connection implements IShopDAO{

	@Override
	public List<Store> findAllShop() {
		// TODO Auto-generated method stub
		List<Store> shops = new ArrayList<Store>();
		String sql = "SELECT * from Store";
		try {
			java.sql.Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Store shop = new Store();
				shop.setId(rs.getInt("id"));
				shop.setName(rs.getString("name"));
				shop.setBio(rs.getString("bio"));
				shop.setSlug(rs.getString("slug"));
				shop.setActive(rs.getBoolean("isActive"));
				shop.setAvatar(rs.getString("avatar"));
				shops.add(shop);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return shops;
	}

	@Override
	public List<Store> findShopByName(String name) {
		// TODO Auto-generated method stub
		List<Store> shops = new ArrayList<Store>();
		String sql = "SELECT * from Store WHERE name LIKE '%'+?+'%' ORDER BY id ASC";
		try {
			java.sql.Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Store shop = new Store();
				shop.setId(rs.getInt("id"));
				shop.setName(rs.getString("name"));
				shop.setBio(rs.getString("bio"));
				shop.setSlug(rs.getString("slug"));
				shop.setActive(rs.getBoolean("isActive"));
				shop.setAvatar(rs.getString("avatar"));
				shops.add(shop);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return shops;
	}

	@Override
	public Store getDetail(int id) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM Store WHERE id = ? ";
		try {
			java.sql.Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Store shop = new Store();
				shop.setId(rs.getInt("id"));
				shop.setName(rs.getString("name"));
				shop.setBio(rs.getString("bio"));
				shop.setSlug(rs.getString("slug"));
				shop.setActive(rs.getBoolean("isActive"));
				shop.setAvatar(rs.getString("avatar"));
				return shop;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Product> getAllProductByShopid(int id) {
		// TODO Auto-generated method stub
		List<Product> products = new ArrayList<Product>();
		String sql = "SELECT * from Product Where storeId=?";
		try {
			java.sql.Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Product product = new Product();
				product.setId(rs.getInt("id"));
				product.setName(rs.getString("name"));
				product.setSlug(rs.getString("slug"));
				product.setDescription(rs.getString("description"));
				product.setPrice(rs.getInt("price"));
				product.setQuantity(rs.getInt("quantity"));
				product.setActive(rs.getBoolean("isActive"));
				product.setImages(rs.getString("images"));
				product.setCategoryId(rs.getInt("categoryId"));
				product.setStoreId(rs.getInt("storeId"));
				products.add(product);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return products;
	}

	@Override
	public List<Product> findProductShopByName(int id, String name) {
		// TODO Auto-generated method stub
		List<Product> products = new ArrayList<Product>();
		String sql = "SELECT * from Product Where storeId=? and name LIKE '%'+?+'%'";
		try {
			java.sql.Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.setString(2, name);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Product product = new Product();
				product.setId(rs.getInt("id"));
				product.setName(rs.getString("name"));
				product.setSlug(rs.getString("slug"));
				product.setDescription(rs.getString("description"));
				product.setPrice(rs.getInt("price"));
				product.setQuantity(rs.getInt("quantity"));
				product.setActive(rs.getBoolean("isActive"));
				product.setImages(rs.getString("images"));
				product.setCategoryId(rs.getInt("categoryId"));
				product.setStoreId(rs.getInt("storeId"));
				products.add(product);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return products;
	}
	@Override
	public void subscribe(String shopName, int shopId, int userId) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO subStore(shopName,storeId, userId) "
				+ "VALUES (?,?,?)";
		try {
			java.sql.Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, shopName);
			ps.setInt(2, shopId);
			ps.setInt(3, userId);
			ps.executeUpdate();
			} 
		catch (Exception e) {
			e.printStackTrace();}
	}

	@Override
	public List<SubStore> getAllStoredSubed(int userId) {
		// TODO Auto-generated method stub
		List<SubStore> subStores = new ArrayList<SubStore>();
		String sql = "SELECT * from subStore where userId=?";
		try {
			java.sql.Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, userId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				SubStore subStore = new SubStore();
				subStore.setId(rs.getInt("id"));
				subStore.setShopName(rs.getString("shopName"));
				subStore.setStoreId(rs.getInt("storeId"));
				subStore.setUserId(rs.getInt("userId"));
				subStores.add(subStore);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return subStores;
	}

}
