
public class Library {
	private Book[] books = new Book[1000];
	private Reader[] readers = new Reader[1000];

	public Book[] getBooks() {
		return books;
	}

	public void setBooks(Book[] books) {
		this.books = books;
	}

	public Reader[] getReaders() {
		return readers;
	}

	public void setReaders(Reader[] readers) {
		this.readers = readers;
	}

	public void setBook(int position, Book book) {
		books[position] = book;
	}

	public void setReader(int position, Reader reader) {
		readers[position] = reader;
	}

}
