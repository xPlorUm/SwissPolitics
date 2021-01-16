import java.util.*;
public class Government {
	Bundesrat[] bundesraete;
	Nationalrat[] nationalraete;
	Staenderat[] staenderaete;
	Map<Ratsmitglied, Party> raete;
	//List<Party> parties;
	
	public static int BR_SITZE = 7;
	public static int NR_SITZE = 200;
	public static int SR_SITZE = 46;
	
	
	public Government() {
		bundesraete = new Bundesrat[BR_SITZE];
		nationalraete = new Nationalrat[NR_SITZE];
		staenderaete = new Staenderat[SR_SITZE];
		
		raete = new HashMap<>();
	}
	
	public void addRat(String first, String last, String g, String canton, Date dateJoin, Date dateBirth, String amt, String str_party) {
		Ratsmitglied[] arr;
		Ratsmitglied neu;
		Party party = null;
		//if already added to list then do nothing
		for(Ratsmitglied i : raete.keySet()) {
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
		
		for(Party i : raete.values()) {
			if(i.getName().equals(str_party)) {
				party = i;
			}
		}
		if(party == null) {
			party = new Party(str_party);
		}
		raete.put(neu, party);
				
		//Ratsmitglied takes place in their Council
		for(int i=0; i<arr.length; i++) {
			if(arr[i] == null) {
				arr[i] = neu;
				return;
			}
		}
		throw new IllegalArgumentException(neu.toString() + "hat keinen Platz mehr, alles bereits besetzt.");
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
