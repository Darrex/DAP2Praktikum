public class Sortierung2{
	
	public static void main (String args[]) throws Exception {
		if (args.length < 1){									//Parameteranzahl überprüfen
			throw new Exception("Bitte einen Parameter zur Feldgröße eingeben und eine Sortiermethode eingeben");
		}
		//if (args.length == 1){
		//	throw new Exception("Bitte ein Sortierverfahren als 2. Parameter wählen");
		}
		if (args.length > 3){
			throw new Exception("Zu viele Parameter eingegeben!");
		}
		int n = 0;
		try{
			n = Integer.parseInt(args[0]);					  //Ersten Parameter auf Gültigkeit überprüfen
			if (n<=0){
				throw new Exception();
			}
		}
		catch(Exception e){throw new Exception("Bitte eine positive Integer-Zahl eingeben");
		}
		int[] a = new int[n];
		if(args.length == 3){								//Befüllmethode auswählen
			if (args[2].equals( "auf")|| args[2].equals("ab")|| args[2].equals("rand")){ //Überprüfen ob 2. Parameter gültig ist
				if (args[2].equals("auf")){
					int zaehler = 0;
					while (zaehler < a.length){
						a[zaehler] = zaehler + 1;
						zaehler++;
					}
				}
				else if(args[2].equals("ab")){
					int zaehler = 0;
					while(zaehler < a.length){
						a[zaehler] = n-zaehler;
						zaehler++;
					}
				}
				else{
					java.util.Random numberGenerator = new java.util.Random();
					int zaehler = 0;
					while(zaehler < a.length){
						a[zaehler] = numberGenerator.nextInt();
						zaehler++;
					}
				} 
			} else{throw new Exception("Bitte als 2. Parameter auf, ab oder rand eingeben!");}
		}
		if(args.length == 2){					//Bei keinem 3. Parameter Zufallszahlen generieren
			java.util.Random numberGenerator = new java.util.Random();
					int zaehler = 0;
					while(zaehler < a.length){
						a[zaehler] = numberGenerator.nextInt();
						zaehler++;
					}
		}
		if (args[1].equals("insert")){			//Auf angegebenes Sortierverfahren überprüfen
			long tStart = System.currentTimeMillis();	//Zeit messen
			insertionSort(a);
			long tEnd = System.currentTimeMillis();
			long msecs = tEnd - tStart;											//Berechnung der gebrauchten Zeit
			System.out.println("Die benötigte Zeit in Millisekunden:" + msecs); //Ausgabe der gebrauchten Zeit
		}
		else
			long tStart = System.currentTimeMillis();	//Zeit messen
			mergeSort(a);
			long tEnd = System.currentTimeMillis();
			long msecs = tEnd - tStart;											//Berechnung der gebrauchten Zeit
			System.out.println("Die benötigte Zeit in Millisekunden:" + msecs); //Ausgabe der gebrauchten Zeit
		}
		else{
			throw new Exception("Bitte eine Sortiermethode als 2. Parameter wählen!");
		}												
		if (isSorted(a)){								//überprüfen ob Feld sortiert
			System.out.println("Feld sortiert!");
		}
		else{
			System.out.println("Feld NICHT sortiert!");
		}
		if(n < 101){										//Feldgröße überprüfen, bei Größe 100 oder kleiner Feld ausgeben
			System.out.println("Das Feld lautet:");
			int zaehler = 0;
			while (zaehler < a.length){
				System.out.print(a[zaehler]+ " ");
				zaehler++;
			}
			System.out.println("");
		}
		
	}
	public static void insertionSort(int[] array){					//Methode zum sortieren durch Insertionsort
		int j=1;
		int key;
		int i;
		while (j < array.length){
			assert isSorted(array,j) : "Schleife fehlgeschlagen!(assert)"; 						//Array ist bis j-1 sortiert
			key = array[j];
			i = j-1;
			while (i>=0 && array[i]>key){
				array[i+1] = array[i];	
				i--;
			}
			array[i+1] = key;
			j++;
		}
	}
	public static boolean isSorted(int[] array){		//Methode zur überprüfung ob das Feld aufsteigend sortiert ist
		int counter = 0;
		while (counter < array.length - 1){
			if (array[counter] > array[counter+1]){
				return false;
			}
			counter++;
		}
		return true;
	}
	
	public static boolean isSorted(int[] array, int grenze){	//Methode zur Überprüfung ob das Feld bis zum Wert grenze sortiert ist
		int counter = 0;
		while (counter < grenze){
			if (array[counter] > array[counter+1]){
				return false;
			}
			counter++;
		}
		return true;
	}
	
	public static void mergeSort(int[] array){		//Methode zu sortieren durch mergesort
		int a = array.length-1;
		mergeSort(array,0,a);  //Weitergabe an Funktion, welche näher am Algorithmus ist
	}
	
	public static void mergeSort(int[] array, int p, int r){		//Methode wie im Algorithmus vorgegeben
		if ( p < r){
			int q = ((p+r) / 2);
			mergeSort(array,p,q);		//linkes Feld sortieren
			mergeSort(array,q+1,r);		//rechtes Feld sortieren	
			merge(array,p,q,r);			//Feld zusammenfügen
			assert isSorted(array) : "Array nicht sortiert(assert)";	//array ist nach zusammenführen sortiert
		}
	}
	
	public static void merge(int[] array, int p, int q, int r){
		int[] b= new int[array.length];		//Hilfsfeld erzeugen
		for (int k = p; k <= q; k++)		//Hilfsfeld befüllen
				b[k] = array[k];
		for (int k = q; k < r; k++)
				b[r + q - k] = array[k + 1];
		int i = p; 
		int j = r;	
		for (int k = p; k <= r; k++)		//Feld zusammenfügen
			if (b[i] < b[j]){				
				array[k] = b[i];			
				i++;						
			}							
			else{
				array[k] = b[j];
				j--;
			} 		
	}
}

