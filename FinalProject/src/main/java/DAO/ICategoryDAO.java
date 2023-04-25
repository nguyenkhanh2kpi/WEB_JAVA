package DAO;

import java.util.List;

import Model.Category;


public interface ICategoryDAO {
	List<Category> findAll();

	void addCategory(Category category);

	Category findById(int id);

	void updateCategory(Category category);

	void editCategory(Category newCategory);

}
