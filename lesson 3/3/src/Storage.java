
public class Storage {
	private int size;
	private Product[] products;

	Storage(int size) {
		this.size = size;
		products = new Product[size];
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public Product[] getProducts() {
		return products;
	}

	public void setProducts(Product[] products) {
		this.products = products;
	}

	public void addProduct(Product product) {
		if (Checker.checkLength(products)) {
			int position = Checker.getPosition(products);
			products[position] = product;
		} else {
			System.out.println("Storage is full.");
		}
	}

	public double getTotalWeight() {
		double totalWeight = 0;
		for (int i = 0; i < size; i++) {
			totalWeight += products[i].getWeight();
		}

		return totalWeight;
	}

}
