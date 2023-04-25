package Controller.Users.Cart;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.User;
import Services.User.IShopServices;
import Services.User.Impl.ShopServicesImpl;

@WebServlet(urlPatterns = {"/user/sub-shop"})
public class SubStoreController extends HttpServlet{
	IShopServices shopServices = new ShopServicesImpl();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		int storeId = Integer.parseInt(req.getParameter("storeId"));
		String storeName = req.getParameter("storeName");
		HttpSession session = req.getSession();
		User account = (User) session.getAttribute("account");
		if (account == null)
		{
			resp.sendRedirect(req.getContextPath() + "/login");
		}
		else
		{
			try {
				shopServices.subscribe(storeName, storeId, account.getId());
				resp.sendRedirect(req.getContextPath() + "/user/subscribe");
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

}
