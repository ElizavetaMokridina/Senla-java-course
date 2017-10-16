
public class Sorting {
	private String[] array;
	private int size;

	Sorting(String[] array, int size) {
		this.array = array;
		this.size = size;
	}

	public void sort() {
		String temp;
		for (int i = size - 1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				if (array[j].compareToIgnoreCase(array[j + 1]) > 0) {
					temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}

			}

		}

	}

}
