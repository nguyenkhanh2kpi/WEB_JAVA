package Model;

import java.sql.Date;
import java.util.Calendar;

public class Income {
	private int storeId;
	private int orderUserId;
	private int orderId;
	private long income;
	private Date dateComplete;
	public Income() {
	}
	public Income(int storeId, int orderUserId, int orderId, long income, Date dateComplete) {
		super();
		this.storeId = storeId;
		this.orderUserId = orderUserId;
		this.orderId = orderId;
		this.income = income;
		this.dateComplete = dateComplete;
	}
	public int getStoreId() {
		return storeId;
	}
	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}
	public int getOrderUserId() {
		return orderUserId;
	}
	public void setOrderUserId(int orderUserId) {
		this.orderUserId = orderUserId;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public long getIncome() {
		return income;
	}
	public void setIncome(long income) {
		this.income = income;
	}
	public Date getDateComplete() {
		return dateComplete;
	}
	public void setDateComplete(Date dateComplete) {
		this.dateComplete = dateComplete;
	}
	
	@Override
	public String toString() {
		return "Income [storeId=" + storeId + ", orderUserId=" + orderUserId + ", orderId=" + orderId + ", income="
				+ income + ", dateComplete=" + dateComplete + "]";
	}
}
