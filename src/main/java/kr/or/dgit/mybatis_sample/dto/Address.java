package kr.or.dgit.mybatis_sample.dto;

public class Address {
	private int addId;
	private String street;
	private String city;
	private String state;
	private String zip;
	private String country;
	
	private Address() {
		// TODO Auto-generated constructor stub
	}

	public int getAddId() {
		return addId;
	}

	public void setAddId(int addId) {
		this.addId = addId;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
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

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return String.format("Address [%s, %s, %s, %s, %s, %s]", addId, street,
				city, state, zip, country);
	}
	
	
	
	
}
