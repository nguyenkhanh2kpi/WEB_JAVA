package Model;

public class CartItem {
	  private int id;
	  private int cartId;
	  private int productId ;
	  private int count ;
	public CartItem() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CartItem(int id, int cartId, int productId, int count) {

		this.id = id;
		this.cartId = cartId;
		this.productId = productId;
		this.count = count;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return "CartItem [id=" + id + ", cartId=" + cartId + ", productId=" + productId + ", count=" + count + "]";
	}
	  
}
