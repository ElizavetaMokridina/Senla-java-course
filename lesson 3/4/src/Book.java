
public class Book {
	private int number;
	private String author;
	private String name;
	private Reader reader;

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Reader getReader() {
		return reader;
	}

	public void setReader(Reader reader) {
		this.reader = reader;
	}

	Book(int number, String author, String name) {
		this.number = number;
		this.author = author;
		this.name = name;
	}

}
