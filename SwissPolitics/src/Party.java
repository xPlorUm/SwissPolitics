import java.util.*;
public class Party {
	String name;
	ArrayList<Ratsmitglied> members;
	
	public Party(String name) {
		this.name = name;
	}
	
	public void addMember(Ratsmitglied member) {
		members.add(member);
	}
	
	public void removeMember(Ratsmitglied member) {
		for(Ratsmitglied i : members) {
			if(member.equals(i)) {
				members.remove(i);
				return;
			}
		}
		throw new IllegalArgumentException("Dieses Ratsmitglied ist nicht in dieser Partei.");
	}
	
	public String getName() {
		return name;
	}
	
	@Override
	public String toString() {
		return name;
	}
}
