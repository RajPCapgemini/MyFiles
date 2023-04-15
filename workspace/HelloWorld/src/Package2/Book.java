package Package2;

public class Book {
	private String bookId;
	private String title;
	private String authorName;
	private double price;
//	private MyDate releaseDate;
	
	Book(){
		
	}
	public Book(String bookId, String title, String authorName, double price) {
		super();
		this.bookId = bookId;
		this.title = title;
		this.authorName = authorName;
		this.price = price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	public void setBookId(String bookId) {
		this.bookId=bookId;
	}
	public void setTitle(String title) {
		this.title=title;
	}
	public void setAuthorName(String authorName) {
		this.authorName=authorName;
	}
	public void setPrice(int price) {
		this.price=price;
	}
	public String getBookId() {
		return this.bookId;
	}
	public String getTitle() {
		return this.title;
	}
	public String getAuthorName() {
		return this.authorName;
	}
	public double getPrice() {
		return this.price;
	}
//	public MyDate getReleaseDate() {
//		return this.releaseDate;
//	}
	
	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", title=" + title + ", authorName=" + authorName + ", price=" + price + "]";
	}

	
	
}
