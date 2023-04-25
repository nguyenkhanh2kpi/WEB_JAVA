package Controller.Users.Account;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.Location;
import Model.User;
import Services.User.Impl.UserServicesImpl;

@WebServlet(urlPatterns = {"/user/myLocation"})
public class MyLocationController extends HttpServlet{
	UserServicesImpl service = new UserServicesImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher rd = req.getRequestDispatcher("/view/user/useraccount/locationManager.jsp");
		List<Location> locations = service.findAllLocation();
		req.setAttribute("locations", locations);
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		String location = req.getParameter("location");
		HttpSession session = req.getSession(false);
		User account = (User) session.getAttribute("account");
		service.insertLocation(account.getSlug(),location);
		resp.sendRedirect(req.getContextPath() + "/user/myaccount");
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
}
