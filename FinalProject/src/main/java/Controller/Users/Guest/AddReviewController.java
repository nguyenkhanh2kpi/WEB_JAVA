package Controller.Users.Guest;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Review;
import Services.User.IReviewServices;
import Services.User.Impl.ReviewServicesImpl;

@WebServlet(urlPatterns = {"/user/addreview"})
public class AddReviewController extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		int productId = Integer.parseInt(req.getParameter("productId"));
		int rating = Integer.parseInt(req.getParameter("rating"));
		String review = req.getParameter("review");
		String guestName = req.getParameter("guestName");
		String email = req.getParameter("email");
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd"); 
		Date date = new Date();  
		IReviewServices reviewService = new ReviewServicesImpl();
		Review reviews = new Review(1,productId,guestName,rating,review,email,formatter.format(date));
		try {
			reviewService.insert(reviews);
			resp.sendRedirect(req.getContextPath() + "/user/home");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
