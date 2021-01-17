import java.util.*;
public class Government {
	Bundesrat[] bundesraete;
	Nationalrat[] nationalraete;
	Staenderat[] staenderaete;
	Map<Politician, Party> raete;
	List<Party> parties;
	
	public static int BR_SITZE = 7;
	public static int NR_SITZE = 200;
	public static int SR_SITZE = 46;
	
	
	public Government() {
		bundesraete = new Bundesrat[BR_SITZE];
		nationalraete = new Nationalrat[NR_SITZE];
		staenderaete = new Staenderat[SR_SITZE];
		
		raete = new HashMap<>();
		parties = new ArrayList<>();
	}
	
	public void addPolitician(String first, String last, String g, String canton, Date dateJoin, Date dateBirth, String amt, String str_party) {
		Politician[] arr;
		Politician neu;
		//if already added to list then do nothing
		for(Politician i : raete.keySet()) {
			if(i.getFirstName().equals(first) && i.getLastName().equals(last)) {
				return;
			}
		}
		
		//for each amt another Array and Reference variable;
		if(amt.equals("Bundesrat")) {
			neu = new Bundesrat(first, last, g, canton, dateJoin, dateBirth);
			arr = bundesraete;
		}else if(amt.equals("Ständerat")) {
			neu = new Staenderat(first, last, g, canton, dateJoin, dateBirth);
			arr = staenderaete;
		}else if(amt.equals("Nationalrat")) {
			neu = new Nationalrat(first, last, g, canton, dateJoin, dateBirth);
			arr = nationalraete;
		}else {
			throw new IllegalArgumentException("Falsches Amt ausgewählt");
		}
		
		addParty(str_party, neu);

		//Ratsmitglied takes place in their Council
		for(int i=0; i<arr.length; i++) {
			if(arr[i] == null) {
				arr[i] = neu;
				return;
			}
		}
		throw new IllegalArgumentException(neu.toString() + "hat keinen Platz mehr, alles bereits besetzt.");
	}
	
	public void addParty(String str_party, Politician member) {
		Party party = null;
		for(Party i : raete.values()) {
			if(i.getName().equals(str_party)) {
				party = i;
			}
		}
		
		if(party == null) {
			party = new Party(str_party);
			parties.add(party);
		}
		
		member.setParty(party);
		party.addMember(member);
		raete.put(member, party);
	}
	
	public String getPercOfPartiesIn(Politician[] arr){
		HashMap<Party, Double> result = new HashMap<>();
		for(Politician i : arr) {
			Party party = i.getParty();
			if(!result.containsKey(party)) {
				result.put(i.getParty(), 0.0);
			}
			result.put(party, result.get(party)+1.0);
		}
		return formatMap(result, arr.length);
	}
	
	public String formatMap(Map<Party, Double> map, int size) {
		for(Party i : map.keySet()) {
			Double value = (double) Math.round(map.get(i)*100.0 / size);
			map.put(i, value);
		}
		return map.toString();
	}
	
	
	
	
	
/*	
	public void deleteRat(Ratsmitglied member) {
		Ratsmitglied[] arr;
		if(amt.equals("Bundesrat")) {
			arr = bundesraete;
		}else if(amt.equals("Staenderat")) {
			arr = staenderaete;
		}else if(amt.equals("Nationalrat")) {
			arr = nationalraete;
		}else {
			throw new IllegalArgumentException("Falsches Amt ausgewählt");
		}
		for(int i=0; i<arr.length; i++) {
			if(arr[i].equals(member)) {
				arr[i] = null;
				return;
			}
		}
		throw new IllegalArgumentException("Kein solches Mitglied vorhanden.");
	}
*/	
}
