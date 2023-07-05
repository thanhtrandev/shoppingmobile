package model;

public class OrderDedtail {
	private int orderDetail;
	private int productId;
	private int amount;
	private double price;
	
	public OrderDedtail() {
	}

	public OrderDedtail(int orderDetail, int productId, int amount, double price) {
		this.orderDetail = orderDetail;
		this.productId = productId;
		this.amount = amount;
		this.price = price;
	}

	public int getOrderDetail() {
		return orderDetail;
	}

	public void setOrderDetail(int orderDetail) {
		this.orderDetail = orderDetail;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	
}
