
public class Checker {

	public static boolean checkLength(Book[] array) {
		if (array[array.length - 1] == null) {
			return true;
		}
		return false;
	}

	public static int getPosition(Book[] array) {
		int position = -1;
		for (int i = 0; i < array.length; i++) {
			if (array[i] == null) {
				position = i;
				break;
			}
		}
		return position;
	}

	public static boolean checkLength(Reader[] array) {
		if (array[array.length - 1] == null) {
			return true;
		}
		return false;
	}

	public static int getPosition(Reader[] array) {
		int position = -1;
		for (int i = 0; i < array.length; i++) {
			if (array[i] == null) {
				position = i;
				break;
			}
		}
		return position;
	}

	public static int getBookPosition(int number, Book[] array) {
		int position = -1;
		for (int i = 0; i < array.length; i++) {
			if (array[i] != null) {
				if (array[i].getNumber() == number) {
					position = i;
					break;
				}
			}
		}
		return position;

	}

	public static int getPositionInLibrary(int number, Reader[] array) {
		int position = -1;
		for (int i = 0; i < array.length; i++) {
			if (array[i] != null) {
				if (array[i].getRegistrationNumber() == number) {
					position = i;
					break;
				}
			}
		}
		return position;
	}

	public static int getPositionInLibrary(int number, Book[] array) {
		int position = -1;
		for (int i = 0; i < array.length; i++) {
			if (array[i] != null) {
				if (array[i].getNumber() == number) {
					position = i;
					break;
				}
			}
		}
		return position;
	}
}
