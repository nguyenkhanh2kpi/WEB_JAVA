package Controller.Users.Cart;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.Cart;
import Model.CartItem;
import Model.User;
import Services.User.ICartServices;
import Services.User.IProductServices;
import Services.User.Impl.CartServicesImpl;
import Services.User.Impl.ProductServicesImpl;


@WebServlet(urlPatterns = {"/user/addItem"})
public class AddCartItemController  extends HttpServlet{
	ICartServices cartService = new CartServicesImpl();
	IProductServices productServices = new ProductServicesImpl();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		int quantity = Integer.parseInt(req.getParameter("quantity"));
		int storeId = Integer.parseInt(req.getParameter("storeId"));
		int productId = Integer.parseInt(req.getParameter("productId"));
		HttpSession session = req.getSession();
		User account = (User) session.getAttribute("account");
		if (account == null)
		{
			resp.sendRedirect(req.getContextPath() + "/login");
		}
		else
		{
			try {
				Cart cart = cartService.getCart(account.getId(), storeId);
				CartItem item = new CartItem(1,cart.getId(),productId,quantity);
				if(cartService.checkItemInCart(item) == null)
				{
					try {
						cartService.insertItem(item);
						resp.sendRedirect(req.getContextPath() + "/user/cart");
					}catch (Exception e) {
						e.printStackTrace();
					}
				}
				else
				{
					try {
						item.setCount(cartService.checkItemInCart(item).getCount()+ quantity);
						cartService.updateQuantity(item);
						resp.sendRedirect(req.getContextPath() + "/user/cart");
					}catch (Exception e) {
						e.printStackTrace();
					}
				}
			}catch (Exception e) {
				Cart cart = new Cart(1,account.getId(),storeId);
				cartService.insert(cart);
				cart = cartService.getCart(account.getId(), storeId);
				CartItem item = new CartItem(1,cart.getId(),productId,quantity);
				if(cartService.checkItemInCart(item) == null)
				{
					try {
						cartService.insertItem(item);
						resp.sendRedirect(req.getContextPath() + "/user/cart");
					}catch (Exception e1) {
						e1.printStackTrace();
					}
				}
				else
				{
					try {
						item.setCount(cartService.checkItemInCart(item).getCount()+ quantity);
						cartService.updateQuantity(item);
						resp.sendRedirect(req.getContextPath() + "/user/cart");
					}catch (Exception e1) {
						e1.printStackTrace();
					}
				}
			}
		}
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
