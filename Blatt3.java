public class Blatt3 {
	
	public static void main (String args[]) throws Exception{
		long tStart, tEnd ;										//Variablen zur Messung
		float msecs = 0;										
		float sekunden;											//Variable zur Eingabe
		try{													//Parameter einlesen
			sekunden = Float.parseFloat(args[0]);				
			if(sekunden < 0){									//Bei falschem Parameter fehler ausgeben
				throw new Exception();
			}
		}
		catch(Exception e){ throw new Exception("Bitte einen Float-Wert ab 0 eingeben");}	
		int n = 1000;									//Start array Größe
		//int counter = 0;			
		while(sekunden > (msecs / 1000)){
			//counter++;
			//System.out.println("array erzeugen");
			int[] a = new int[n];						//Array mit verschiedenen Größen initialisieren
			//System.out.println("array befüllen");
			abfüll(a);									//Array absteigend befüllen
			tStart = System.currentTimeMillis();		//Startzeit
			//System.out.println("sortieren");
			bubbleSort(a);								//Sortieren
			tEnd = System.currentTimeMillis();			//endzeit
			msecs =  tEnd - tStart;						//durchlaufzeit in ms
			n = n*2;									//Verdopplung der Arraygröße
			//System.out.println("zeit:" + msecs);
			//System.out.println("durchläufe" + counter);
		}
		//System.out.println("binär");
		int erg = binarySearch(n/4,n/2,sekunden);		//Binärsuche starten
		System.out.println("gesuchte Arraygröße: " + erg);
		
		//abfüll(a);
		//tStart = System.currentTimeMillis();		Aufgabe 1
		//bubbleSort(a);
		//tEnd = System.currentTimeMillis();
		//msecs = tEnd - tStart;
		//System.out.println("Gebrauchte Zeit in ms: " + msecs);
	}
	
	public static void bubbleSort(int[] array){		//bubblesort
		int tmp;	
		int n = array.length -1;
		for(int i = 0; i <= n; i++){
			for(int j = n; j>= i+1; j--){
				if(array[j-1]>array[j]){
					tmp = array[j];
					array[j] = array[j-1];
					array[j-1] = tmp;
				}
			}
		}
	}
	public static void abfüll(int[] array){ //methode zum absteigenden Füllen des Arrays
		int zaehler = 0;
		while(zaehler < array.length){								
			array[zaehler] = array.length -zaehler;		
			zaehler++;
		}
	}
	
	public static int binarySearch(int klein, int groß, float secs){  	//Methode zur Binärsuche
		int mitte = (klein+groß) / 2;									//Ermittlung der Mitte
		int[] a = new int[mitte];										//Array mit der mittleren größe initialisieren
		long tStartbin, tEndbin ;										//Messvariablen
		float binarysecs = 0;											
		abfüll(a);														//Array absteigend befüllen
		tStartbin = System.currentTimeMillis();							//Startzeit
		bubbleSort(a);													//Sortieren
		tEndbin = System.currentTimeMillis();							//Endzeit
		binarysecs = (tEndbin - tStartbin);								//gebrauchte zeit
		if(binarysecs / 1000 >= secs -0.1 && binarysecs / 1000 <= secs + 0.1){			//Abbruchkriterium
			System.out.println("gebrauchte zeit in ms: " + binarysecs);					//Ausgabe der gebrauchten Sekunden
			return mitte;												//Rückgabe der Arraygröße
		}
		System.out.println("Arraygröße: " + mitte + " Zeit in ms: " + binarysecs); //Ausgabe der Zwischenschritte
		if( binarysecs /1000 > secs){									//Überprüfung ob array größer oder kleiner werden muss
			return binarySearch(klein, mitte,secs);						//Binärsuche für ein array, welches kleiner werden muss
		}
		else{
			return binarySearch(mitte, groß, secs);						//Binärsuche für ein array, welches größer werden muss
		}
	}
}

