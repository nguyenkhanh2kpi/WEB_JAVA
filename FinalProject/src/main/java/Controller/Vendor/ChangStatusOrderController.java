package Controller.Vendor;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Services.IOrderServices;
import Services.Impl.OrderServicesImpl;


@WebServlet(urlPatterns = {"/vendor/order/changeST"})
public class ChangStatusOrderController extends HttpServlet {
	IOrderServices orderServices = new OrderServicesImpl();
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String orderId= req.getParameter("orderId");
		String status = req.getParameter("status");
		orderServices.changOrderStatus(Integer.parseInt(orderId), status);
		orderServices.Delivered(Integer.parseInt(orderId), status.toString());
		RequestDispatcher dispatcher = req.getRequestDispatcher("/view/vendor/changedStatus.jsp");
		dispatcher.forward(req, resp);
	}
}
/// khong hoat dong, khong dung