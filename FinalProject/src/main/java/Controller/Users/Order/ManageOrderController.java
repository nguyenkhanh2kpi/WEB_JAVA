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

import Model.Order;
import Model.OrderItem;
import Model.User;
import Services.User.IOderServices;
import Services.User.Impl.OderServicesImpl;

@WebServlet(urlPatterns = {"/user/manageorder"})
public class ManageOrderController extends HttpServlet{
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
		else
		{
			List<Order> newOrders = new ArrayList<Order>();
			List<OrderItem> newOrderItems = new ArrayList<OrderItem>();	
			List<Order> orders  = orderServices.getAllOrderByUser(account.getId());
			for(Order order: orders)
			{
				List<OrderItem> orderitems = orderServices.getAllOrderItemByOrderId(order.getId());
				if(orderitems != null)
				{
					newOrderItems.addAll(orderitems);
					newOrders.add(order);
				}
			}
			req.setAttribute("newOrderItems", newOrderItems);
			req.setAttribute("newOrders", newOrders);
			RequestDispatcher rd = req.getRequestDispatcher("/view/user/order/manageOrder.jsp");
			rd.forward(req, resp);
		}

	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

}
