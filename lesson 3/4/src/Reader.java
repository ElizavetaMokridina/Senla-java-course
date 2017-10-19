
public class Reader {
	private String name;
	private int registrationNumber;
	private Book[] books = new Book[5];

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(int registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	public Book[] getBooks() {
		return books;
	}

	public void setBooks(Book[] books) {
		this.books = books;
	}

	Reader(int registrationNumber, String name) {
		this.name = name;
		this.registrationNumber = registrationNumber;

	}

	public void addBook(int position, Book book) {
		books[position] = book;
	}

	public void removeBook(int position) {
		books[position] = null;
	}

}
