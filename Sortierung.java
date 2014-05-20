public class Sortierung{
	
	public static void main (String args[]) throws Exception {
		if (args.length < 1){
			throw new Exception("Bitte einen Parameter zur Feldgröße eingeben");
		}
		if (args.length > 2){
			throw new Exception("Zu viele Parameter eingegeben!");
		}
		int n = 0;
		try{
			n = Integer.parseInt(args[0]);
			if (n<=0){
				throw new Exception();
			}
		}
		catch(Exception e){System.out.println("Bitte eine positive Integer-Zahl eingeben");
		}
		int[] a = new int[n];
		if(args.length == 2){
			if (args[1].equals( "auf")|| args[1].equals("ab")|| args[1].equals("rand")){
				if (args[1].equals("auf")){
					int zaehler = 0;
					while (zaehler < a.length){
						a[zaehler] = zaehler + 1;
						zaehler++;
					}
				}
				else if(args[1].equals("ab")){
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
		if(args.length == 1){
			java.util.Random numberGenerator = new java.util.Random();
					int zaehler = 0;
					while(zaehler < a.length){
						a[zaehler] = numberGenerator.nextInt();
						zaehler++;
					}
		}
		long tStart = System.currentTimeMillis();
		mergeSort(a);
		long tEnd = System.currentTimeMillis();
		long msecs = tEnd- tStart;
		if (isSorted(a)){
			System.out.println("Feld sortiert!");
		}
		else{
			System.out.println("Feld NICHT sortiert!");
		}
		System.out.println("Die benötigte Zeit in Millisekunden:" + msecs);
		if(n < 101){
			System.out.println("Das Feld lautet:");
			int zaehler = 0;
			while (zaehler < a.length){
				System.out.println(a[zaehler]);
				zaehler++;
			}
		}
		
	}
	public static void insertionSort(int[] array){
		int j=1;
		int key;
		int i;
		while (j < array.length){
			assert isSorted(array,j) : "Array nicht sortiert"; 						//Array ist bis j-1 sortiert
			key = array[j];
			i = j-1;
			while (i>=0 && array[i]>key){
				//assert isMax(array,j); 					//Eintritt,wenn i kleiner als Grenze von sortiertem Bereich
				array[i+1] = array[i];						// array[j-1] ist größtes Element im sortierten Bereich
				i--;
			}
			array[i+1] = key;
			j++;
		}
	}
	public static boolean isSorted(int[] array){
		int counter = 0;
		while (counter < array.length - 1){
			if (array[counter] > array[counter+1]){
				return false;
			}
			counter++;
		}
		return true;
	}
	
	public static boolean isSorted(int[] array, int grenze){
		int counter = 0;
		while (counter < grenze){
			if (array[counter] > array[counter+1]){
				return false;
			}
			counter++;
		}
		return true;
	}
	
	public static void mergeSort(int[] array){
		int a = array.length-1;
		mergeSort(array,0,a);
	}
	
	public static void mergeSort(int[] array, int p, int r){
		if ( p < r){
			int q = ((p+r) / 2);
			mergeSort(array,p,q);
			mergeSort(array,q+1,r);
			merge(array,p,q,r);
		}
	}
	
	public static void merge(int[] array, int p, int q, int r){
		int counter1 = p;
		int counter2 = q+1;
		int counter = p;
		int[] b= new int[array.length];
		while (counter < b.length){
			b[counter] = array[counter];
			counter++;
		}
		counter = 0;
		while ( counter1 <= q && counter2 <= r){
			if(b[counter1] > b[counter2]){
				array[counter] = b[counter2];
				counter++;
				counter2++;
			}
			else{
				array[counter] = b[counter1];
				counter++;
				counter1++;
			}
		}
		if( counter1> q){
			while ( counter2 <= r){
				array[counter] = b[counter2];
				counter++;
				counter2++;
			}
		}
		else {
			while (counter1 <= q){
				array[counter] = b[counter1];
				counter++;
				counter1++;
				}
			} 
			
		/*counter = 0;	
		while( counter < array.length){
			array[counter] = b[counter];
			counter++;
		}
		*/
	}
	
	/**public static boolean isMax(int[] array, int grenze){
		int counter = 0;
		while (counter < grenze){
			if(a[grenze-1] < a[counter]){
				return false;
			}
			counter++;
		}
		return true;
	}
	**/
	
}

