package DAO.User.UserDaoImpl;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Connection.Connection;
import DAO.User.IProductUserDAO;
import Model.Category;
import Model.Product;
import Model.SubProduct;

public class ProductUserImpl extends Connection implements IProductUserDAO {

	@Override
	public List<Product> findHotProduct() {
		// TODO Auto-generated method stub
		List<Product> products = new ArrayList<Product>();
		String sql = "SELECT TOP 4* from Product ORDER BY price";
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
	public List<Product> findBestSellerProduct() {
		// TODO Auto-generated method stub
		List<Product> products = new ArrayList<Product>();
		String sql = "SELECT TOP 4* from Product ORDER BY sold";
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
	public List<Category> findAllCategory() {
		// TODO Auto-generated method stub
		List<Category> cates = new ArrayList<Category>();
		String sql = "SELECT * from Category";
		try {
			java.sql.Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Category cate = new Category();
				cate.setId(rs.getInt("id"));
				cate.setName(rs.getString("name"));
				cate.setSlug(rs.getString("slug"));
				cates.add(cate);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cates;
	}

	@Override
	public List<Product> getAllProductPagging(int pageIndex, int pageSize) {
		// TODO Auto-generated method stub
		List<Product> products = new ArrayList<Product>();
		String sql = "SELECT * from (SELECT ROW_NUMBER() OVER (ORDER BY id) AS RN,  * FROM Product) AS X\r\n"
				+ "WHERE RN BETWEEN (?-1)*? +1 AND ? * ?";
		try {
			java.sql.Connection conn = super.getConnection();
			PreparedStatement ps  = conn.prepareStatement(sql);
			ps.setInt(1, pageIndex);
			ps.setInt(2, pageSize);
			ps.setInt(3, pageIndex);
			ps.setInt(4, pageSize);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
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
	public int getCountTotalProducts() {
		// TODO Auto-generated method stub
		String sql = "SELECT COUNT(id) FROM Product";
		try {
			int count = 0;
			java.sql.Connection conn = super.getConnection();
			PreparedStatement ps  = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				count = rs.getInt(1);
			}
			return count;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public Product getDetail(int id) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM Product WHERE id = ? ";
		try {
			java.sql.Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
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
				return product;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Product> getAllProductbyCate(int cateID) {
		// TODO Auto-generated method stub
		List<Product> products = new ArrayList<Product>();
		String sql = "SELECT * FROM Product WHERE categoryId = ? ";
		try {
			java.sql.Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, cateID);
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
	public List<Product> findProductByName(String name) {
		// TODO Auto-generated method stub
		List<Product> shops = new ArrayList<Product>();
		String sql = "SELECT * from Product WHERE name LIKE '%'+?+'%' ORDER BY id ASC";
		try {
			java.sql.Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, name);
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
				shops.add(product);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return shops;
	}

	@Override
	public List<Product> findAllProduct() {
		// TODO Auto-generated method stub
		List<Product> products = new ArrayList<Product>();
		String sql = "SELECT * from Product";
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
	public void subscribe(String productName,int productId, int userId){
		// TODO Auto-generated method stub
		String sql = "INSERT INTO subProduct (productName, productId, userId) "
				+ "VALUES (?,?,?)";
		try {
			java.sql.Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, productName);
			ps.setInt(2, productId);
			ps.setInt(3, userId);
			ps.executeUpdate();
			} 
		catch (Exception e) {
			e.printStackTrace();}
	}

	@Override
	public List<SubProduct> getAllProductSubed(int userId) {
		// TODO Auto-generated method stub
		List<SubProduct> subProducts = new ArrayList<SubProduct>();
		String sql = "SELECT * from subProduct where userId=?";
		try {
			java.sql.Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, userId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				SubProduct subProduct = new SubProduct();
				subProduct.setId(rs.getInt("id"));
				subProduct.setProductName(rs.getString("productName"));
				subProduct.setProductId(rs.getInt("productId"));
				subProduct.setUserId(rs.getInt("userId"));
				subProducts.add(subProduct);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return subProducts;
	}
}
