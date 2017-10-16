import java.util.Scanner;

public class Test {
	public static void main(String[] arg) {

		Scanner in = new Scanner(System.in);
		System.out.println("Enter the size of the array:");
		int size = in.nextInt();
		String[] array = new String[size];

		for (int i = 0; i < size; i++) {
			System.out.println("Enter the string");
			array[i] = in.next();
		}

		Sorting sorting = new Sorting(array, size);
		sorting.sort();

		for (int i = 0; i < size; i++) {
			System.out.println(array[i]);
		}

	}

}
