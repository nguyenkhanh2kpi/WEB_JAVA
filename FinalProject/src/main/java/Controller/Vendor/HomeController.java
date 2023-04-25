package Controller.Vendor;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.User;
import Services.IUserServicesVendor;
import Services.Impl.UserServicesVendorImpl;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = {"/vendor/home"})
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	IUserServicesVendor userServices = new UserServicesVendorImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userId=req.getParameter("userId");
		User user= new User();
		user = userServices.findById(Integer.parseInt(userId));
		req.setAttribute("user", user);
		RequestDispatcher rq = req.getRequestDispatcher("/view/vendor/index.jsp");
		rq.forward(req, resp);
	}
	
	public static void main(String[] args) {
		IUserServicesVendor userServices = new UserServicesVendorImpl();
		System.out.println(userServices.findById(1));
	}
}
