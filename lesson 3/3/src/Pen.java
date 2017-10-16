
public class Pen extends Product {
	private String colour;

	Pen(String name, double price, double weight, String colour) {
		super(name, price, weight);
		this.colour = colour;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

}
