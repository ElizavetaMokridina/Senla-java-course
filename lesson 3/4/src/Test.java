
public class Test {
	public static void main(String[] arg) {

		Book book1 = new Book(1, "Oscar Wilde", "The Picture of Dorian Gray");
		Book book2 = new Book(2, "Charlotte Bronte", "Jane Eyre");
		Book book3 = new Book(3, "Jane Austen", "Pride and Prejudice");
		Book book4 = new Book(4, "George Orwell", "1984");
		Book book5 = new Book(5, "F. Scott Fitzgerald", "The Curious Case of Benjamin Button");

		Reader reader1 = new Reader(1, "John");
		Reader reader2 = new Reader(2, "Kate");

		Library library = new Library();
		LibraryManager libraryManager = new LibraryManager(library);

		libraryManager.addBook(book1);
		libraryManager.addBook(book2);
		libraryManager.addBook(book3);
		libraryManager.addBook(book4);
		libraryManager.addBook(book5);

		libraryManager.addReader(reader1);
		libraryManager.addReader(reader2);

		libraryManager.addBookInReader(1, 4);
		libraryManager.addBookInReader(1, 5);
		libraryManager.addBookInReader(2, 2);
		libraryManager.addBookInReader(2, 3);

		libraryManager.removeBookInReader(2, 3);

		libraryManager.showBooksInReader(1);
		libraryManager.showBooksInReader(2);

		libraryManager.showReaderInBook(1);
		libraryManager.showReaderInBook(2);

		libraryManager.showBooks();
		libraryManager.showReaders();

	}

}
