package Services;

import java.util.List;

import Model.Product;

public interface IProductServices {
	List<Product> findByStore(int idStore);
	void Insert(Product product);
	void Delete(int idProduct);
	void Update(Product prduct);
	Product findById(int id);
	List<Product> listProductActive(int idStore, int active);
	void unblockProduct(int id);
	void blockProduct(int id);
}
