package Controller.Users.Product;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Product;
import Services.User.IProductServices;
import Services.User.Impl.ProductServicesImpl;


@WebServlet(urlPatterns = {"/user/product-featured","/user/findproduct"})
public class ProductFeatureController extends HttpServlet{
	IProductServices productsService = new ProductServicesImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = req.getRequestURL().toString();
		if (url.contains("/user/product-featured")) {
			productbyCateID(req, resp);
		} else if (url.contains("/user/findproduct")) {
			findProduct(req, resp);
		}
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private void productbyCateID(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int cateID = Integer.parseInt(req.getParameter("cateID"));
		List<Product> productList = productsService.getAllProductbyCate(cateID);
		req.setAttribute("productList", productList);
		req.setAttribute("categories", productsService.findAllCategory());
		RequestDispatcher rd = req.getRequestDispatcher("/view/user/product/product-featured.jsp");
		rd.forward(req, resp);
	}
	private void findProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String name = req.getParameter("nameProduct");
		List<Product> productList = productsService.findProductByName(name);
		req.setAttribute("productList", productList);
		req.setAttribute("categories", productsService.findAllCategory());
		RequestDispatcher rd = req.getRequestDispatcher("/view/user/product/product-featured.jsp");
		rd.forward(req, resp);
	}

}
