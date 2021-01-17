import java.util.*;
import java.io.*;
import java.text.*;
public class ParliamentSimulation {
	
	static String startDate = "21.10.2019";
	
	public static void main(String[] args) throws FileNotFoundException, ParseException{
		Government bundeshaus = new Government();
		Character main = createChar(bundeshaus);
		extractData(bundeshaus);
		System.out.println(bundeshaus.getPercOfPartiesIn(bundeshaus.nationalraete));
	}
	
	public static void extractData(Government bundeshaus) throws FileNotFoundException, ParseException {
		File file = new File("Mitglieder.txt");
		Scanner scan = new Scanner(file);
		while(scan.hasNext()) {
			String first = scan.next();
			String last = scan.next();
			String g = scan.next();
			while(!g.equals("m") && !g.equals("f")) {
				last = last + g;
				g = scan.next();
			}
			String canton = scan.next();
			String amt = scan.next();
			String party = scan.next();
			String j = scan.next();
		    Date dateJoin = new SimpleDateFormat("dd.MM.yyyy").parse(j);
			String b = scan.next();
		    Date dateBirth = new SimpleDateFormat("dd.MM.yyyy").parse(b);
		    
			bundeshaus.addPolitician(first, last, g, canton, dateJoin, dateBirth, amt, party);

		}
		scan.close();
	}
	
	public static Character createChar(Government bundeshaus) throws ParseException{
		Scanner scan = new Scanner(System.in);
		System.out.println("Geben Sie den Vornamen ein: ");
		String first = scan.next();
		System.out.println("Geben Sie den Nachnamen ein: ");
		String last = scan.next();
		while (scan.hasNext()){
			last = last + scan.next();
		}
		System.out.println("Geben Sie das Geschlecht ein: (m/f)");
		String g = scan.next();
		System.out.println("Geben Sie den Kanton ein: ");
		String canton = scan.next();
		System.out.println("Geben Sie das Geburtsdatum ein: (dd.MM.yyyy)");
		String b = scan.next();
	    Date dateBirth = new SimpleDateFormat("dd.MM.yyyy").parse(b);

		String j = startDate;
	    Date dateJoin = new SimpleDateFormat("dd.MM.yyyy").parse(j);
		return new Character(first, last, g, canton, dateBirth, dateJoin);
	}
	
	
}
