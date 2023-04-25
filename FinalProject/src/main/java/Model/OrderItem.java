package Model;

public class OrderItem {
	private int id;
	private int productId;
	private int orderId;
	private int count;
	private Product product;
	
	
	public OrderItem() {
	}


	public OrderItem(int id, int productId, int orderId, int count, Product product) {
		this.id = id;
		this.productId = productId;
		this.orderId = orderId;
		this.count = count;
		this.product = product;
	}


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


	public int getOrderId() {
		return orderId;
	}


	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}


	public int getCount() {
		return count;
	}


	public void setCount(int count) {
		this.count = count;
	}


	public Product getProduct() {
		return product;
	}


	public void setProduct(Product product) {
		this.product = product;
	}


	@Override
	public String toString() {
		return "OrderItem [id=" + id + ", productId=" + productId + ", orderId=" + orderId + ", count=" + count
				+ ", product=" + product + "]";
	}
	
}
