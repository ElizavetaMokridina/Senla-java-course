
public class Test {
	public static void main(String[] arg) {
		Product[] products = { new Milk("Prostokvashino", 1.5, 1, 5), new Pen("Parker", 20, 0.3, "blue"),
				new Milk("Savushkin product", 1.6, 0.9, 4), new Pen("Stabilo", 2, 0.2, "black") };
		
		Storage storage = new Storage(4, products);
		double weight=storage.getTotalWeight();
		System.out.println(weight);
		
	}

}
