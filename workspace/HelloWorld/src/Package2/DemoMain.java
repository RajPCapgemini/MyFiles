package Package2;

public class DemoMain {

	public static void main(String[] args) {
		Book book1=new Book("A1","Learning Java","RP",1400);
		System.out.println(book1);
		System.out.println(book1.getBookId());
		System.out.println(book1.getAuthorName());
		System.out.println(book1.getTitle());
		System.out.println(book1.getPrice());
	}

}
