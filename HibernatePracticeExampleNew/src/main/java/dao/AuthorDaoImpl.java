package dao;

import static utils.HibUtils.getSf;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import pojos.Author;
import pojos.Book;


public class AuthorDaoImpl implements AuthorDao{
	

	public long insertRecord(Author b) {
		Session s=(Session) getSf().openSession();
		Transaction tx=s.beginTransaction();
		List<Book> bl=null;
		try {
			s.save(b);
			tx.commit();			
		}
		catch (RuntimeException e) {
			if (tx != null)
					tx.rollback();
			e.printStackTrace();
		}
		finally {
			if (s != null)
			s.close();
		}
		return b.getAuthorId();
	}

	public List<Book> getAllBooksOfAuthorById(long id){
		
		List<Book> bl=null;
		Session s=getSf().getCurrentSession();
		Transaction tx=s.beginTransaction();
		try {
			
			Author a= s.createQuery("select a from Author a where a.author_id =:i", Author.class).setParameter("i",id).getSingleResult();
			tx.commit();
			if(a!=null)
				bl= a.getBook_list();
			
		}catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
		e.printStackTrace();
	}
	finally {
		if (s != null)
		s.close();
	}		
			return bl;
	}
 public Author getAuthorById(long id){
	 Session s=(Session) getSf().openSession();
	Author b=null;
	 Transaction tx=s.beginTransaction();
		try {
			
			b=s.get(Author.class,id);
			tx.commit();			
		}
		catch (RuntimeException e) {
			if (tx != null)
					tx.rollback();
			e.printStackTrace();
		}
		finally {
			if (s != null)
			s.close();
		}
	return b;
 }
 public long deleteAuthorById(long i){
	 Session s=(Session) getSf().openSession();
	
	 Transaction tx=s.beginTransaction();
		try {
//			Author b=new Author(i);// this is to delete transient object   
			
			Author b=s.get(Author.class,i);
			if(b!=null)
				s.delete(b);
						
			tx.commit();			
		}
		catch (RuntimeException e) {
			if (tx != null)
					tx.rollback();
			e.printStackTrace();
		}
		finally {
			if (s != null)
			s.close();
		}
	return i;
 }
 public String deleteAuthorByName(String t){
	 String msg="Author Not Deleted";
	 Session s=(Session) getSf().openSession();
	 Transaction tx=s.beginTransaction();
		try {
						
			//Working
			int result = s.createQuery("delete Author where AuthorTitle=:t").setParameter("t",t).executeUpdate();
	
			 
			if (result > 0) {
			    System.out.println("Expensive products was removed");
			}
			msg="Author Deleted "+t;
		}
		catch (RuntimeException e) {
			if (tx != null)
					tx.rollback();
			e.printStackTrace();
		}
		finally {
			if (s != null)
			s.close();
		}

 	return msg;
 }
 
public List<Author> getAllAuthors(){
	 Session s=(Session) getSf().openSession();
	 List<Author> AuthorList=new ArrayList<Author>();
	 Transaction tx=s.beginTransaction();
		try {
			
			AuthorList=s.createQuery("select b from Author b", Author.class).getResultList();
			tx.commit();			
		}
		catch (RuntimeException e) {
			if (tx != null)
					tx.rollback();
			e.printStackTrace();
		}
		finally {
			if (s != null)
			s.close();
		}
	
	 return AuthorList;
}



}
