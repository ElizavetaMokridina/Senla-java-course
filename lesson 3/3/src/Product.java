
public class Product {
	private String name;
	private double price;
	private double weight;
	
	Product(String name, double price,double weight){
		this.name=name;
		this.price=price;
		this.weight=weight;
	}
	
	public String getName() {
		return name;
	}
	public void setPrice(int price) {
		this.price=price;
	}
	public double getPrice() {
		return price;
	}
	public double getWeight() {
		return weight;
	}

}
