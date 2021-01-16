import java.util.*;
import java.io.*;
import java.text.*;
public class ParliamentSimulation {
	
	
	public static void main(String[] args) throws FileNotFoundException, ParseException{
		Government bundeshaus = new Government();
		extractData(bundeshaus);
		
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
		    
			bundeshaus.addRat(first, last, g, canton, dateJoin, dateBirth, amt, party);

		}
		scan.close();
	}
	
	
}
