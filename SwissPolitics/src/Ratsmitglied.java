import java.util.*;
public class Ratsmitglied {
	String firstName;
	String lastName;
	String gender;
	String canton;
	Date dateJoining;
	Date dateOfBirth;
	int age;
	
	
	public Ratsmitglied(String first, String last, String gender, String canton, Date join, Date birth) {
		this.firstName = first;
		this.lastName = last;
		this.gender = gender; 
		this.canton = canton; 
		this.dateJoining = join;
		this.dateOfBirth = birth;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getGender() {
		return gender;
	}
	public String getCanton() {
		return canton;
	}
	public Date getDateJoining() {
		return dateJoining;
	}
	public Date getdateOfBirth() {
		return dateOfBirth;
	}
	public int getAge() {
		return 0;
	}
	
	@Override
	public String toString() {
		return "(" + firstName + " " + lastName + ", " + canton + ")";
	}
}
