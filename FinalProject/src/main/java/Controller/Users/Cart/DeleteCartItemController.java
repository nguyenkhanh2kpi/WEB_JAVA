package Controller.Users.Cart;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Services.User.ICartServices;
import Services.User.IProductServices;
import Services.User.Impl.CartServicesImpl;
import Services.User.Impl.ProductServicesImpl;


@WebServlet(urlPatterns = {"/user/delete"})
public class DeleteCartItemController extends HttpServlet {
	ICartServices cartService = new CartServicesImpl();
	IProductServices productServices = new ProductServicesImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int cartId= Integer.parseInt(req.getParameter("cartId"));
		int productId= Integer.parseInt(req.getParameter("productId"));
		cartService.delete(cartId,productId);
		resp.sendRedirect(req.getContextPath() + "/user/cart");
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
