package Model;

public class Product {
	  private int id ;
	  private String name;
	  private String slug ;
	  private String description;
	  private int price;
	  private int quantity ;
	  private int sold;
	  private boolean isActive ;
	  private String images ;
	  private int categoryId ;
	  private String categoryName;
	  private int storeId ;
	  private String storeName;
	public Product() {

	}
	public Product(int id, String name, String slug, String description, int price, int quantity, int sold,
			boolean isActive, String images, int categoryId, int storeId) {
		super();
		this.id = id;
		this.name = name;
		this.slug = slug;
		this.description = description;
		this.price = price;
		this.quantity = quantity;
		this.sold = sold;
		this.isActive = isActive;
		this.images = images;
		this.categoryId = categoryId;
		this.storeId = storeId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSlug() {
		return slug;
	}
	public void setSlug(String slug) {
		this.slug = slug;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getSold() {
		return sold;
	}
	public void setSold(int sold) {
		this.sold = sold;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public String getImages() {
		return images;
	}
	public void setImages(String images) {
		this.images = images;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public int getStoreId() {
		return storeId;
	}
	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}
	
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getStoreName() {
		return storeName;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", slug=" + slug + ", description=" + description + ", price="
				+ price + ", quantity=" + quantity + ", sold=" + sold + ", isActive=" + isActive + ", images=" + images
				+ ", categoryId=" + categoryId + ", storeId=" + storeId + "]";
	}
	  
	  

}
