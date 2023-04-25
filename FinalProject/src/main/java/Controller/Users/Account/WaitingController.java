package Controller.Users.Account;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.User;

@WebServlet(urlPatterns = "/user/waiting")

public class WaitingController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = req.getSession();
		if (session != null && session.getAttribute("account") != null) {
			User u = (User) session.getAttribute("account");
			req.setAttribute("username", u.getSlug());
			if (u.getId_role() == 1) {
				resp.sendRedirect(req.getContextPath() + "/user/home");
			} else if (u.getId_role() == 2) {
				resp.sendRedirect(req.getContextPath() + "/user/manager/home");
			} else if(u.getId_role() == 3) {
				resp.sendRedirect(req.getContextPath() + "/admin/home"); 
			} 
		} else {
			resp.sendRedirect(req.getContextPath() + "/login");
		}
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}
