package Services.User;

import java.util.List;

import Model.Product;
import Model.Store;
import Model.SubStore;

public interface IShopServices {
	List<Store> findAllShop();
	List<Store> findShopByName(String name);
	Store getDetail(int id);
	List<Product> getAllProductByShopid(int id);
	List<Product> findProductShopByName(int id,String name);
	void subscribe(String Store,int shopId,int userId);
	List<SubStore> getAllStoredSubed(int userId);
}
