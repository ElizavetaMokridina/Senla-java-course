import java.util.Random;

public class Main {

	public static int generateRandomNumber() {
		Random random = new Random();
		return random.nextInt(900) + 100;
	}

	public static int sum(int number1, int number2) {
		return number1 + number2;
	}

	public static int findFirstDigit(int number) {
		return number / 100;
	}

	public static int findSecondDigit(int number) {
		return number / 10 % 10;
	}

	public static void main(String[] arg) {

		for (int i = 0; i < 3; i++) {
			int number = generateRandomNumber();
			int firstDigit = findFirstDigit(number);
			int secondDigit = findSecondDigit(number);
			
			Printer.printNumber(number);
			Printer.printSum(sum(firstDigit, secondDigit));
		}
	}
}
