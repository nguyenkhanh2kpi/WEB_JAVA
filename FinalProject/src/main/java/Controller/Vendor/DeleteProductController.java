package Controller.Vendor;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.User;
import Services.IProductServices;
import Services.Impl.ProductServicesImpl;


@WebServlet(urlPatterns = {"/vendor/product/delete"})
public class DeleteProductController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	IProductServices productServices = new ProductServicesImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	String id = req.getParameter("id");
    	productServices.Delete(Integer.parseInt(id));
		HttpSession session = req.getSession();
		User u = (User) session.getAttribute("account");
    	resp.sendRedirect(req.getContextPath() + "/vendor/product?storeId="+u.getId());
	}
}
