package Services.User.Impl;

import java.util.List;

import DAO.User.IProductUserDAO;
import DAO.User.UserDaoImpl.ProductUserImpl;
import Model.Category;
import Model.Product;
import Model.SubProduct;
import Services.User.IProductServices;


public class ProductServicesImpl implements IProductServices {
	IProductUserDAO products = new ProductUserImpl();
	@Override
	public List<Product> findHotProduct() {
		// TODO Auto-generated method stub
		return products.findHotProduct();
	}

	@Override
	public List<Product> findBestSellerProduct() {
		// TODO Auto-generated method stub
		return products.findBestSellerProduct();
	}
	@Override
	public List<Category> findAllCategory() {
		// TODO Auto-generated method stub
		return products.findAllCategory();
	}

	@Override
	public List<Product> getAllProductPagging(int pageIndex, int pageSize) {
		// TODO Auto-generated method stub
		return products.getAllProductPagging(pageIndex, pageSize);
	}

	@Override
	public int getCountTotalProducts() {
		// TODO Auto-generated method stub
		return products.getCountTotalProducts();
	}

	@Override
	public Product getDetail(int id) {
		// TODO Auto-generated method stub
		return products.getDetail(id);
	}

	@Override
	public List<Product> getAllProductbyCate(int cateID) {
		// TODO Auto-generated method stub
		return products.getAllProductbyCate(cateID);
	}

	@Override
	public List<Product> findProductByName(String name) {
		// TODO Auto-generated method stub
		return products.findProductByName(name);
	}

	@Override
	public List<Product> findAllProduct() {
		// TODO Auto-generated method stub
		return products.findAllProduct();
	}

	@Override
	public void subscribe(String productName,int productId, int userId) {
		// TODO Auto-generated method stub
		products.subscribe(productName,productId,userId);
		return;
	}

	@Override
	public List<SubProduct> getAllProductSubed(int userId) {
		// TODO Auto-generated method stub
		return products.getAllProductSubed(userId);
	}
}
