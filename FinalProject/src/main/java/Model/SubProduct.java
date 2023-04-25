package Model;

public class SubProduct {
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	private int id;
	private String productName;
	private int productId;
	private int userId;
	public SubProduct(int id, String productName, int productId, int userId) {
		super();
		this.id = id;
		this.productName = productName;
		this.productId = productId;
		this.userId = userId;
	}
	public SubProduct() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
