package DAO.Impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Connection.Connection;
import DAO.IFindProductDAO;
import Model.Product;

public class FindProductDAO extends Connection  implements IFindProductDAO  {	
	// Tìm kiếm trên ô tìm kiếm
	@Override
	public List<Product> findByName(String keyWord) {
		List<Product> products = new ArrayList<Product>();
		String sql = "select * from FindProduct('" + keyWord +"')";
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
	
	public static void main(String[] args) {
		FindProductDAO d = new FindProductDAO();
		System.out.println(d.findByName("s21"));
	}

}
