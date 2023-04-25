package Model;

public class Delivery {
	  private int id;
	  private String name;
	  private String description;
	  private int price ;
	  private boolean isDeleted;
	public Delivery() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Delivery(int id, String name, String description, int price, boolean isDeleted) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.isDeleted = isDeleted;
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
	public boolean isDeleted() {
		return isDeleted;
	}
	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}
	@Override
	public String toString() {
		return "Delivery [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price
				+ ", isDeleted=" + isDeleted + "]";
	}
	  
}
