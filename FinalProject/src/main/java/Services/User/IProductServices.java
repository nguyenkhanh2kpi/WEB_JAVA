package Services.User;

import java.util.List;

import Model.Category;
import Model.Product;
import Model.SubProduct;

public interface IProductServices {
	Product getDetail(int id);
	List<Product> findHotProduct();
	List<Product> findBestSellerProduct();
	List<Product> getAllProductPagging(int pageIndex, int pageSize);
	List<Product> getAllProductbyCate(int cateID);
	List<Product> findProductByName(String name);
	List<Product> findAllProduct();
	int getCountTotalProducts();
	List<Category> findAllCategory();
	void subscribe(String productName,int productId, int userId);
	List<SubProduct> getAllProductSubed(int userId);
}
