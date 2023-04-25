package Controller.Users.Product;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Review;
import Services.User.IProductServices;
import Services.User.IReviewServices;
import Services.User.Impl.ProductServicesImpl;
import Services.User.Impl.ReviewServicesImpl;

@WebServlet(urlPatterns = {"/user/detail"})
public class DetailProductController extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		IProductServices productsService = new ProductServicesImpl();
		IReviewServices reviewsService = new ReviewServicesImpl();
		req.setAttribute("detailProduct", productsService.getDetail(id));
		int pageReviewIndex = 1;
		pageReviewIndex = Integer.parseInt(req.getParameter("pageReviewIndex"));
		int pageReviewSize = 3;
		int maxPage =0;
		int totalRow = reviewsService.getCountReviewByProductId(id);
		if(totalRow != 0 ) {
			maxPage = totalRow / pageReviewSize + (totalRow % pageReviewSize > 0 ? 1 : 0);
			int nextPage = pageReviewIndex+1;
			int backPage = pageReviewIndex-1;
			List<Review> reviewList = reviewsService.getAllReviewPaggingByProductId(pageReviewIndex, pageReviewSize,id);
			req.setAttribute("reviewList", reviewList);
			req.setAttribute("maxPage", maxPage);
			req.setAttribute("nextPage", nextPage);
			req.setAttribute("backPage", backPage);
			req.setAttribute("pageIndex", pageReviewIndex);
			req.setAttribute("totalReview", totalRow);
		}
		RequestDispatcher rd = req.getRequestDispatcher("/view/user/product/detail-product.jsp");
		rd.forward(req, resp);
	}
}
