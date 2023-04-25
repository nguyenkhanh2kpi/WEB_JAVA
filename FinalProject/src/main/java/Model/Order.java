package Model;

import java.sql.Date;

public class Order {
	  private int id;
	  private int userId;
	  private int deliveryId;
	  private int StoreId;
	  private int commissionId;
	  private String address;
	  private String phone;
	  private String status;
	  private boolean isPaidBefore;
	  private float amountFromUser;
	  private float amountFromStore;
	  private float amountToStore ;
	  private float amountToGD ;
	  private Date createdAt ;
	  private Date updatedAt ;
	public Order() {

	}
	public Order(int id, int userId, int deliveryId, int storeId, int commissionId, String address, String phone,
			String status, boolean isPaidBefore, float amountFromUser, float amountFromStore, float amountToStore,
			float amountToGD, Date createdAt, Date updatedAt) {
		this.id = id;
		this.userId = userId;
		this.deliveryId = deliveryId;
		StoreId = storeId;
		this.commissionId = commissionId;
		this.address = address;
		this.phone = phone;
		this.status = status;
		this.isPaidBefore = isPaidBefore;
		this.amountFromUser = amountFromUser;
		this.amountFromStore = amountFromStore;
		this.amountToStore = amountToStore;
		this.amountToGD = amountToGD;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
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
	public int getDeliveryId() {
		return deliveryId;
	}
	public void setDeliveryId(int deliveryId) {
		this.deliveryId = deliveryId;
	}
	public int getStoreId() {
		return StoreId;
	}
	public void setStoreId(int storeId) {
		StoreId = storeId;
	}
	public int getCommissionId() {
		return commissionId;
	}
	public void setCommissionId(int commissionId) {
		this.commissionId = commissionId;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public boolean isPaidBefore() {
		return isPaidBefore;
	}
	public void setPaidBefore(boolean isPaidBefore) {
		this.isPaidBefore = isPaidBefore;
	}
	public float getAmountFromUser() {
		return amountFromUser;
	}
	public void setAmountFromUser(float amountFromUser) {
		this.amountFromUser = amountFromUser;
	}
	public float getAmountFromStore() {
		return amountFromStore;
	}
	public void setAmountFromStore(float amountFromStore) {
		this.amountFromStore = amountFromStore;
	}
	public float getAmountToStore() {
		return amountToStore;
	}
	public void setAmountToStore(float amountToStore) {
		this.amountToStore = amountToStore;
	}
	public float getAmountToGD() {
		return amountToGD;
	}
	public void setAmountToGD(float amountToGD) {
		this.amountToGD = amountToGD;
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
		return "Order [id=" + id + ", userId=" + userId + ", deliveryId=" + deliveryId + ", StoreId=" + StoreId
				+ ", commissionId=" + commissionId + ", address=" + address + ", phone=" + phone + ", status=" + status
				+ ", isPaidBefore=" + isPaidBefore + ", amountFromUser=" + amountFromUser + ", amountFromStore="
				+ amountFromStore + ", amountToStore=" + amountToStore + ", amountToGD=" + amountToGD + ", createdAt="
				+ createdAt + ", updatedAt=" + updatedAt + "]";
	}
	 
	  
}
