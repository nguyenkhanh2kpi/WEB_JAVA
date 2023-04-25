package Controller.Vendor;

import java.io.IOException;
import java.util.ArrayList;
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

import Model.Store;
import Model.Trasaction;
import Services.IStoreServices;
import Services.ITransactionServices;
import Services.Impl.StoreServicesImpl;
import Services.Impl.TransactionServicesImpl;


@WebServlet(urlPatterns = {"/vendor/transaction/add"})
public class AddTransactionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	IStoreServices storeServices = new StoreServicesImpl();
	ITransactionServices transactionServices = new TransactionServicesImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userId=  req.getParameter("userId");
		List<Store> stores = new ArrayList<Store>();
		stores = storeServices.findByUser(Integer.parseInt(userId));
		req.setAttribute("stores", stores);
		req.setAttribute("userId", userId);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/view/vendor/addTransaction.jsp");
		dispatcher.forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String value="";
		Boolean isup=false;
		Trasaction transaction = new Trasaction();
		DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
		ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
		servletFileUpload.setHeaderEncoding("UTF-8");
		try {
			response.setContentType("text/html");
			response.setCharacterEncoding("UTF-8");
			request.setCharacterEncoding("UTF-8");
			List<FileItem> items = servletFileUpload.parseRequest(request);
			for (FileItem item : items) {
				if (item.getFieldName().equals("userId")) {
					transaction.setUserId(Integer.parseInt(item.getString("UTF-8")));
				} 
				else if (item.getFieldName().equals("storeId")) {
					transaction.setStoreId(Integer.parseInt(item.getString("UTF-8")));
				} 
				else if (item.getFieldName().equals("isUp")) {
					value=item.getString("UTF-8");
					if(value.contains("true")) {
						isup=true;
					}
					transaction.setUp(isup);
				}
				else if (item.getFieldName().equals("amount")) {
					transaction.setAmount(Integer.parseInt(item.getString("UTF-8")));
				} 
			}
			transactionServices.CreateTransaction(transaction);
			response.sendRedirect(request.getContextPath() + "/vendor/transaction?userId="+transaction.getUserId());
		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		IStoreServices storeServices = new StoreServicesImpl();
		System.out.println(storeServices.findByUser(1));
	}

}
