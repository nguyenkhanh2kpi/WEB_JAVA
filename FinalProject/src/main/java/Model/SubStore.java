package Model;

public class SubStore {
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public int getStoreId() {
		return storeId;
	}
	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	private int id;
	private String shopName;
	private int storeId;
	private int userId;
	public SubStore(int id, String shopName, int storeId, int userId) {
		super();
		this.id = id;
		this.shopName = shopName;
		this.storeId = storeId;
		this.userId = userId;
	}
	public SubStore() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
