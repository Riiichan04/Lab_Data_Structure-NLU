package lab3;

public class Product {
	private String id;
	private String name;
	private double price;
	private String type;
	
	public Product(String id, String name, double price, String type) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.type = type;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getId() {
		return id;
	}
	
	public String getType() {
		return this.type;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int compareTo(Product p) {
		int byName = p.getName().compareTo(this.getName());
		if (byName == 0) {
			return -Double.compare(this.price, p.price);
		}
		else return byName;
	}
	
	public String toString() {
		return this.id;
	}
}
