package Controller.Vendor;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Product;
import Model.Store;
import Services.IProductServices;
import Services.IStoreServices;
import Services.Impl.ProductServicesImpl;
import Services.Impl.StoreServicesImpl;




@WebServlet(urlPatterns = {"/vendor/product"})
public class ProductByStoreController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	IProductServices productServices = new ProductServicesImpl();
	IStoreServices storeServices = new StoreServicesImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String storeId = req.getParameter("storeId");
		List<Product> products = productServices.findByStore(Integer.parseInt(storeId));
		Store store = new Store();
		store = storeServices.FindById(Integer.parseInt(storeId));
		req.setAttribute("products", products);
		req.setAttribute("store", store);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/view/vendor/product.jsp");
		dispatcher.forward(req, resp);
	}	
	
	public static void main(String[] args) {
		IProductServices productServices = new ProductServicesImpl();
		System.out.println(productServices.findByStore(1));
	}
	
}
