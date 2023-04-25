package Controller.Vendor;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.User;
import Services.IStoreServices;
import Services.Impl.StoreServicesImpl;

@WebServlet(urlPatterns = {"/vendor/store/delete"})
public class DeleteStoreController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	IStoreServices storeServices = new StoreServicesImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	String id = req.getParameter("StoreId");
    	storeServices.Delete(Integer.parseInt(id));
    	HttpSession session = req.getSession();
    	User u = (User) session.getAttribute("account");
    	resp.sendRedirect(req.getContextPath() + "/vendor/store?userId="+u.getId());
	}
	

}
