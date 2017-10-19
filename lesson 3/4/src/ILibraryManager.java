
public interface ILibraryManager {

	public void addBook(Book book);

	public void addReader(Reader reader);

	public void addBookInReader(int registrationNumber, int number);

	public void removeBookInReader(int registrationNumber, int number);

	public void showBooksInReader(int registrationNumber);

	public void showReaderInBook(int number);

	public void showBooks();

	public void showReaders();
}
