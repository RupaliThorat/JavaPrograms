package pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Author {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="author_id")
	private long authorId;
	@Column(name="author_name", length=30)
	private String autherName;

	@Column(length=30)
	private String qualification;
	
//	@OneToOne(mappedBy="author", cascade = CascadeType.ALL)
//	private Address address;
	
	@OneToMany(mappedBy = "author", cascade = CascadeType.ALL, orphanRemoval = true)
	List <Book> book_list=new ArrayList<>();
	
	
	public void addBook(Book b) {
		book_list.add(b);
		b.setAuthor(this);
	}
	public boolean remobeBook(Book b) {
		return book_list.remove(b);
	}
	
	public List<Book> getBook_list() {
		return book_list;
	}
	public void setBook_list(List<Book> book_list) {
		this.book_list = book_list;
	}

	
	@Override
	public String toString() {
		return "Author [authorId=" + authorId + ", autherName=" + autherName + ", ="+ ", qualification="
				+ qualification + "]";
	}
	public long getAuthorId() {
		return authorId;
	}
	public void setAuthorId(long authorId) {
		this.authorId = authorId;
	}
	public String getAutherName() {
		return autherName;
	}
	public void setAutherName(String autherName) {
		this.autherName = autherName;
	}

	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	public Author( String autherName , String qualification) {
		super();
		this.autherName = autherName;
		this.qualification = qualification;
	}
	public Author() {
		super();
	}
	
	
}
