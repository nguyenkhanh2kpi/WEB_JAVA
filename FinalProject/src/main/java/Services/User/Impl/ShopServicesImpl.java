package Services.User.Impl;

import java.util.List;

import DAO.User.IShopDAO;
import DAO.User.UserDaoImpl.ShopImpl;
import Model.Product;
import Model.Store;
import Model.SubStore;
import Services.User.IShopServices;


public class ShopServicesImpl implements IShopServices{
	IShopDAO shops = new ShopImpl();
	@Override
	public List<Store> findAllShop() {
		// TODO Auto-generated method stub
		return shops.findAllShop();
	}

	@Override
	public List<Store> findShopByName(String name) {
		// TODO Auto-generated method stub
		return shops.findShopByName(name);
	}

	@Override
	public List<Product> getAllProductByShopid(int id) {
		// TODO Auto-generated method stub
		return shops.getAllProductByShopid(id);
	}

	@Override
	public Store getDetail(int id) {
		// TODO Auto-generated method stub
		return shops.getDetail(id);
	}

	@Override
	public List<Product> findProductShopByName(int id, String name) {
		// TODO Auto-generated method stub
		return shops.findProductShopByName(id, name);
	}

	@Override
	public void subscribe(String shopName,int shopId, int userId) {
		// TODO Auto-generated method stub
		shops.subscribe(shopName,shopId, userId);
		return;
	}

	@Override
	public List<SubStore> getAllStoredSubed(int userId) {
		// TODO Auto-generated method stub
		return shops.getAllStoredSubed(userId);
	}

}
