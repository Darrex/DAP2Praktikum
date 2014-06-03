import java.io.RandomAccessFile;

public class EditDistance{
	public static tmp;
	
	public static int distance(String a, String b){
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
		return dist[a.length()][b.length()];
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
	
	private static int[] minimum(int[][] d, int i, int j){
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
	}

	private static void printEditOperations(int kosten,String a, String b, int[][] d){
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
	}

	public static void main(String[] args) {
		String[] datei;
		int laenge = 0;
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
			for(int i = 0; i < datei.length; i++){
				for(int j = i ; j< datei.length; j++){					
					neue = distance(datei[i],datei[j]);					
					if( laenge > neue){
						laenge = neue;					
					}
				}
			}
		}
		else{
		    datei = new String[2];
		    datei[0] = args[0];
		    datei[1] = args[1];
		    laenge = distance(datei[0],datei[1]);
		}
		System.out.println(laenge);
	}




	public static String printEditOperations(int D[][], int i, int j, char[] x, char[] y){
 
  		if (i>0 && D[i-1][j] + 1 == D[i][j]){
   			String a = printEditOperations(D,i-1, j, x, y);
    			char[] tmp = new char[x.length + 1];
    			for(int n = 0; n != j; n++){
        			tmp[n] = x[n];
    			}
    			tmp[j] = y[j];
    			for(int n = j+1; n <= x.length; n++){
        			tmp[n] = x[n-1];
    			}
    			System.out.println("füge " + y[j] + " an Position " + j+1 + " ein       Kosten: 1 --->" + Arrays.toString(tmp));
    			return a;
    
  		}
  		if (j>0 && D[i][j-1] + 1 == D[i][j]){
      			String b = printEditOperations(D,i, j-1, x, y);
      			char[] tmp = new char[x.length - 1];
      			for(int n = 0; n < j-1; n++){
        			tmp[n] = x[n];
      			}
      			for(int n = j+1; n < x.length; n++){
        			tmp[n-1] = x[n];
      			}
      			System.out.println(" Löschen        Kosten: 1 "+ Arrays.toString(tmp));
    			return  b;
  		}
 		if (i>0 && j>0 && D[i-1][j-1] + 1 == D[i][j]){
     	 		String c = printEditOperations(D,i-1, j-1, x, y);
      			System.out.print(x[j-1]+" Ersetzen durch "+  y[i-1]+"      Kosten: 1 ");
      			x[j-1] = y[i-1];
     			System.out.println("--->" + Arrays.toString(x));
   	 		return  c;
  		}
  		if (i>0 && j>0 && D[i-1][j-1]  == D[i][j]){
   	 	  	String d = printEditOperations(D,i-1, j-1, x, y);
      			System.out.println(x[j-1] +" "+ "Bleibt an der stelle" + j + "  Kosten: nix --->" + Arrays.toString(x));
    			return  d;
  		}
 	 	return "";
	}
}