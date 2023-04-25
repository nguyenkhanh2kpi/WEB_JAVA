package Controller.Admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import Model.User;
import Services.IUserServices;
import Services.Impl.UserServices;

@SuppressWarnings("serial")
@WebServlet("/admin/home")
public class HomeControllerAdmin extends HttpServlet {

	IUserServices userService = new UserServices();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		HttpSession session = req.getSession();
		User obj = (User) session.getAttribute("account");
		if (obj == null) {
			resp.sendRedirect(req.getContextPath() + "/login");
		} else {
			User userLogged = userService.findById(obj.getId());
			req.setAttribute("userLogged", userLogged);
			req.setAttribute("user-wellcome", userLogged.getFull_name());
			req.setAttribute("roleList", userService.findAllRole());
			req.getRequestDispatcher("/view/admin/home.jsp").include(req, resp);
		}

	}
}
