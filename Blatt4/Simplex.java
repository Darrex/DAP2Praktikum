public abstract class Simplex {
	protected Point[] punkte; 
	protected int d; 				 
		
	public Simplex(int di, Point... points){			//Konstruktor
		for(int i = 0; i<points.length;i++){		//Überprüfung der Dimension
			if(points[i].dim() != di){				
				throw new IllegalArgumentException("Falsche Dimension");
			}
		}
		punkte = points;						//punkte array initialisieren
		d = di;							
	}
	/*public Simplex(Point... points){				//Alternativer Konstruktor
		punkte = points;
		d = punkte.length;
	}*/
	public Point get(int i){						//Einzelne punkte des Simplex bekommen
		return punkte[i];
	}
	
	public double perimeter(){							//Berechnung des Umfangs
		int i = 1;
		EuclidDistance d = new EuclidDistance();
		double sum = 0;
		while (i < punkte.length){						//schleife zur berechnung der Summe der Kantenlängen
			sum += d.distance(punkte[i-1],punkte[i]);
			i++;
		}
		sum += d.distance(punkte[punkte.length-1],punkte[0]); //letzte Kante berechnen, da sie nicht in der schleife vorkommt
		return sum;
	}
	public abstract boolean validate();					//abstracte Methode validate()
}

