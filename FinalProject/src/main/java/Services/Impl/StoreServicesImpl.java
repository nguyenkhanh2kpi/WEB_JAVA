package Services.Impl;

import java.sql.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import Connection.Connection;
import DAO.IStoreDAO;
import DAO.Impl.StoreDAOImpl;
import Model.Store;
import Services.IStoreServices;

public class StoreServicesImpl extends Connection implements IStoreServices {
	IStoreDAO storeDAO = new StoreDAOImpl();

	@Override
	public List<Store> finALL() {
		return storeDAO.finALL();
	}

	@Override
	public void Insert(Store store) {
		/*
		 * DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		 * LocalDateTime now = LocalDateTime.now(); Date d = new Date(2022, 12, 13);
		 */
		storeDAO.Insert(store);
	}

	@Override
	public void Delete(int StoreID) {
		storeDAO.Delete(StoreID);

	}

	@Override
	public void Edit(Store store) {
		storeDAO.EditStore(store);
	}

	@Override
	public Store FindById(int id) {
		return storeDAO.FindById(id);
	}

	@Override
	public List<Store> findByUser(int userId) {
		return storeDAO.finByUser(userId);
	}

	@Override
	public List<Store> storeProductList() {
		return storeDAO.storeProductList();
	}
	
	@Override
	public void blockStore(int id) {
		storeDAO.blockStore(id);
	}
	
	@Override
	public void unblockStore(int id) {
		storeDAO.unblockStore(id);
	}
}
