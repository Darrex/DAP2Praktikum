public class EuclidDistance implements Distance {
	
	public double distance(Point p1, Point p2){				//berechnung der Kantenlänge mit dem Euklidischen Abstand
		int  i = p1.dim();									//Abbruchkriterium der for-Schleife
		double sum = 0;
		for(int j = 0; j<i; j++){							//schleife zum durchlaufen der kooridnaten im punkt 
			sum = sum + (p1.get(j) - p2.get(j)) * ( p1.get(j) - p2.get(j));		//Berechnung der Summe unter der Wurzel
		}
		sum = Math.sqrt(sum);								//Berechnung der Wurzel
		return sum;
	}
}

