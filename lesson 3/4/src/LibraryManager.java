
public class LibraryManager implements ILibraryManager {
	private Library library;

	LibraryManager(Library library) {
		this.library = library;
	}

	public void addBook(Book book) {
		if (Checker.checkLength(library.getBooks())) {
			int position = Checker.getPosition(library.getBooks());
			library.setBook(position, book);
		} else
			Printer.print("Can not add the book.");
	}

	public void addReader(Reader reader) {
		if (Checker.checkLength(library.getReaders())) {
			int position = Checker.getPosition(library.getReaders());
			library.setReader(position, reader);
		} else
			Printer.print("Can not add the reader.");
	}

	public void addBookInReader(int registrationNumber, int number) {
		int positionInLibraryReader = Checker.getPositionInLibrary(registrationNumber, library.getReaders());
		int positionInLibraryBook = Checker.getPositionInLibrary(number, library.getBooks());
		if (positionInLibraryReader != -1 && positionInLibraryBook != -1) {
			if (Checker.checkLength(library.getReaders()[positionInLibraryReader].getBooks())
					&& library.getBooks()[positionInLibraryBook].getReader() == null) {
				int position = Checker.getPosition(library.getReaders()[positionInLibraryReader].getBooks());
				library.getReaders()[positionInLibraryReader].addBook(position,
						library.getBooks()[positionInLibraryBook]);
				library.getBooks()[positionInLibraryBook].setReader(library.getReaders()[positionInLibraryReader]);
			} else
				Printer.print("Can not add the book.");
		} else
			Printer.print("Can not add the book.");
	}

	public void removeBookInReader(int registrationNumber, int number) {
		int positionInLibraryReader = Checker.getPositionInLibrary(registrationNumber, library.getReaders());
		int positionInLibraryBook = Checker.getPositionInLibrary(number, library.getBooks());
		if (positionInLibraryReader != -1 && positionInLibraryBook != -1) {
			Book[] books = library.getReaders()[positionInLibraryReader].getBooks();
			int bookPositionInReader = Checker.getBookPosition(number, books);
			if (bookPositionInReader != -1) {
				library.getReaders()[positionInLibraryReader].removeBook(bookPositionInReader);
				library.getBooks()[positionInLibraryBook].setReader(null);
			} else
				Printer.print("Book not found.");
		} else
			Printer.print("Can not delete a book.");
	}

	public void showBooksInReader(int registrationNumber) {
		int positionInLibraryReader = Checker.getPositionInLibrary(registrationNumber, library.getReaders());
		if (positionInLibraryReader != -1) {
			Book[] books = library.getReaders()[positionInLibraryReader].getBooks();
			Printer.print(library.getReaders()[positionInLibraryReader].getName() + "'s books");
			Printer.printArrayBooks(books);
		} else
			Printer.print("Reader not found");

	}

	public void showReaderInBook(int number) {
		int positionInLibraryBook = Checker.getPositionInLibrary(number, library.getBooks());
		if (positionInLibraryBook != -1) {
			if (library.getBooks()[positionInLibraryBook].getReader() == null) {
				Printer.print("Book in the library.");
			} else {
				Printer.print(library.getBooks()[positionInLibraryBook].getReader().getName());
			}
		} else {
			Printer.print("Book not found.");
		}
	}

	public void showBooks() {
		Book[] books = library.getBooks();
		for (int i = 0; i < books.length; i++) {
			if (books[i] != null) {
				Printer.printBook(books[i]);
				if (books[i].getReader() == null) {
					Printer.print("library");
				} else {
					Printer.print(books[i].getReader().getName());
				}
			}
		}
	}

	public void showReaders() {
		Reader[] readers = library.getReaders();
		for (int i = 0; i < readers.length; i++) {
			if (readers[i] != null) {
				Printer.print(readers[i].getName());
			}
		}
	}

}
