package DAO;

import java.util.List;

import Model.Product;

public interface IFindProductDAO {
	List<Product> findByName(String keyWord);
}
