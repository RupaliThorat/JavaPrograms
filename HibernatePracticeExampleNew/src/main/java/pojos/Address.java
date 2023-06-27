package pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
@Entity

public class Address {
	@Id
	@Column (name="address_id")
	long addressId;
	@Column (name="line1", length=200)
	private String addressLine1;
	@Column (name="line2", length=200)
	private String addressLine2;
	@Column (length=20)
	private String city;
	@Column (length=20)
	private String state;
	@Column (length=20)
	private String country;
	
	private long pin;
	
	@OneToOne(fetch = FetchType.LAZY)
	@MapsId
	@JoinColumn(name="author_id", nullable=false)
	
	private Author owner ;
	
	
	
	
	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", addressLine1=" + addressLine1 + ", addressLine2=" + addressLine2
				+ ", city=" + city + ", state=" + state + ", country=" + country + ", pin=" + pin + ", owner=" + owner
				+ "]";
	}
	public Author getOwner() {
		return owner;
	}
	public void setOwner(Author owner) {
		this.owner = owner;
	}
	public Address() {
		super();
	}
	public Address(String addressLine1, String addressLine2, String city, String state, String country, long pin) {
		super();
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.city = city;
		this.state = state;
		this.country = country;
		this.pin = pin;
	}
	public long getAddressId() {
		return addressId;
	}
	public void setAddressId(long addressId) {
		this.addressId = addressId;
	}
	public String getAddressLine1() {
		return addressLine1;
	}
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}
	public String getAddressLine2() {
		return addressLine2;
	}
	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public long getPin() {
		return pin;
	}
	public void setPin(long pin) {
		this.pin = pin;
	}
	

}
