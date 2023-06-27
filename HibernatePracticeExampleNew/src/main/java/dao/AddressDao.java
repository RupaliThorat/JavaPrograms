package dao;

import java.util.List;

import pojos.Address;

public interface AddressDao {
	public String assignAddress(Address a,long aid);

	public Address getAddressOfAuthor(long i);

	public List<Address> getAllAuthorWithAdd();
}
