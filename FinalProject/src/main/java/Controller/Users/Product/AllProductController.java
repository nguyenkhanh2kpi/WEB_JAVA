package Controller.Users.Product;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Product;
import Services.User.IProductServices;
import Services.User.Impl.ProductServicesImpl;

@WebServlet(urlPatterns = {"/user/allproduct"})
public class AllProductController extends HttpServlet{
	IProductServices productsService = new ProductServicesImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		req.setAttribute("categories", productsService.findAllCategory());
		int pageIndex = 1;
		pageIndex = Integer.parseInt(req.getParameter("pageIndex"));
		int pageSize = 3;
		int maxPage =0;
		int totalRow = productsService.getCountTotalProducts();
		if(totalRow != 0 ) {
			maxPage = totalRow / pageSize + (totalRow % pageSize > 0 ? 1 : 0);
			int nextPage = pageIndex+1;
			int backPage = pageIndex-1;
			List<Product> productList = productsService.getAllProductPagging(pageIndex, pageSize);
			req.setAttribute("productList", productList);
			req.setAttribute("maxPage", maxPage);
			req.setAttribute("nextPage", nextPage);
			req.setAttribute("backPage", backPage);
			req.setAttribute("pageIndex", pageIndex);
		}
		RequestDispatcher rd = req.getRequestDispatcher("/view/user/product/allproduct.jsp");
		rd.forward(req, resp);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

}
