package model;

public class Product {
	private int productId;
	private String productName;
	private String description;
	private double price;
	private String imgSource;
	private String productType;
	private String productBrand;
	private int number;
	
	public Product() {
	}
	
	public Product(int productId, String productName, String description, double price, String imgSource,
			String productType, String productBrand, int number) {
		this.productId = productId;
		this.productName = productName;
		this.description = description;
		this.price = price;
		this.imgSource = imgSource;
		this.productType = productType;
		this.productBrand = productBrand;
		this.number = number;
	}
	
	public Product(int productId, String productName, String description, double price, String imgSource,
			String productType, String productBrand) {
		this.productId = productId;
		this.productName = productName;
		this.description = description;
		this.price = price;
		this.imgSource = imgSource;
		this.productType = productType;
		this.productBrand = productBrand;
		this.number = number;
	}

	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getImgSource() {
		return imgSource;
	}
	public void setImgSource(String imgSource) {
		this.imgSource = imgSource;
	}
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	public String getProductBrand() {
		return productBrand;
	}
	public void setProductBrand(String productBrand) {
		this.productBrand = productBrand;
	}
	
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
}
