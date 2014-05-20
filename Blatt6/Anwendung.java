import java.util.ArrayList;
import java.io.RandomAccessFile;
import java.util.StringTokenizer;
import java.util.Collections;
import java.io.EOFException;
import java.util.NoSuchElementException;

public class Anwendung{
	public static ArrayList<Interval> intervalScheduling(ArrayList<Interval> intervals){
		int n = intervals.size();
		ArrayList<Interval> erg = new ArrayList<Interval>();
		erg.add(intervals.get(0));
		int j = 0;
		for (int i = 1; i < n; i++){
			if(intervals.get(i).getStart() >= intervals.get(j).getEnd()){
				erg.add(intervals.get(i));
				j = i;
			}
		}
		return erg;
	}

	public static void main(String[] args) throws Exception {
		if(args.length < 0){
			throw new Exception("Zu wenige Parameter eingegeben!");
		}
		if(args.length > 2){
			throw new Exception("Zu viele Parameter eingegeben");
		}
		if(!args[0].equals("Interval") && !args[0].equals("Lateness")){
			throw new Exception("Lateness oder Intervallscheduling wählen");
		}
		ArrayList<Job> ein = new ArrayList<Job>();
		ArrayList<Interval> eing = new ArrayList<Interval>();
		RandomAccessFile file = new RandomAccessFile(args[1],"r");
		System.out.println("Bearbeite Datei" + args[1]);
		int counter = 0;
		while(true){
			try{	
				String zeile = file.readLine();
				StringTokenizer st = new StringTokenizer(zeile,",");
				int start = Integer.parseInt(st.nextToken());
				int ende = Integer.parseInt(st.nextToken());
				if(args[0].equals("Interval")){
					eing.add(new Interval(start,ende));
				}
				else{
					ein.add(new Job(start,ende));
				}
				counter++;
			}
			catch(NullPointerException b){break;}
			catch(EOFException e){break;}
			catch(NoSuchElementException d){
				System.out.println("StringTokenizer fehler");
				break;
			}
			catch(NumberFormatException c){
				System.out.println("Stringparser Fehler");
				break;
			}
		}
		if(args[0].equals("Interval")){
			Interval[] li = new Interval[eing.size()];
			li = eing.toArray(li);
			System.out.println("Es wurden " + counter + " Zeilen mit folgendem Inhalt gelesen:");
			System.out.print("[");
			for (int i = 0; i < li.length ; i++) {
				System.out.print(li[i].toString());	
			}
			System.out.println("]");
			Collections.sort(eing);
			li = eing.toArray(li);
			System.out.println("Sortiert:");
			System.out.print("[");
			for (int i = 0; i<li.length ;i++ ) {
				System.out.print(li[i].toString());
			}
			System.out.println("]");
			ArrayList<Interval> erg = new ArrayList<Interval>();
			erg = intervalScheduling(eing);
			Interval[] mi = new Interval[erg.size()];
			mi = erg.toArray(mi);
			System.out.println("Berechnetes Intervallscheduling:");
			System.out.print("[");
			for (int i = 0; i < mi.length ;i++ ) {
				System.out.print(mi[i].toString());
			}
			System.out.println("]");	
		}
		if(args[0].equals("Lateness")){
			Job[] e = new Job[ein.size()];
			e = ein.toArray(e);
			System.out.println("Es wurden " + counter + " Zeilen mit folgendem Inhalt gelesen:");
			System.out.print("[");
			for (int i = 0; i< e.length ;i++ ) {
				System.out.print(e[i].toString());
			}
			System.out.println("]");
			Collections.sort(ein);
			e = ein.toArray(e);
			int[] li = new int[ein.size()];
			System.out.println("Sortiert:");
			System.out.print("[");
			for (int i = 0; i < e.length ; i++ ) {
				System.out.print(e[i].toString());
			}
			System.out.println("]");
			li = latenessScheduling(ein);
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
			System.out.println("Maximale Verspätung: " + verspaetung(li[li.length-1], ein));
		}
		
	}
	public static int[] latenessScheduling(ArrayList<Job> jobs){
		int n = jobs.size();
		int[] a = new int[n+1];
		int z = 0;
		int i = 0;
		while (i<n) {
			a[i] = z;
			z = z + jobs.get(i).getDauer();
			i++;
		}
		a[i] = z;
		return a;
	}	
	public static int verspaetung(int a, ArrayList<Job> jobs){
		int i = 0;
		int n = jobs.size();
		int max = jobs.get(i).getDeadline();
		while(i<n-1){
			if(jobs.get(i+1).getDeadline() > jobs.get(i).getDeadline()){
				max = jobs.get(i+1).getDeadline();
			}
			i++;
		}
		int erg = a-max;
		return erg;
	}
}