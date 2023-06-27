package tester;

import java.util.List;
import java.util.Scanner;

import dao.AddressDao;
import dao.AddressDaoImpl;
import dao.AuthorDao;
import dao.AuthorDaoImpl;
import dao.BookDao;
import dao.BookDaoImpl;
import pojos.Address;
import pojos.Author;
import pojos.Book;
import pojos.BookCategory;


public class TesterAuthorBook {

	public static void main(String[] args) {

		try (Scanner sc = new Scanner(System.in)) {
			AuthorDao ad = new AuthorDaoImpl();
			BookDao bd = new BookDaoImpl();
			AddressDao add=new AddressDaoImpl();
			while(true) {
			
				System.out.println("\nEnter \n1.  insert Author \n 2. Display Author By id  "
						+ "\n 3. Display All Authoras \n 4. Delete Author by id "
						+ "\n 5. Delete Author by Name \n 6. insert Book for author "
						+ "\n 7. Display All books of Author by id"
						+ "\n 8. Display All Book \n 9. Exit \n10. add book of author"
						+"\n 11 Display Address of Author \n 12 Display All Address with Author");
				switch(sc.nextInt()) {
				case 1:
				System.out.println("Enter name & Qualification");
					String nm=sc.next(); 
					String ql=sc.next();
					//System.out.println("l1="+l1+"  l2="+l2+"p= "+p+"nm="+nm);
long aid=					ad.insertRecord(new Author(nm,ql));
			System.out.println("Inserted -");
			System.out.println("Do you want to add address of Author");
			if(sc.next().equalsIgnoreCase("yes"))
				System.out.println(
						"Enter Address Details addressline1, Line 2, city , state, country, pincode ");
				sc.nextLine();
				String l1 = sc.nextLine();
				//sc.nextLine();
				String l2 = sc.nextLine();
			
				String c=sc.next();
				String st=sc.next();
				String ct=sc.next();
				long p=sc.nextInt();
				add.assignAddress(new Address(l1,l2,c,st,ct,p),aid);
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
					System.out.println("Add Author along with book Enter Name & Qualification");
					Author auth=new Author(sc.next(),sc.next());
					System.out.println("Enter Book Details - Title, Price, Category(technical,horror, comedy, lovestory) ");
					Book b=	new Book(sc.next(),  sc.nextFloat(), BookCategory.valueOf(sc.next().toUpperCase()));
					auth.addBook(b);
					ad.insertRecord(auth);
					
					break;
				case 7:
					System.out.println("Enter Author id to fetch all books");
					List<Book> bl=bd.getAllBookForAuthor(sc.nextLong());
					for(Book b1:bl)
						System.out.println(b1);
					break;
				case 8:
					List<Book> bk=bd.getAllBook();
					for(Book b1:bk)
						System.out.println(b1);
					break;
				case 9:
					System.exit(0);
				
				case 10:
					System.out.println("Enter Book Details - Title, Price, Category(technical,horror, comedy, lovestory) ");
					Book b1=	new Book(sc.next(),  sc.nextFloat(), BookCategory.valueOf(sc.next().toUpperCase()));
					System.out.println(bd.insertBookOfAuthor(b1));
				case 11:
					System.out.println(add.getAddressOfAuthor(1));
				case 12:
					System.out.println(add.getAllAuthorWithAdd());
				}
				
		}
		}
	}
}
