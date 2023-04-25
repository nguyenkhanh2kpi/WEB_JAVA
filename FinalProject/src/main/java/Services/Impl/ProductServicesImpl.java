package Services.Impl;

import java.util.List;

import DAO.IProductDAO;
import DAO.Impl.ProductDAOImpl;
import Model.Product;
import Services.IProductServices;

public class ProductServicesImpl implements IProductServices {
	IProductDAO productDAO = new ProductDAOImpl();
	@Override
	public List<Product> findByStore(int idStore) {
		return productDAO.findByStore(idStore);
	}
	@Override
	public void Insert(Product product) {
		 productDAO.Insert(product);
		
	}
	@Override
	public void Delete(int idProduct) {
		productDAO.Delete(idProduct);
		
	}
	@Override
	public void Update(Product prduct) {
		productDAO.Update(prduct);
	}
	@Override
	public Product findById(int id) {
		return productDAO.findById(id);
	}
	
	@Override
	public List<Product> listProductActive(int idStore, int active){
		return productDAO.listProductActive(idStore, active);
	}
	
	@Override
	public void blockProduct(int id) {
		productDAO.blockProduct(id);
	}
	@Override
	public void unblockProduct(int id) {
		productDAO.unblockProduct(id);
	}
}
