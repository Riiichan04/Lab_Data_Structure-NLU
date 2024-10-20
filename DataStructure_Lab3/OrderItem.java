package lab3;

public class OrderItem {
	private Product p;
	private int quantity;
	
	public OrderItem(Product p, int quality) {
		this.p = p;
		this.quantity = quality;
	}

	public Product getProduct() {
		return p;
	}

	public void setProduct(Product p) {
		this.p = p;
	}
	
	public int compareTo(Product oP) {
		return p.compareTo(oP);
	}
}