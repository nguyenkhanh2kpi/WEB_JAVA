package DAO.Impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Connection.Connection;
import DAO.IProductDAO;
import Model.Product;
import Model.Store;

public class ProductDAOImpl extends Connection implements IProductDAO {

	@Override
	public List<Product> findByStore(int idStore) {
		List<Product> products = new ArrayList<Product>();
		String sql = "select * from Product where storeId = " + idStore;
		try {
			java.sql.Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Product product = new Product();
				product.setId(rs.getInt("id"));
				product.setName(rs.getString("name"));
				product.setSlug(rs.getString("slug"));
				product.setDescription(rs.getString("description"));
				product.setPrice(rs.getInt("price"));
				product.setQuantity(rs.getInt("quantity"));
				product.setSold(rs.getInt("sold"));
				product.setActive(rs.getBoolean("isActive"));
				product.setImages(rs.getString("images"));
				product.setCategoryId(rs.getInt("categoryId"));
				product.setStoreId(rs.getInt("storeId"));
				products.add(product);
			}} catch (Exception e) {
				e.printStackTrace();}
		return products;
	}
	


	@Override
	public void Insert(Product product) {
		String sql = "	insert into Product(name,slug,description,price,quantity,images,categoryId,storeId)"
				+ "	values (?,?,?,?,?,?,?,?)";
		try {
			java.sql.Connection conn = super.getConnection(); 
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, product.getName());
			ps.setString(2, product.getSlug());
			ps.setString(3, product.getDescription());
			ps.setInt(4, product.getPrice());
			ps.setInt(5, product.getQuantity());
			ps.setString(6, product.getImages());
			ps.setInt(7, product.getCategoryId());
			ps.setInt(8, product.getStoreId());
			ps.execute();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void Delete(int idProduct) {
		String sql = "delete from Product where id = ?";
		try {
		java.sql.Connection con = super.getConnection();
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, idProduct);
		ps.executeUpdate();
		} catch (Exception e) {
		e.printStackTrace();
		}
		
	}


	@Override
	public void Update(Product product) {
		String sql = "UPDATE Product SET name=?,description=?,price=?,quantity=?,images=? WHERE id=?;";
		try {
			java.sql.Connection conn = super.getConnection(); 
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, product.getName());
			ps.setString(2, product.getDescription());
			ps.setInt(3, product.getPrice());
			ps.setInt(4, product.getQuantity());
			ps.setString(5, product.getImages());
			ps.setInt(6, product.getId());
			ps.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}



	@Override
	public Product findById(int id) {
		Product product = new Product();
		String sql = "select * from Product where id=" + id;
		try {
			java.sql.Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				product.setId(rs.getInt("id"));
				product.setName(rs.getString("name"));
				product.setSlug(rs.getString("slug"));
				product.setDescription(rs.getString("description"));
				product.setPrice(rs.getInt("price"));
				product.setQuantity(rs.getInt("quantity"));
				product.setSold(rs.getInt("sold"));
				product.setActive(rs.getBoolean("isActive"));
				product.setImages(rs.getString("images"));
				product.setCategoryId(rs.getInt("categoryId"));
				product.setStoreId(rs.getInt("storeId"));
			}} catch (Exception e) {
				e.printStackTrace();}
		return product;
	}
	
	@Override
	public List<Product> listProductActive(int idStore, int active) {
		List<Product> products = new ArrayList<Product>();
		String sql = "SELECT P.id, P.name, P.slug, P.price, P.quantity, P.sold, P.isActive, P.images, C.name as categoryName, S.name as storeName \r\n"
				+ "FROM Product P\r\n"
				+ "INNER JOIN Category as C ON C.id = P.categoryId\r\n"
				+ "INNER JOIN Store as S ON P.storeId = S.id\r\n"
				+ "WHERE P.storeId = ? AND P.isActive = ?";
		try {
			java.sql.Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, idStore);
			ps.setInt(2, active);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Product product = new Product();
				product.setId(rs.getInt("id"));
				product.setName(rs.getString("name"));
				product.setSlug(rs.getString("slug"));
				product.setPrice(rs.getInt("price"));
				product.setQuantity(rs.getInt("quantity"));
				product.setSold(rs.getInt("sold"));
				product.setActive(rs.getBoolean("isActive"));
				product.setImages(rs.getString("images"));
				product.setCategoryName(rs.getString("categoryName"));
				product.setStoreName(rs.getString("storeName"));
				products.add(product);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return products;
	}

	@Override
	public void blockProduct(int id) {
		String sql = "UPDATE Product\r\n"
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
	public void unblockProduct(int id) {
		String sql = "UPDATE Product\r\n"
				+ "SET isActive=1\r\n"
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
	public static void main(String[] args) {
		IProductDAO d = new ProductDAOImpl();
		System.out.println(d.findById(3));
	}

}
