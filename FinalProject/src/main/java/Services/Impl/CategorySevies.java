package Services.Impl;

import java.util.List;

import DAO.ICategoryDAO;
import DAO.Impl.CategoryDAO;
import Model.Category;
import Services.ICategoryServices;

public class CategorySevies implements ICategoryServices {
	ICategoryDAO categoryDAO = new CategoryDAO();

	@Override
	public List<Category> findAll() {
		return categoryDAO.findAll();
	}

	@Override
	public void insertCategory(Category category) {
		categoryDAO.addCategory(category);
	}

	@Override
	public Category findById(int id) {
		return categoryDAO.findById(id);
	}
	
	@Override
	public void editCategory(Category category) {
		categoryDAO.editCategory(category);
	}
}
