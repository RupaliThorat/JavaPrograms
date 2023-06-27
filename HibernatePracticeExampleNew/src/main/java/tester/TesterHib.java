package tester;

import java.util.List;
import java.util.Scanner;

import dao.BookDao;
import dao.BookDaoImpl;
import pojos.Book;
import pojos.BookCategory;

public class TesterHib {

	public static void main(String[] args) {

		try (Scanner sc = new Scanner(System.in)) {
			BookDao bd = new BookDaoImpl();
			
			while(true) {
			
				System.out.println("\nEnter 1. for insert \n 2. for Get By ID "
						+ "\n 3. for get All Books \n 4. for Delete by id "
						+ "\n 5. for delete by title \n 6. for update book by id "
						+ "\n 7. For Delete with jpql \n 8. For Update \n 9. for Exit");
				switch(sc.nextInt()) {
				case 1:
			System.out.println("Enter Book Details - Title, Author, Price, Category(horror, comedy, lovestory) ");
//			System.out.println(bd.insertRecord(
//					new Book(sc.next(),  sc.nextFloat(), BookCategory.valueOf(sc.next().toUpperCase()))));
//				
					break;
				case 2:
					System.out.println(bd.getBookById(1));
					break;
				case 3:
					List<Book> bk=bd.getAllBook();
					for(Book b:bk)
						System.out.println(b);
					break;
				case 4:
					System.out.println("Book Deleted Sucessfully by id"+bd.deleteBookById(1));
					break;
				case 5:
					System.out.println("Book Deleted Sucessfully by title "+bd.deleteBookByTitle("rrr"));
		
					break;
				case 6:
					System.out.println("Book Deleted Sucessfully"+bd.deleteBookWithJpql("aaa"));
					break;
				case 8:
					System.out.println("Book Deleted Sucessfully"+bd.deleteBookWithJpql("aaa"));
					break;
				case 9:
					System.exit(0);
				
				}
		}
		}
	}
}
