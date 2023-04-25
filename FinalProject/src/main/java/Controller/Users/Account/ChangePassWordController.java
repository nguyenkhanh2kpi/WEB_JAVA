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
import Services.User.Impl.UserServicesImpl;


@WebServlet(urlPatterns = {"/user/changePass"})
public class ChangePassWordController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("/view/user/useraccount/manageAccount.jsp");
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		String password = req.getParameter("password");
		UserServicesImpl service = new UserServicesImpl();
		HttpSession session = req.getSession(false);
		User account = (User) session.getAttribute("account");
		service.updatepPass(password, account.getFull_name());
		resp.sendRedirect(req.getContextPath() + "/user/myaccount");
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
}
