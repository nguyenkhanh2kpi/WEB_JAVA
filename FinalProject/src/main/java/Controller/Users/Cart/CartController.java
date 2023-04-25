package Controller.Users.Cart;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.Cart;
import Model.CartItem;
import Model.Product;
import Model.User;
import Services.User.ICartServices;
import Services.User.IProductServices;
import Services.User.Impl.CartServicesImpl;
import Services.User.Impl.ProductServicesImpl;

@WebServlet(urlPatterns = {"/user/cart"})
public class CartController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
	ICartServices cartService = new CartServicesImpl();
	IProductServices productServices = new ProductServicesImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = req.getSession();
		User account = (User) session.getAttribute("account");
		if (account == null)
		{
			resp.sendRedirect(req.getContextPath() + "/login");
		}
		else {
			List<Cart> cartList = new ArrayList<Cart>();
			List<Cart> carts = cartService.findCartByUserId(account.getId());
			List<CartItem> cartItems = cartService.findAllCartItem();
			List<Product> products =  productServices.findAllProduct();
			for (Cart cart : carts){
				int i = 0; 
				for (CartItem cartitem : cartItems) {
					if (cartitem.getCartId() == cart.getId())
					{
						i++;
					}
				}
				if(i != 0 )
				{
					cartList.add(cart);
				}
			}
			req.setAttribute("cartList", cartList);
			req.setAttribute("cartItems", cartItems);
			req.setAttribute("products", products);
			RequestDispatcher rd = req.getRequestDispatcher("/view/user/cart/cart.jsp");
			rd.forward(req, resp);
		}
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}
