package Controller.Users.Guest;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Services.User.IProductServices;
import Services.User.IUserServices;
import Services.User.Impl.ProductServicesImpl;
import Services.User.Impl.UserServicesImpl;


@WebServlet(urlPatterns = {"/user/home"})
public class HomeController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	IUserServices productService = new UserServicesImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		IProductServices productsService = new ProductServicesImpl();
		req.setAttribute("hotproducts", productsService.findHotProduct());
		req.setAttribute("Bestproducts", productsService.findBestSellerProduct());
		req.setAttribute("categories", productsService.findAllCategory());
		RequestDispatcher rd = req.getRequestDispatcher("/view/user/home.jsp");
		rd.forward(req, resp);
	}
}
