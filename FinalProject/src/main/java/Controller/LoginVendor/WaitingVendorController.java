package Controller.LoginVendor;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.User;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = {"/vendor/waiting"})
public class WaitingVendorController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		if (session != null && session.getAttribute("account") != null) {
			User u = (User) session.getAttribute("account");
			req.setAttribute("username", u.getSlug());
			if (u.getId_role() == 2) {
				resp.sendRedirect(req.getContextPath() + "/vendor/home?userId="+u.getId());
			}
		} else {
			resp.sendRedirect(req.getContextPath() + "/dangnhap");
		}
	}
	
}
