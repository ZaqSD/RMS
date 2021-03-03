package eu.rms.model;

import java.util.Date;
import java.util.Hashtable;

public class User {

	private Boolean isLoggedIn;

	private String email;
	private String password;
	private String firstname;
	private String lastname;
	private Boolean isMale;
	private Date bday;
	private String address;
	private int plz;
	private String city;
	private String state;
	private String country;
	private int telnr;
	private Boolean isAdmin;

	public Boolean isLoggedin() {
		String dbPassword = "abc";
		String dbEmail = "andreas.siaplaouras@gmail.com";

		Hashtable<Integer, String> hash = new Hashtable<Integer, String>();
		if (dbPassword == hash.put(120, password) && dbEmail == email) {
			return true;
		} else {
			return false;
		}
	}
	
	public Boolean getIsLoggedIn() {
		return isLoggedIn;
	}

	public void setIsLoggedIn(Boolean isLoggedIn) {
		this.isLoggedIn = isLoggedIn;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Boolean getIsMale() {
		return isMale;
	}

	public void setIsMale(Boolean isMale) {
		this.isMale = isMale;
	}

	public Date getBday() {
		return bday;
	}

	public void setBday(Date bday) {
		this.bday = bday;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getPlz() {
		return plz;
	}

	public void setPlz(int plz) {
		this.plz = plz;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getTelnr() {
		return telnr;
	}

	public void setTelnr(int telnr) {
		this.telnr = telnr;
	}

	public Boolean getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(Boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

}
