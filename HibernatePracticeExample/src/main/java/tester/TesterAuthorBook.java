package tester;

import java.util.List;
import java.util.Scanner;

import dao.AuthorDao;
import dao.AuthorDaoImpl;
import dao.BookDao;
import dao.BookDaoImpl;
import pojos.Author;
import pojos.Book;
import pojos.BookCategory;


public class TesterAuthorBook {

	public static void main(String[] args) {

		try (Scanner sc = new Scanner(System.in)) {
			AuthorDao ad = new AuthorDaoImpl();
			BookDao bd = new BookDaoImpl();
			
			while(true) {
			
				System.out.println("\nEnter 1. for insert Author \n 2. get By id  "
						+ "\n 3. for get All Authoras \n 4. for Delete by id "
						+ "\n 5. for delete by Name \n 6. for insert Book "
						+ "\n 7. get All books of Author by id"
						+ "\n 8. For display All Book \n 9. for Exit");
				switch(sc.nextInt()) {
				case 1:
			System.out.println("Enter Author Details - Name, city, Qualification ");
			System.out.println(ad.insertRecord(
					new Author(sc.next(),sc.next(),sc.next() )));
				
					break;
				case 2:
					System.out.println(ad.getAuthorById(1));
					break;
				case 3:
					List<Author> al=ad.getAllAuthors();
					for(Author b:al)
						System.out.println(b);
					break;
				case 4:
					System.out.println("Author Deleted Sucessfully by id"+ad.deleteAuthorById(1));
					break;
				case 5:
					System.out.println("Author Deleted Sucessfully by title "+ad.deleteAuthorByName("rrr"));
		
					break;
				case 6:
					
					System.out.println("Enter Book Details - Title, Price, Category(technical,horror, comedy, lovestory) ");
					System.out.println(bd.insertRecord(
					new Book(sc.next(),  sc.nextFloat(), BookCategory.valueOf(sc.next().toUpperCase()))));
					break;
				case 7:
					System.out.println("Enter Author id to fetch all books");
					List<Book> bl=bd.getAllBookForAuthor(sc.nextLong());
					for(Book b:bl)
						System.out.println(b);
					break;
				case 8:
					List<Book> bk=bd.getAllBook();
					for(Book b:bk)
						System.out.println(b);
					break;
				case 9:
					System.exit(0);
				
				}
		}
		}
	}
}
