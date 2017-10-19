
public class Test {
	public static void main(String[] arg) {
		Product product1 = new Milk("Prostokvashino", 1.5, 1.2);
		Product product2 = new Pen("Parker", 20, 0.3);
		Product product3 = new Milk("Savushkin product", 1.6, 0.9);
		Product product4 = new Pen("Stabilo", 2, 0.2);

		Storage storage = new Storage(4);

		storage.addProduct(product1);
		storage.addProduct(product2);
		storage.addProduct(product3);
		storage.addProduct(product4);

		double weight = storage.getTotalWeight();
		System.out.println(weight);

	}

}
