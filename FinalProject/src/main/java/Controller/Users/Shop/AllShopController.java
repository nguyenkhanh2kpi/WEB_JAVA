package Controller.Users.Shop;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Store;
import Services.User.IProductServices;
import Services.User.IShopServices;
import Services.User.Impl.ProductServicesImpl;
import Services.User.Impl.ShopServicesImpl;

@WebServlet(urlPatterns = {"/user/allshop", "/user/findshop"})
public class AllShopController extends HttpServlet{
	IShopServices shopService = new ShopServicesImpl();
	IProductServices categories = new ProductServicesImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = req.getRequestURL().toString();
		if (url.contains("user/allshop")) {
			allShop(req, resp);
		} else if (url.contains("user/findshop")) {
			findShop(req, resp);
		} else if (url.contains("user/product/loadAjax")) {
			/* productLoadAjax(req, resp); */
		}
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private void allShop(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Store> store = shopService.findAllShop();
		req.setAttribute("allshop", store);
		req.setAttribute("categories", categories.findAllCategory());
		RequestDispatcher rd = req.getRequestDispatcher("/view/user/shop/allshop.jsp");
		rd.forward(req, resp);
	}
	private void findShop(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String name = req.getParameter("name");
		List<Store> store = shopService.findShopByName(name);
		req.setAttribute("allshop", store);
		req.setAttribute("categories", categories.findAllCategory());
		RequestDispatcher rd = req.getRequestDispatcher("/view/user/shop/allshop.jsp");
		rd.forward(req, resp);
	}
	

}
