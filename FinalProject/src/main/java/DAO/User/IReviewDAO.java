package DAO.User;

import java.util.List;

import Model.Review;

public interface IReviewDAO {
	void insert(Review review);
	List<Review> getAllReviewPaggingByProductId(int pageIndex, int pageSize,int productId);
	int getCountReviewByProductId(int productId);
}
