import java.util.*;
public class Politician {
	String firstName;
	String lastName;
	String gender;
	String canton;
	Date dateJoining;
	Date dateOfBirth;
	Party party;
	int age;
	
	
	public Politician(String first, String last, String gender, String canton, Date join, Date birth) {
		this.firstName = first;
		this.lastName = last;
		this.gender = gender; 
		this.canton = canton; 
		this.dateJoining = join;
		this.dateOfBirth = birth;
		party = null;
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
	
	public Party getParty() {
		return party;
	}
	
	public void setParty(Party party) {
		this.party = party;
	}
	
	@Override
	public String toString() {
		return "(" + firstName + " " + lastName + ", " + canton + " " + party + ")";
	}
}
