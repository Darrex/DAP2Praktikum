import java.util.ArrayList;
import java.io.RandomAccessFile;
import java.util.StringTokenizer;
import java.util.Collections;
import java.io.EOFException;
import java.util.NoSuchElementException;

public class Anwendung{

	public static int[] latenessScheduling(ArrayList<Job> jobs){								//Methode für latenessscheduling
		int n = jobs.size();																	//n auf die größe der liste setzen
		int[] a = new int[n+1];																	//ergebnisarray mit der Länge n+1 erzeugen
		int z = 0;																				//Summe der Dauer von den Jobs auf 0 initialisieren
		int i = 0;																				//Countervariable auf 0 initaliesierne
		while (i<n) {																			//durchlaufen bis im Array die Summe der Länger der jobs stehen bis zur i. Stellen
			a[i] = z;																			//a[i] auf die Summe der Dauer bis jetzt setzen
			z = z + jobs.get(i).getDauer();														//neue Dauer ermitteln
			i++;
		}
		a[i] = z;																				//letztes Element für die maximale verspätung speichern
		return a;
	}

	public static int verspaetung(int a, ArrayList<Job> jobs){									//Methode zur maximalen Verspätung
		return a-jobs.get(jobs.size()-1).getDeadline();
	}
	
	public static ArrayList<Interval> intervalScheduling(ArrayList<Interval> intervals){	//intervalscheduling
		int n = intervals.size();															// n auf die länge der Liste setzen
		ArrayList<Interval> erg = new ArrayList<Interval>();								// ErgebnisListe erstellen
		erg.add(intervals.get(0));															//erstes Element setzen
		int j = 0;
		for (int i = 1; i < n; i++){
			if(intervals.get(i).getStart() >= intervals.get(j).getEnd()){
				erg.add(intervals.get(i));
				j = i;
			}
		}
		return erg;																			//ErgebnisListe zurückgeben
	}

	public static void main(String[] args) throws Exception {
		if(args.length < 0){																//Parameteranzahl überprüfen
			throw new Exception("Zu wenige Parameter eingegeben!");
		}
		if(args.length > 2){
			throw new Exception("Zu viele Parameter eingegeben");
		}
		if(!args[0].equals("Interval") && !args[0].equals("Lateness")){						// 1.Parameter auf Interval und Lateness prüfen
			throw new Exception("Lateness oder Intervallscheduling wählen");
		}
		ArrayList<Job> ein = new ArrayList<Job>();											//Job Arraylist erzeugen		
		ArrayList<Interval> eing = new ArrayList<Interval>();								//Interval Arraylist erzeugen
		RandomAccessFile file = new RandomAccessFile(args[1],"r");							//RandomAccessFile erzeugen
		System.out.println("Bearbeite Datei" + args[1]);									//Ausgabe der Datei 
		int counter = 0;																	//Counter zum Zählen der Zeilen
		while(true){																		//Endlosschleife bis zum Ende der Datei
			try{	
				String zeile = file.readLine();												//neu zeile einlesen
				StringTokenizer st = new StringTokenizer(zeile,",");						//Strinktokenizer erzeugen und Zeile trennen
				int start = Integer.parseInt(st.nextToken());								//Erstes Token in Int umwandeln
				int ende = Integer.parseInt(st.nextToken());								// Zweites Token in int umwandeln
				if(args[0].equals("Interval")){												// Job oder Interval mit start und ende erzeugen und in die Liste einfügen
					eing.add(new Interval(start,ende));
				}
				else{
					ein.add(new Job(start,ende));
				}
				counter++;																	//Zeilencounter erhöhen
			}
			catch(NullPointerException b){break;}											//Wenn Strinktokenizer keinen String mehr bekommt Schleife beenden
			catch(EOFException e){break;}													//Wenn die Datei zuende ist Beenden
			catch(NoSuchElementException d){												//Fehlerausgabe für Stringtokenizer
				System.out.println("StringTokenizer fehler");
				break;
			}
			catch(NumberFormatException c){													//Fehlerausgabe für parse Int
				System.out.println("Stringparser Fehler");
				break;
			}
		}
		if(args[0].equals("Interval")){														// Interval oder Job teil starten
			System.out.println("Es wurden " + counter + " Zeilen mit folgendem Inhalt gelesen:");	//Ausgabe der Zeilen
			System.out.print("[");
			for (int i = 0; i < eing.size() ; i++) {											//Ausgabe der eingeĺesenen Dateien
				System.out.print(eing.get(i).toString());	
			}
			System.out.println("]");
			Collections.sort(eing);															//Sortieren
			System.out.println("Sortiert:");	
			System.out.print("[");
			for (int i = 0; i<eing.size() ;i++ ) {											//Sortierte Intervalle ausgeben
				System.out.print(eing.get(i).toString());
			}
			System.out.println("]");
			ArrayList<Interval> erg = new ArrayList<Interval>();							//ergebnis Arraylist erzeugen, in der intervallschedulig gespeichert wird
			erg = intervalScheduling(eing);													//Intervalscheduling ausführen für eing
			System.out.println("Berechnetes Intervallscheduling:");
			System.out.print("[");
			for (int i = 0; i < erg.size() ;i++ ) {											//Ausgabe des Berechneten Intervalschedulings
				System.out.print(erg.get(i).toString());
			}
			System.out.println("]");	
		}
		if(args[0].equals("Lateness")){
			System.out.println("Es wurden " + counter + " Zeilen mit folgendem Inhalt gelesen:");
			System.out.print("[");
			for (int i = 0; i< ein.size() ;i++ ) {
				System.out.print(ein.get(i).toString());
			}
			System.out.println("]");
			Collections.sort(ein);
			int[] li = new int[ein.size()];
			System.out.println("Sortiert:");
			System.out.print("[");
			for (int i = 0; i < ein.size() ; i++ ) {
				System.out.print(ein.get(i).toString());
			}
			System.out.println("]");
			li = latenessScheduling(ein);
			System.out.println("Berechnetes Latenessscheduling:");
			System.out.print("[");
			for (int i = 0; i < li.length-1 ; i++ ) {
				if(i != li.length - 2){
					System.out.print(li[i]+ ",");
				}
				else{
					System.out.print(li[i]);
				}
			}
			System.out.println("]");
			System.out.println("Maximale Verspätung: " + verspaetung(li[li.length-1], ein));	//Maximale verspätung ausrechnen und ausgeben
		}
		
	}
	
}