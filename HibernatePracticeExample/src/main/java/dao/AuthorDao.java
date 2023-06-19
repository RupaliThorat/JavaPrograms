package dao;

import java.util.List;

import pojos.Author;
import pojos.Book;

public interface AuthorDao {
	public String insertRecord(Author b);
	 public Author getAuthorById(long id);
	 public long deleteAuthorById(long id);
		 public List<Author> getAllAuthors();
		 public String deleteAuthorByName(String t);
			public List<Book> getAllBooksOfAuthorById(long id);
}
