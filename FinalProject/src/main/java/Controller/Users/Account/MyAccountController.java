package Controller.Users.Account;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.User;

@WebServlet(urlPatterns = {"/user/myaccount"})
public class MyAccountController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = req.getSession(false);
		User user = (User) session.getAttribute("account");
		req.setAttribute("user", user);
		RequestDispatcher rd = req.getRequestDispatcher("/view/user/useraccount/manageAccount.jsp");
		rd.forward(req, resp);
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

}
