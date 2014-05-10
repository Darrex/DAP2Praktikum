import java.util.LinkedList;
import java.util.List;
public class Application {
	
	public static void main (String args[]) throws Exception {
		if(args.length < 6 && args.length > 0 || args.length < 0){								//Parameteranzahl überprüfen
			throw new Exception("Bitte 6 oder keine Parameter eingeben");	//Programmabbruch bei falscher Parameterzahl
		}
		if(args.length > 6){
			throw new Exception("Zu viele Parameter eingegeben");			//Programmabruch bei falscher Pramterzahl
		}
		Point x11;
		Point x22;
		Point x33;
		if(args.length == 6){													//Erzeugung von Punkten bei manueller Eingabe
			
			double x1,x2,x3,y1,y2,y3 ;											
			try{																//versuchen parameter als double zu interpretieren
				x1 = Double.parseDouble(args[0]);								
				y1 = Double.parseDouble(args[1]);
				x2 = Double.parseDouble(args[2]);
				y2 = Double.parseDouble(args[3]);
				x3 = Double.parseDouble(args[4]);
				y3 = Double.parseDouble(args[5]);
			}
			catch(Exception e){throw new Exception("Bitte Double Werte eingeben");} //Fehlerbehandlung
			x11 = new Point(2,x1, y1);										//erzeugung der Punkte
			x22 = new Point(2,x2, y2);
			x33 = new Point(2,x3, y3);
		}
		else{													//Erzeugung von Punkten durch Zufallszahlen
				int grenze = 1000;
				java.util.Random numberGenerator = new java.util.Random();		//neuer Zufalsszahlengenerator
				double randomnumber1 = numberGenerator.nextDouble() * grenze;
				if(numberGenerator.nextBoolean()){
					randomnumber1 *= -1;
				}
				double randomnumber2 = numberGenerator.nextDouble() * grenze;
				if(numberGenerator.nextBoolean()){
					randomnumber2 *= -1;
				}
				double randomnumber3 = numberGenerator.nextDouble() * grenze;
				if(numberGenerator.nextBoolean()){
					randomnumber3 *= -1;
				}
				double randomnumber4 = numberGenerator.nextDouble() * grenze;
				if(numberGenerator.nextBoolean()){
					randomnumber4 *= -1;
				}
				double randomnumber5 = numberGenerator.nextDouble() * grenze;
				if(numberGenerator.nextBoolean()){
					randomnumber5 *= -1;
				}
				double randomnumber6 = numberGenerator.nextDouble() * grenze;
				if(numberGenerator.nextBoolean()){
					randomnumber6 *= -1;
				}
				x11 = new Point(2,randomnumber1,randomnumber2);
				x22 = new Point(2,randomnumber3,randomnumber4);
				x33 = new Point(2,randomnumber5,randomnumber6);
		}
		Triangle t1 = new Triangle(2,x11,x22,x33);		//erzeugung des Dreiecks
		if(t1.validate()){								//Überprüfen ob Dreieck gültig ist
			System.out.println("Umfang: " + t1.perimeter());		//Ausführung der Berechnung des Umfangs
		}
		
		//erster teil zu ende
		System.out.println("Zweite Aufgabe:");
		ConvexHull c = new ConvexHull();
		/*int i = 0;			//Erstellung einer neuen Convexen Hülle
		Point[] a = new Point[6];
		a[0] = new Point(2,10,10);
		a[1] = new Point(2,10,100);
		a[2] = new Point(2,100,10);
		a[3] = new Point(2,100,100);
		a[4] = new Point(2,53,64);
		a[5] = new Point(2,60,60);*/
		Point[] a = new Point[1000];					//Erzeuge eines Punkte arrays
		int i = 0;									
		int grenze = 2000;							//festlegen der Grenze um welche doubles generiert werden sollen
		java.util.Random numberGenerator = new java.util.Random();		//neuer Zufallszahlen generator
		while(i < a.length){						//schleife zum generieren der punkte im Array
			double randomNumber1 = numberGenerator.nextDouble() * grenze - 1000;
			double randomNumber2 = numberGenerator.nextDouble() * grenze - 1000;
			a[i] = new Point(2,randomNumber1,randomNumber2);
			i++;
		}
		List<Point> erg = new LinkedList<Point>();	//Erzeugen einer Ergebnisliste
		erg = c.simpleConvex(a);							//ausführen der Hüllenberechnung
		Point[] b = new Point[erg.size()];
		b = erg.toArray(b);									//Ausgabefreundlicher in ein Array umwandeln
		i = 0;
		int count = 0;
		while (i<b.length){									//ausgabe der Liste
			System.out.println(b[i].get(0) + " " +b[i].get(1) + "  Zeilen:" +count);
			i++;
			count++;
		}
	}
}
