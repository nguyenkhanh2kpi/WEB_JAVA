package Services.User.Impl;

import java.util.List;

import DAO.User.IReviewDAO;
import DAO.User.UserDaoImpl.ReviewDAOImpl;
import Model.Review;
import Services.User.IReviewServices;


public class ReviewServicesImpl implements IReviewServices{
	IReviewDAO reviewsDAO = new ReviewDAOImpl();
	@Override
	public void insert(Review review) {
		// TODO Auto-generated method stub
		reviewsDAO.insert(review);
		return;
	}

	@Override
	public List<Review> getAllReviewPaggingByProductId(int pageIndex, int pageSize, int productId) {
		// TODO Auto-generated method stub
		return reviewsDAO.getAllReviewPaggingByProductId(pageIndex, pageSize, productId);
	}

	@Override
	public int getCountReviewByProductId(int productId) {
		// TODO Auto-generated method stub
		return reviewsDAO.getCountReviewByProductId(productId);
	}

}
