package dao;

import java.util.List;

import pojos.Book;

public interface BookDao {
	public String insertRecord(Book b);
	 public Book getBookById(long id);
	 public long deleteBookById(long id);
		 public List<Book> getAllBook();
		 public String deleteBookByTitle(String t);
		 public String deleteBookWithJpql(String t);
		 public List<Book> getAllBookForAuthor(long id);
}
