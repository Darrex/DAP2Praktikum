import java.util.ArrayList;

public class Partition 
{ 

	public static boolean parti(ArrayList<Integer> z){
		int w = 0; 								//initialisieren von w
		for (int i = 0; i<z.size() ;i++ ) {		//Summe der Elemente berechnen
			w = w + z.get(i);
		}
		if (w%2 == 1){							//Wenn die Summe ungerade ist abbrechen
			return false;
		}	
		int[][] g = new int[z.size()+1][w+1];	//Zweidimensionales array initialisieren
		for (int i = 0; i <= z.size() ; i++ ) {
			for (int j = 0; j<= (w/2) ; j++ ) {
				if(j==0){
					g[i][j]  = 1;
				}
				else if(i == 0){
					g[i][j] = 0;
				}
				else if((g[i-1][j] == 1) || (z.get((i-1)) <= j && g[i-1][j-z.get(i-1)] == 1)){
					g[i][j] = 1;
				} 
				else{
					g[i][j] = 0;
				}
			}
		}
		System.out.println("Das Ergebnisarray lautet:");
		for (int i = 0; i<=z.size() ;i++ ) {		//Ausgabe des Feldes
			for (int j = 0;j<=w ;j++ ) {
				System.out.print(g[i][j] + "");
			}
			System.out.println();
		}
		if(g[z.size()-1][(w/2)-1] == 1){			//Ergebnis zurückgeben
			return true;
		}
		else{
			return false;
		}
	}
	public static void main(String[] args) {
		if(args.length <= 0){								//Parameter überprüfen
			System.out.println("Bitte Parameter eingeben");
			return;
		}
		ArrayList<Integer> list = new ArrayList<Integer>();	//neue Arraylist erzeugen
		try{
			for(int i = 0; i < args.length; i++){			//Arraylist mit Argumenten befüllen
				int a = Integer.parseInt(args[i]);
				if (a<0){
					System.out.println("Bitte nur postive Zahlen eingeben");
					return;
				}
				list.add(a);
			}
		}
		catch(Exception e){									//Fehler fangen
			System.out.println("Bitte nur Zahlen eingeben");
			return;
		}
		if(parti(list)){									//Überprüfe ob partitionierbar und Ausgabe
			System.out.println("Liste konnte partitioniert werden");
		}
		else{
			System.out.println("Liste konnte nicht partitioniert werden");
		}
	}	
}