package Controller.Users.Cart;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.User;
import Services.User.IProductServices;
import Services.User.IShopServices;
import Services.User.Impl.ProductServicesImpl;
import Services.User.Impl.ShopServicesImpl;

@WebServlet(urlPatterns = {"/user/subscribe"})
public class SubscribeController extends HttpServlet{
	IProductServices productServices = new ProductServicesImpl();
	IShopServices storeServices = new ShopServicesImpl();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		int productId = Integer.parseInt(req.getParameter("productId"));
		String productName = req.getParameter("productName");
		HttpSession session = req.getSession();
		User account = (User) session.getAttribute("account");
		if (account == null)
		{
			resp.sendRedirect(req.getContextPath() + "/login");
		}
		else
		{
			try {
				productServices.subscribe(productName, productId, account.getId());
				resp.sendRedirect(req.getContextPath() + "/user/subscribe");
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = req.getSession();
		User account = (User) session.getAttribute("account");
		if (account == null)
		{
			resp.sendRedirect(req.getContextPath() + "/login");
		}
		else
		{
			req.setAttribute("subProducts", productServices.getAllProductSubed(account.getId()));
			req.setAttribute("subStores", storeServices.getAllStoredSubed(account.getId()));
			RequestDispatcher rd = req.getRequestDispatcher("/view/user/product/sub-product.jsp");
			rd.forward(req, resp);
		}
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

}
