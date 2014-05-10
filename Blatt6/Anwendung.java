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
		int j = 1;
		for (int i = 1; i < n; i++){
			if(intervals.get(i).getStart() >= intervals.get(j).getEnd()){
				erg.add(intervals.get(i));
				j = i;
			}
		}
		return erg;
	}

	public static void main(String[] args) throws Exception {
		ArrayList<Interval> eing = new ArrayList<Interval>();
		RandomAccessFile file = new RandomAccessFile(args[0],"r");
		System.out.println("Bearbeite Datei" + args[0]);
		int counter = 0;
		while(true){
			try{	
				String zeile = file.readLine();
				StringTokenizer st = new StringTokenizer(zeile,",");
				int start = Integer.parseInt(st.nextToken());
				int ende = Integer.parseInt(st.nextToken());
				eing.add(new Interval(start,ende));
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
		Interval[] li = new Interval[eing.size()];
		li = eing.toArray(li);
		System.out.println("Es wurden " + counter + " Zeilen mit folgendem Inhalt gelesen:");
		System.out.print("[");
		for (int i = 0; i < li.length ; i++) {
			System.out.print("[" + li[i].getStart() + "," + li[i].getEnd() + "]");	
		}
		System.out.println("]");
		Collections.sort(eing);
		li = eing.toArray(li);
		System.out.println("Sortiert:");
		System.out.print("[");
		for (int i = 0; i<li.length ;i++ ) {
			System.out.print("[" + li[i].getStart() + "," + li[i].getEnd() + "]");
		}
		System.out.println("]");
		ArrayList<Interval> erg = new ArrayList<Interval>();
		erg = intervalScheduling(eing);
		Interval[] mi = new Interval[erg.size()];
		mi = erg.toArray(li);
		System.out.println("Berechnetes Intervallscheduling:");
		System.out.print("[");
		for (int i = 0; i < mi.length ;i++ ) {
			System.out.print("[" + mi[i].getStart() + "," + mi[i].getEnd() + "]");
		}
		System.out.println("]");
	}
	public static int[] latenessScheduling(ArrayList<Job> jobs){
		int n = jobs.size();
		int[] a = new int[n];
		int z = 0;
		for (i=0;i<n;i++) {
			a[i] = z;
			z = z + jobs.get(i).getDauer();
		}
		return a;
	}
}