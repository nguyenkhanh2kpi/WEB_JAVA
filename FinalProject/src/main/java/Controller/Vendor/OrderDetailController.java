package Controller.Vendor;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import Model.Order;
import Model.OrderItem;
import Services.IOrderItemServices;
import Services.IOrderServices;
import Services.Impl.OrderItemServicesImpl;
import Services.Impl.OrderServicesImpl;
import Utils.Constant;


@WebServlet(urlPatterns = {"/vendor/order/orderDetail"})
public class OrderDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	IOrderItemServices orderItemServices = new OrderItemServicesImpl();
	IOrderServices orderServices = new OrderServicesImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String orderId =  req.getParameter("orderId");
		Order order= new Order();
		order= orderServices.findById(Integer.parseInt(orderId));
		List<OrderItem> orderItems = orderItemServices.findByOrderId(Integer.parseInt(orderId));
		req.setAttribute("orderItems", orderItems);
		req.setAttribute("order", order);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/view/vendor/orderDetail.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int orderId=0;
		String status=""; 
		DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
		ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
		servletFileUpload.setHeaderEncoding("UTF-8");
		try {
			response.setContentType("text/html");
			response.setCharacterEncoding("UTF-8");
			request.setCharacterEncoding("UTF-8");
			List<FileItem> items = servletFileUpload.parseRequest(request);
			for (FileItem item : items) {
				if (item.getFieldName().equals("statusOrder")) {
					status = item.getString("UTF-8");
				} 
				else if(item.getFieldName().equals("orderId")) {
					orderId = Integer.parseInt(item.getString("UTF-8"));
				}
			}
			orderServices.changOrderStatus(orderId, status);
			orderServices.Delivered(orderId, status);
			
			response.sendRedirect(request.getContextPath() + "/dangnhap");
		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
