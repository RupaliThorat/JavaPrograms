package dao;

import static utils.HibUtils.getSf;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import pojos.Address;
import pojos.Author;
import pojos.Book;

public class BookDaoImpl implements BookDao {

	Scanner sc;

	public BookDaoImpl() {
		sc = new Scanner(System.in);
	}

	public String insertBookOfAuthor(Book b) {
		AuthorDaoImpl ad = new AuthorDaoImpl();
		Session s = (Session) getSf().openSession();
		Transaction tx = s.beginTransaction();
		String newAuth;
		try {
			List<Author> al = ad.getAllAuthors();
			for (Author a : al)
				System.out.println(a);
			System.out.println("Is Author new yes/no ");
			newAuth = sc.next();
			Author auth;
			if (newAuth.equalsIgnoreCase("yes")) {

				System.out.println("Enter Name & Qualification");
						String nm=sc.nextLine(); 
						sc.nextLine();
						String ql=sc.next();
				auth=new Author(nm,ql);

				ad.insertRecord(auth);
			} else {
				System.out.println("Enter Author id :");
			//	auth = ad.getAuthorById(sc.nextInt());
				auth = s.get(Author.class, sc.nextLong());
			}
		//	auth.setBook_list(getAllBookForAuthor(auth.getAuthorId()));
			b.setAuthor(auth);
			auth.addBook(b);
			s.save(b);
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			if (s != null)
				s.close();
		}
		return "Book Inserted Successfully " + b.getBookId();
	}

	public Book getBookById(long id) {
		Session s = (Session) getSf().openSession();
		Book b = null;
		Transaction tx = s.beginTransaction();
		try {

			b = s.get(Book.class, id);
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			if (s != null)
				s.close();
		}
		return b;
	}

	public long deleteBookById(long i) {
		Session s = (Session) getSf().openSession();

		Transaction tx = s.beginTransaction();
		try {
//			Book b=new Book(i);// this is to delete transient object   

			Book b = s.get(Book.class, i);
			if (b != null)
				s.delete(b);

			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			if (s != null)
				s.close();
		}
		return i;
	}

	public String deleteBookByTitle(String t) {
		String msg = "Book Not Deleted";
		Session s = (Session) getSf().openSession();
		Transaction tx = s.beginTransaction();
		try {

			// Working
			Query q = s.createQuery("delete Book where bookTitle=:t").setParameter("t", t);
			int result = q.executeUpdate();

			if (result > 0) {
				System.out.println("Expensive products was removed");
			}
			msg = "Book Deleted " + t;
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			if (s != null)
				s.close();
		}

		return msg;
	}

	public String deleteBookWithJpql(String t) {
		String msg = "Book Not Deleted";
		Session s = (Session) getSf().openSession();
		Transaction tx = s.beginTransaction();
		try {
			Book b = (Book) s.createQuery("select b from Book b where b.bookTitle=:t").setParameter("t", t)
					.getSingleResult();
			if (b != null)
				s.delete(b);
			tx.commit();
			msg = "Book Deleted " + t;

		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			if (s != null)
				s.close();
		}
		return msg;
	}

	public List<Book> getAllBook() {
		Session s = (Session) getSf().openSession();
		List<Book> bookList = new ArrayList<Book>();
		Transaction tx = s.beginTransaction();
		try {

			bookList = s.createQuery("select b from Book b", Book.class).getResultList();
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			if (s != null)
				s.close();
		}

		return bookList;
	}

	public List<Book> getAllBookForAuthor(long id) {
		Session s = (Session) getSf().openSession();
		List<Book> bookList = new ArrayList<Book>();
		Transaction tx = s.beginTransaction();
		AuthorDaoImpl ad = new AuthorDaoImpl();
		try {
			Author a = ad.getAuthorById(id);
			bookList = s.createQuery("select b from Book b where b.author=:auth", Book.class).setParameter("auth", a)
					.getResultList();
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			if (s != null)
				s.close();
		}

		return bookList;
	}

}
