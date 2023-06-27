package pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import pojos.Author;

@Entity
@Table (name="book")
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long bookId;
	@Column(name="book_title", length=30)
	private String bookTitle;
	
	private float price;
	@Enumerated(EnumType.STRING)
	@Column(length = 20)
	private BookCategory category;
	@ManyToOne
	@JoinColumn(name="author_id")
	private Author author;
	
	public Author getAuthor() {
		return author;
	}
	public void setAuthor(Author author) {
		this.author = author;
	}
	public long getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getBookTitle() {
		return bookTitle;
	}
	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}
	
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public BookCategory getCategory() {
		return category;
	}
	public void setCategory(BookCategory category) {
		this.category = category;
	}
	public Address( String bookTitle, float price, BookCategory category) {
		super();
		this.bookTitle = bookTitle;
		this.price = price;
		this.category = category;
	}
	public Address() {
		super();
	}
	public Address(int i) {
		// TODO Auto-generated constructor stub
		bookId=i;
	}
	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", bookTitle=" + bookTitle + ", author=" + author.getAutherName() + ", price=" + price
				+ ", category=" + category + "]";
	}
	
	
	

}
