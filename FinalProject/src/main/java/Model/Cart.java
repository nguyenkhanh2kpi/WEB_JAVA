package Model;

public class Cart {
	  private int id;
	  private int userId;
	  private int StoreId;
	public Cart() {

	}
	public Cart(int id, int userId, int storeId) {

		this.id = id;
		this.userId = userId;
		StoreId = storeId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getStoreId() {
		return StoreId;
	}
	public void setStoreId(int storeId) {
		StoreId = storeId;
	}
	@Override
	public String toString() {
		return "Cart [id=" + id + ", userId=" + userId + ", StoreId=" + StoreId + "]";
	}
	
	  
}
