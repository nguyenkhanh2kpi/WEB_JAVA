package Controller.Admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = "/logout")
public class LogoutAdminController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Cookie cookie = null;
		Cookie[] cookies = null;
		// Get an array of Cookies associated with this domain
		cookies = req.getCookies();
		// Set response content type
		resp.setContentType("text/html");
		if (cookies != null) {
			for (int i = 0; i < cookies.length; i++) {
				cookie = cookies[i];
				if ((cookie.getName()).compareTo("username") == 0) {
					// delete cookie
					cookie.setMaxAge(0);
					resp.addCookie(cookie);
				}
			}
		}
		HttpSession session = req.getSession();
		if(session!=null)
			session.invalidate();
		resp.sendRedirect(req.getContextPath() + "/user/waiting");
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


}
