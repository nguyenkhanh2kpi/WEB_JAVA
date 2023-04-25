package Controller.Vendor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Model.Product;
import Services.IFindProductServices;
import Services.Impl.FindProductServices;


@WebServlet(urlPatterns = {"/vendor/search"})
public class SearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	IFindProductServices findProductServices= new FindProductServices();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Product> products = new ArrayList<Product>();
		String kewWord= req.getParameter("keyWord");
		products = findProductServices.findByName(kewWord);
		req.setAttribute("products", products);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/view/vendor/searchList.jsp");
		dispatcher.forward(req, resp);
	}
	
	public static void main(String[] args) {
		
	}
	
}
