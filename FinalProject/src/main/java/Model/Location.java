package Model;

public class Location {
	  public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDiaChi() {
		return DiaChi;
	}
	public void setDiaChi(String diaChi) {
		DiaChi = diaChi;
	}
	public String getSlug() {
		return slug;
	}
	public void setSlug(String slug) {
		this.slug = slug;
	}
	private int id;
	  private String DiaChi;
	  private String slug;
	public Location() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Location(int id, String diaChi, String slug) {
		super();
		this.id = id;
		DiaChi = diaChi;
		this.slug = slug;
	}
}
