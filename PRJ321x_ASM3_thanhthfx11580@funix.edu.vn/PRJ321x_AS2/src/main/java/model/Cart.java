package model;

import java.util.List;

public class Cart {
	private List<Product> items;
	public Cart() {
	}

	public Cart(List<Product> items) {
		this.items = items;
	}

	public void add(Product ci) {
		for (Product product : items) {
			if (ci.getProductId() == product.getProductId()) {
				product.setNumber(product.getNumber() + 1);
				return;
			}
		}
		items.add(ci);
	}
	
	public void minus(Product ci) {
		for (Product product : items) {
			if (ci.getProductId() == product.getProductId()) {
				if(product.getNumber() > 1) {
					product.setNumber(product.getNumber() - 1);
				}else {
					items.remove(product);
				}
				return;
			}
		}
	}

	public void remove(int id) {
		for (Product product : items) {
			if (product.getProductId() == id) {
				items.remove(product);
				return;
			}
		}
	}

	public double getAmount() {
		double s = 0;
		for (Product product : items) {
			s += product.getPrice() * product.getNumber();
		}
		return Math.round(s * 100.0) / 100.0;
	}

	public List<Product> getItems() {
		return items;
	}
}
