
public class Milk extends Product {
	private int expirationDate;

	Milk(String name, double price, double weight, int expirationDate) {
		super(name, price, weight);
		this.expirationDate = expirationDate;
	}

	public int getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(int expirationDate) {
		this.expirationDate = expirationDate;
	}

}
