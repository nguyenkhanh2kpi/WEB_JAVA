package DAO.User.UserDaoImpl;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Connection.Connection;
import DAO.User.IReviewDAO;
import Model.Review;

public class ReviewDAOImpl extends Connection implements IReviewDAO{

	@Override
	public void insert(Review review) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO Review(productId, guestName, rating, review, email, dateReview) "
				+ "VALUES (?,?,?,?,?,?)";
		try {
			java.sql.Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, review.getProductId());
			ps.setString(2, review.getGuestName());
			ps.setInt(3, review.getRating());
			ps.setString(4, review.getReview());
			ps.setString(5, review.getEmail());
			ps.setString(6, review.getDateReview());
			ps.executeUpdate();
			} 
		catch (Exception e) {
			e.printStackTrace();}
		
	}

	@Override
	public List<Review> getAllReviewPaggingByProductId(int pageIndex, int pageSize, int productId) {
		// TODO Auto-generated method stub
		List<Review> reviews = new ArrayList<Review>();
		String sql = "SELECT * from \r\n"
				+ "(SELECT ROW_NUMBER() OVER (ORDER BY id) AS RN,  * FROM Review Where productId=?) AS X \r\n"
				+ "WHERE RN BETWEEN (?-1)*? +1 AND ? * ?";
		try {
			java.sql.Connection conn = super.getConnection();
			PreparedStatement ps  = conn.prepareStatement(sql);
			ps.setInt(1, productId);
			ps.setInt(2, pageIndex);
			ps.setInt(3, pageSize);
			ps.setInt(4, pageIndex);
			ps.setInt(5, pageSize);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Review review = new Review();
				review.setId(rs.getInt("id"));
				review.setProductId(rs.getInt("productId"));
				review.setGuestName(rs.getString("guestName"));
				review.setRating(rs.getInt("rating"));
				review.setReview(rs.getString("review"));
				review.setEmail(rs.getString("email"));
				review.setDateReview(rs.getString("dateReview"));
				reviews.add(review);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return reviews;
	}

	@Override
	public int getCountReviewByProductId(int productId) {
		// TODO Auto-generated method stub
		String sql = "SELECT COUNT(id) FROM Review where productId=?";
		try {
			int count = 0;
			java.sql.Connection conn = super.getConnection();
			PreparedStatement ps  = conn.prepareStatement(sql);
			ps.setInt(1, productId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				count = rs.getInt(1);
			}
			return count;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
}
