package Controller.Users.Order;

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
import Model.Order;
import Model.OrderItem;
import Model.Product;
import Model.User;
import Services.User.ICartServices;
import Services.User.IOderServices;
import Services.User.IProductServices;
import Services.User.Impl.CartServicesImpl;
import Services.User.Impl.OderServicesImpl;
import Services.User.Impl.ProductServicesImpl;

@WebServlet(urlPatterns = {"/user/checkout"})
public class CheckOutController extends HttpServlet{
	ICartServices cartService = new CartServicesImpl();
	IProductServices productServices = new ProductServicesImpl();
	IOderServices orderServices = new OderServicesImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = req.getSession();
		User account = (User) session.getAttribute("account");
		if (account == null)
		{
			resp.sendRedirect(req.getContextPath() + "/login");
		}
		List<Cart> cartList = new ArrayList<Cart>();
		List<Cart> carts = cartService.findCartByUserId(account.getId());
		List<CartItem> cartItems = cartService.findAllCartItem();
		List<Product> products =  productServices.findAllProduct();
		int i = 0;
		for (Cart cart : carts){
			List<CartItem> cartItems1 = cartService.findCartItembyCartId(cart.getId());
			if(cartItems1 != null)
				cartList.add(cart);
				i++;
		}
		if(i==0)
		{
			resp.sendRedirect(req.getContextPath() + "/user/home");
		}
		User user = (User) session.getAttribute("account");
		req.setAttribute("shipcost", orderServices.getDelivery(1).getPrice());
		req.setAttribute("user", user);
		req.setAttribute("cartList", cartList);
		req.setAttribute("cartItems", cartItems);
		req.setAttribute("products", products);
		
		RequestDispatcher rd = req.getRequestDispatcher("/view/user/order/checkout.jsp");
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = req.getSession();
		User account = (User) session.getAttribute("account");
		if (account == null)
		{
			resp.sendRedirect(req.getContextPath() + "/login");
		}
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		String address = req.getParameter("address");
		String phone = req.getParameter("phone");
		Float total = Float.parseFloat(req.getParameter("total"));
		List<Cart> carts = cartService.findCartByUserId(account.getId());
		try {
			for (Cart cart : carts){
				List<CartItem> cartItems = cartService.findCartItembyCartId(cart.getId());
				if(cartItems != null)
				{
					Order order = new Order();
					order.setAddress(address);
					order.setPhone(phone);
					order.setUserId(account.getId());
					order.setDeliveryId(orderServices.getDelivery(1).getId());
					order.setStoreId(cart.getStoreId());
					order.setStatus("wait_confirmation");
					order.setAmountToStore(total);
					orderServices.insert(order);
					Order newOrder = orderServices.getOrderById(account.getId(), cart.getStoreId());
					for(CartItem cartItem : cartItems)
					{
						OrderItem orderItem = new OrderItem(1,cartItem.getProductId(),newOrder.getId(),cartItem.getCount(),null);
						orderServices.insertOrderItem(orderItem);
						cartService.delete(cart.getId(),cartItem.getProductId());
						 
					}
				}
			}
			resp.sendRedirect(req.getContextPath() + "/user/home");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
