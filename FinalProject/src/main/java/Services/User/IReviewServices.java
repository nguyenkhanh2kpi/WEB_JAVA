package Services.User;

import java.util.List;

import Model.Review;

public interface IReviewServices {
	void insert(Review review);
	List<Review> getAllReviewPaggingByProductId(int pageIndex, int pageSize,int productId);
	int getCountReviewByProductId(int productId);
}
