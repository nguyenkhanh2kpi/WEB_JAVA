package Services;

import java.util.List;

import Model.Product;

public interface IFindProductServices {
	List<Product> findByName(String keyWord);
}
