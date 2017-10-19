
public class Checker {

	public static boolean checkLength(Product[] array) {
		if (array[array.length - 1] == null) {
			return true;
		}
		return false;
	}

	public static int getPosition(Product[] array) {
		int position = -1;
		for (int i = 0; i < array.length; i++) {
			if (array[i] == null) {
				position = i;
				break;
			}
		}
		return position;
	}

}
