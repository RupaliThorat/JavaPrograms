package pojos;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Author {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="author_id")
	private long authorId;
	@Column(name="author_name", length=30)
	private String autherName;
	@Column(length=20)
	private String city;
	@Column(length=30)
	private String qualification;
	
	@OneToMany(mappedBy = "author")
	List <Book> book_list;
	
	public List<Book> getBook_list() {
		return book_list;
	}
	public void setBook_list(List<Book> book_list) {
		this.book_list = book_list;
	}

	
	@Override
	public String toString() {
		return "Author [authorId=" + authorId + ", autherName=" + autherName + ", city=" + city + ", qualification="
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
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	public Author( String autherName, String city, String qualification) {
		super();
		this.autherName = autherName;
		this.city = city;
		this.qualification = qualification;
	}
	public Author() {
		super();
	}
	
	
}
