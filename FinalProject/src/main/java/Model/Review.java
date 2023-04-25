package Model;

public class Review {
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getGuestName() {
		return guestName;
	}
	public void setGuestName(String guestName) {
		this.guestName = guestName;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDateReview() {
		return dateReview;
	}
	public void setDateReview(String dateReview) {
		this.dateReview = dateReview;
	}
	private int id;
	private int productId;
	private String guestName;
	private  int rating;
	private String review;
	private String email;
	private String dateReview;
	public Review() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Review(int id, int productId, String guestName, int rating, String review, String email, String dateReview) {
		super();
		this.id = id;
		this.productId = productId;
		this.guestName = guestName;
		this.rating = rating;
		this.review = review;
		this.email = email;
		this.dateReview = dateReview;
	}
}
