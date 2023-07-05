package model;

import java.sql.Date;
import java.util.List;

public class Order {
	private int orderId;
	private String userMail;
	private int status;
	private Date orderDate;
	private String discountCode;
	private String address;
	private List<OrderDedtail> lstOrderDetail;
	
	public Order() {
	}

	public Order(int orderId, String userMail, int status, Date orderDate, String discountCode, String address,
			List<OrderDedtail> lstOrderDetail) {
		this.orderId = orderId;
		this.userMail = userMail;
		this.status = status;
		this.orderDate = orderDate;
		this.discountCode = discountCode;
		this.address = address;
		this.lstOrderDetail = lstOrderDetail;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getUserMail() {
		return userMail;
	}

	public void setUserMail(String userMail) {
		this.userMail = userMail;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getDiscountCode() {
		return discountCode;
	}

	public void setDiscountCode(String discountCode) {
		this.discountCode = discountCode;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<OrderDedtail> getLstOrderDetail() {
		return lstOrderDetail;
	}

	public void setLstOrderDetail(List<OrderDedtail> lstOrderDetail) {
		this.lstOrderDetail = lstOrderDetail;
	}
	
	
}
