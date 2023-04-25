package Services;

import java.util.List;

import Model.Category;

public interface ICategoryServices {
	List<Category> findAll();

	void insertCategory(Category category);

	Category findById(int id);

	void editCategory(Category category);
}
