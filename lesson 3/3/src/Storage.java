
public class Storage {
	private int size;
	private Product[] products;

	Storage(int size, Product[] products) {
		this.size = size;
		this.products = products;
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

	public double getTotalWeight() {
		double totalWeight = 0;
		for (int i = 0; i < size; i++) {
			totalWeight += products[i].getWeight();
		}
		
		return totalWeight;
	}

}
