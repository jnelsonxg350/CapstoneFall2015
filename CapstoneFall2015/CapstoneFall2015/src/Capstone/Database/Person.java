package Capstone.Database;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Person 
{
	private Integer personID;
	private String firstName;
	private String lastName;
	private String gender;
	private String state;
	private String zip;
	private String emailAddress;
	private Long phoneNumber;
	private Date birthday;
	public Integer getPersonID() {
		return personID;
	}
	public void setPersonID(Integer personID) {
		this.personID = personID;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
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
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public Long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getBirthdayString()
	{
		String temp = null;
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd",Locale.ENGLISH);
		if(birthday != null)
		{
			temp = df.format(birthday);
		}
		return temp;
	}
	public void setBirthdayFromString(String birthday)
	{
		try
		{
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd",Locale.ENGLISH);
			this.birthday = df.parse(birthday);
		}
		catch(Exception e)
		{
		}
	}
	@Override
	public String toString() {
		return "Person [personID=" + personID + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", gender=" + gender + ", state="
				+ state + ", zip=" + zip + ", emailAddress=" + emailAddress
				+ ", phoneNumber=" + phoneNumber + ", birthday=" + birthday
				+ "]";
	}
}
