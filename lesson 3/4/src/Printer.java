
public class Printer {

	public static void print(String string) {
		System.out.println(string);
	}

	public static void printArrayBooks(Book[] books) {
		for (int i = 0; i < books.length; i++) {
			if (books[i] != null) {
				System.out.println("author = " + books[i].getAuthor() + " name = " + books[i].getName());
			}
		}
	}

	public static void printBook(Book book) {
		System.out.println("author = " + book.getAuthor() + " name = " + book.getName());
	}

}
