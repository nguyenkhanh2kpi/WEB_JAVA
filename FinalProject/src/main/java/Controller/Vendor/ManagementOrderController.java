package Controller.Vendor;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Order;
import Services.IOrderServices;
import Services.Impl.OrderServicesImpl;


@WebServlet(urlPatterns = {"/vendor/order/manage"})
public class ManagementOrderController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	IOrderServices orderServices = new OrderServicesImpl();
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	String id = request.getParameter("storeId");
	String status = request.getParameter("status");
	List<Order> orders = orderServices.findByStoreWithStatus(Integer.parseInt(id),status.toString()); 
	request.setAttribute("orders", orders);
	request.setAttribute("storeId", id);
	RequestDispatcher dispatcher=request.getRequestDispatcher("/view/vendor/orderByStore.jsp");
	dispatcher.forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
}
