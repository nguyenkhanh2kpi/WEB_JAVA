package DAO;

import java.util.List;

import Model.Store;

public interface IStoreDAO {
	List<Store> finALL();
	List<Store> finByUser(int userId);
	void Insert(Store store);
	void Delete(int storeId);
	void EditStore(Store store);
	Store FindById(int id);
	List<Store> storeProductList();
	void unblockStore(int id);
	void blockStore(int id);
	
}
