import java.util.*;
public class Party {
	String name;
	List<Politician> members;
	
	public Party(String name) {
		this.name = name;
		members = new ArrayList<>();
	}
	
	public void addMember(Politician member) {
		members.add(member);
	}
	
	public void removeMember(Politician member) {
		for(Politician i : members) {
			if(member.equals(i)) {
				members.remove(i);
				return;
			}
		}
		throw new IllegalArgumentException("Dieser Politiker ist nicht in dieser Partei.");
	}
	
	public String getName() {
		return name;
	}
	
	public int getSize() {
		return members.size();
	}
	
	@Override
	public String toString() {
		return name;
	}
}
