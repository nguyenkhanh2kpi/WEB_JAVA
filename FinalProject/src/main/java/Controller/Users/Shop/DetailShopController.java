package Controller.Users.Shop;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Product;
import Model.Store;
import Services.User.IShopServices;
import Services.User.Impl.ShopServicesImpl;

@WebServlet(urlPatterns = {"/user/detail-shop"})
public class DetailShopController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("nameProduct");
		IShopServices shops = new ShopServicesImpl();
		Store detailShop = shops.getDetail(id);
		List<Product> AllProductByShopid = new ArrayList<Product>();
		if(name == null) {
			AllProductByShopid = shops.getAllProductByShopid(id);
		}
		else
		{
			AllProductByShopid = shops.findProductShopByName(id, name);
		}
		req.setAttribute("detailShop", detailShop);
		req.setAttribute("AllProductByShopid", AllProductByShopid);
		int i=0;
		for (@SuppressWarnings("unused") Product product : AllProductByShopid)
		{
			i++;
		}
		req.setAttribute("Count", i);
		RequestDispatcher rd = req.getRequestDispatcher("/view/user/shop/detail-shop.jsp");
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

}
