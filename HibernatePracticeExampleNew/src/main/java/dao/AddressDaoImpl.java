package dao;

import static utils.HibUtils.getSf;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import pojos.Address;
import pojos.Author;


public class AddressDaoImpl implements AddressDao{
	

	public String assignAddress(Address a,long aid) {
		Session s=(Session) getSf().openSession();
		Transaction tx=s.beginTransaction();
		Author aa=null;
		try {
		aa=s.get(Author.class, aid);
			a.setOwner(aa);
			s.save(a);
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
		return "Address Assigned Successfully "+aa.getAuthorId();
	}

	@Override
	public Address getAddressOfAuthor(long i) {

		Session s=getSf().getCurrentSession();
		Transaction tx=s.beginTransaction();
		try {
			Address a=s.get(Address.class, i);
			if(a!=null)
				return a;
		}catch(RuntimeException e) {
			if(tx!=null)
				tx.rollback();
			e.printStackTrace();
			
		}
		
		return null;
	}

	@Override
	public List<Address> getAllAuthorWithAdd() {

		
		
		return null;
	}



}
