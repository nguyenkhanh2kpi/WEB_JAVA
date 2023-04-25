package Services;

import java.util.List;

import Model.Store;

public interface IStoreServices {
	List<Store> finALL();
	List<Store> findByUser(int userId);
	void Insert(Store store);
	void Delete(int StoreID);
	void Edit(Store store);
	Store FindById(int id);
	List<Store> storeProductList();
	void unblockStore(int id);
	void blockStore(int id);
}
