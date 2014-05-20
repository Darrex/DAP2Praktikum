public class wechsel{
	
	public static void main(String[] args) throws Exception {
		if(args.length < 2 || args.length > 2){						//Überprüfung der Argumente
			throw new Exception("Bitte 2 Parameter eingeben");
		}
		if(!args[0].equals("Euro") && !args[0].equals("Alternative")){	//den 1. Parameter auf die Währung überprüfen
			throw new Exception("Als ersten Parameter die Währung angeben");
		}
		int b; 
		try{
			b = Integer.parseInt(args[1]);								//Überprüfen ob 2. Parameter eine Zahl ist
		}
		catch(Exception e){System.out.println("Bitte einen positiven Integer Wert eingeben"); return;}
		if (b < 0) {													//Überprüfen ob 2. Parameter größre 0 ist
			throw new Exception("Betrag ist negativ");
		}
		int[] w;														//Déklarieren der Währung und befüllen des Arrays je nach Währung
		if(args[0].equals("Euro") ){
			w = new int[]{200,100,50,20,10,5,2,1};
		}
		else{
			w = new int[]{200,100,50,20,10,5,4,2,1};
		}
		w = change(b,w);												//Berechnung des Arrays ,welches das Wechselgeld angibt
		int counter = 0;
		while(counter < w.length){
			System.out.print(w[counter]+" ");							//Ausgabe des Arrays
			counter++;
		}
		System.out.println("");

	}

	public static int[] change(int b, int[] w){
		int counter = 0;												//Berechnung wird solange ausgeführt wie b nicht 0 ist
		while(b != 0){
				/*if(counter != 0 && counter+1 < w.length && b % w[counter+1] == 0 && w[counter+1] < w[counter-1]){
				Sw[counter +1] = b / w[counter +1];
				counter++;
				} */
				if(b >= w[counter]){										//überprüfen ob der nächst größere Wert  kleiner als b ist
					int counter2 = 0;
					while(b - w[counter] >= w[counter]){					//überprüfen ob mehrmals der Wert abgezogen werden muss
						b = b - w[counter];
						counter2++;
					}
					b = b - w[counter];
					counter2++;
					w[counter] = counter2;
					counter++;
				}
				else{														//Wenn wert nicht kleiner b  wird der nächst größere Wert genommen
					w[counter] = 0;
					counter++;
				}
		}
		while(counter < w.length){										//falls b 0 ist wird das restliche array mit nullen aufgefüllt
			w[counter] = 0;
			counter++;
		}
		return w;
		
	}
}