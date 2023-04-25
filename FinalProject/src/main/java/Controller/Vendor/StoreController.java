package Controller.Vendor;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Store;
import Services.IStoreServices;
import Services.Impl.StoreServicesImpl;


@WebServlet(urlPatterns = {"/vendor/store"})
public class StoreController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	IStoreServices storeServices = new StoreServicesImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userId= req.getParameter("userId");
		RequestDispatcher rq = req.getRequestDispatcher("/view/vendor/store.jsp");
		List<Store> stores = storeServices.findByUser(Integer.parseInt(userId));
		req.setAttribute("stores", stores);
		rq.forward(req, resp);
	}
	
	public static void main(String[] args) {
		IStoreServices storeServices = new StoreServicesImpl();
		System.out.println(storeServices.finALL().toString());
	}
}
