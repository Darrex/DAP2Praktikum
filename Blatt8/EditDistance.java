import java.io.RandomAccessFile;

public class EditDistance{
	public static char[] tmp;
	
	public static int[][] distance(String a, String b){
		int[][] dist = new int[a.length()+1][b.length()+1];
		for (int i = 0; i <= b.length() ;i++ ) {
			dist[0][i] = i;
		}
		for (int i = 1;i <= a.length() ;i++ ) {
			dist[i][0] = i;
			for (int j = 1;j<=b.length() ;j++ ) {
				dist[i][j] = dist[i-1][j-1];
				if(a.charAt(i-1) != (b.charAt(j-1))){
					dist[i][j]++;
				}
				if(dist[i][j] > dist[i-1][j] +1){
					dist[i][j] = dist[i-1][j] +1;
				}
				if(dist[i][j] > dist[i][j-1] +1){
					dist[i][j] = dist[i][j-1] +1;
				}
			}
		}
		return dist;
	}

	private static String[] leseDatei(String datei) throws Exception{
		RandomAccessFile file = new RandomAccessFile(datei,"r");
		int counter = 0;
		while(file.readLine() != null){
			counter++;
		}
		file.seek(0);
		String[] zeilen = new String[counter];
		int i = 0;
		while(i <counter){
			zeilen[i] = file.readLine();
		}
		return zeilen;
	}
	
	/*private static int[] minimum(int[][] d, int i, int j){
		int[] min = new int[2];
		min[0] = i;
		min[1] = j-1;
		if(d[min[0]][min[1]] > d[i-1][j]{
			min[0] = i-1;
			min[1] = j;		
		}
		if( d[min[0]][min[1]] > d[i][j-1]{
			min[0] = i;
			min[1] = j-1;		
		}
		return min;
	}*/

	/*private static void printEditOperations(int kosten,String a, String b, int[][] d){
		System.out.println("Loesung für \"" + a + "\" --> \"" + b + "\" mit Gesamtkosten " + kosten); 
		System.out.println("==================================================================================");
		int s = b.length;		
		int z = a.length;
		int[] mini = new int[2];
		String[] operatoren = new String[]
		while( s != 0 || z != 0){
			mini = minimum(d, z, s);
			if(		
		}
		for(int i = 1; i < ; i++){		
			System.out.println(i +") Kosten " + + ": Fuege" + + "an Position" + + "ein --> " + );
		}
	}*/

	public static void main(String[] args) {
		String[] datei;
		int laenge = 2000000;
		int[][] d;
		String erste = "";
		String zweite = "";
		if(args.length < 1){
			System.out.println("Bitte Parameter eingeben");
			return;
		}
		if(args.length > 2){
			System.out.println("Zu viele Parameter eingegeben");
			return;
		}
		if(args.length == 1){
			try{
				datei = leseDatei(args[0]);
			}
			catch(Exception e){
				System.out.println("Fehler beim Lesen der Datei!");
				return;
			}
			int neue = 0;
			int[][] bested = null;
			for(int i = 0; i < datei.length; i++){
				for(int j = i ; j< datei.length; j++){					
					d = distance(datei[i],datei[j]);
					neue = d[datei[i].length()][datei[j].length()]; 					
					if( laenge > neue){
						laenge = neue;
						bested = d;
						erste = datei[i];
						zweite = datei[j];					
					}
				}
			}
			d = bested;
		}
		else{
		    erste = args[0];
		    zweite = args[1];
		    d = distance(erste,zweite);
		    laenge = d[erste.length()][zweite.length()];
		}
		System.out.println(laenge);
		tmp = erste.toCharArray();
		printEditOperations(d, d.length-1, d[0].length-1,zweite.toCharArray());
	}




	public static void printEditOperations(int d[][], int i, int j, char[] y){
  		if (i>0 && d[i-1][j] + 1 == d[i][j]){
   			printEditOperations(d,i-1, j, y);
    		tmp[j] = y[j];
    		System.out.println("füge " + y[j] + " an Position " + j+1 + " ein       Kosten: 1 --->" + new String(tmp));
  		}
  		if (j>0 && d[i][j-1] + 1 == d[i][j]){
      		printEditOperations(d,i, j-1, y);
      		int n = j+1;
      		while(tmp[n] != ' ' && n < tmp.length){
        		tmp[n-1] = tmp[n];
        		n++;
      		}
      		tmp[n] = ' ';
      		System.out.println(" Löschen        Kosten: 1 "+ new String(tmp));
  		}
 		if (i>0 && j>0 && d[i-1][j-1] + 1 == d[i][j]){
     	 	printEditOperations(d,i-1, j-1, y);
      		System.out.print(tmp[j-1]+" Ersetzen durch "+  y[i-1]+"      Kosten: 1 ");
      		tmp[j-1] = y[i-1];
     		System.out.println("--->" + new String(tmp));
  		}
  		if (i>0 && j>0 && d[i-1][j-1]  == d[i][j]){
   	 	  	printEditOperations(d,i-1, j-1, y);
   			System.out.println(tmp[j-1] +" "+ "Bleibt an der stelle" + j + "  Kosten: nix --->" + new String(tmp));
  		}
	}
}