package DAO.Impl;

import java.io.File;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Connection.Connection;
import DAO.ICategoryDAO;
import Model.Category;
import Model.User;
import Utils.Constant;

public class CategoryDAO extends Connection implements ICategoryDAO {
	java.sql.Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	@Override
	public List<Category> findAll() {
		List<Category> categories = new ArrayList<Category>();
		String sql = "SELECT * FROM Category";
		try {
			java.sql.Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Category category = new Category();
				category.setId(rs.getInt("id"));
				category.setName(rs.getString("name"));
				category.setImage(rs.getString("image"));
				category.setSlug(rs.getString("slug"));
				categories.add(category);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return categories;
	}

	@Override
	public Category findById(int id) {
		Category category = new Category();
		String sql = "SELECT * FROM Category WHERE id=?";
		try {
			java.sql.Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				category.setId(rs.getInt("id"));
				category.setName(rs.getString("name"));
				category.setImage(rs.getString("image"));
				category.setSlug(rs.getString("slug"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return category;
	}

	@Override
	public void addCategory(Category category) {
		String sql = "INSERT INTO Category VALUES(?, ?, ?)";
		try {
			conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setNString(1, category.getName());
			ps.setNString(2, category.getSlug());
			ps.setString(3, category.getImage());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateCategory(Category category) {
		String sql = "Update Category SET name=?, image=?, slug=? where id=?";
		try {
			conn = super.getConnection();
			ps = conn.prepareStatement(sql);

			ps.setString(1, category.getName());
			ps.setString(2, category.getImage());
			ps.setString(3, category.getSlug());
			ps.setInt(4, category.getId());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void editCategory(Category newCategory) {
		Category oldCategory = this.findById(newCategory.getId());
		oldCategory.setName(newCategory.getName());
		oldCategory.setSlug(newCategory.getSlug());
		if (newCategory.getImage() != null) {
			// XOA ANH CU DI
			String fileName = oldCategory.getImage();
			final String dir = Constant.DIR;
			File file = new File(dir + "/category" + fileName);
			if (file.exists()) {
				file.delete();
			}
			oldCategory.setImage(newCategory.getImage());
		}
		this.updateCategory(oldCategory);
	}

}
