package Model;

import java.sql.Date;

public class User {
	   private int id ;
	   private int id_role;
	   private String full_name;
	   private String slug;
	   private String id_card; 
	   private String phone;
	   private String password; 
	   private String avatar; 
	   private int point; 
	   private boolean isActive;
	   private Date createdAt;
	   private Date updatedAt;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getId_role() {
		return id_role;
	}
	public void setId_role(int id_role) {
		this.id_role = id_role;
	}
	public String getFull_name() {
		return full_name;
	}
	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}
	public String getSlug() {
		return slug;
	}
	public void setSlug(String slug) {
		this.slug = slug;
	}
	public String getId_card() {
		return id_card;
	}
	public void setId_card(String id_card) {
		this.id_card = id_card;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", id_role=" + id_role + ", full_name=" + full_name + ", slug=" + slug + ", id_card="
				+ id_card + ", phone=" + phone + ", password=" + password + ", avatar=" + avatar + ", point=" + point
				+ ", isActive=" + isActive + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
	}
	public User(int id, int id_role, String full_name, String slug, String id_card, String phone, String password,
			String avatar, int point, boolean isActive, Date createdAt, Date updatedAt) {
		super();
		this.id = id;
		this.id_role = id_role;
		this.full_name = full_name;
		this.slug = slug;
		this.id_card = id_card;
		this.phone = phone;
		this.password = password;
		this.avatar = avatar;
		this.point = point;
		this.isActive = isActive;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	   
	   
}
