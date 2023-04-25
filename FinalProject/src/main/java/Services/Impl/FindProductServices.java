package Services.Impl;

import java.util.List;

import DAO.IFindProductDAO;
import DAO.Impl.FindProductDAO;
import Model.Product;
import Services.IFindProductServices;

public class FindProductServices implements IFindProductServices {
	IFindProductDAO findProductDAO = new FindProductDAO();
	@Override
	public List<Product> findByName(String keyWord) {
		return findProductDAO.findByName(keyWord);
	}
	
}
