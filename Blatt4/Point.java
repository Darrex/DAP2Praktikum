public class Point {
	private double[] koor; 		//Koordinatenarray
	private int d;				//Dimension
		
	public Point(int di, double... values){		//konstruktor
		if(di != values.length){					//Überprüfung der Dimension
			throw new IllegalArgumentException("Dimension ungleich Werten");
		}
		koor = values;
		d = di;
	}
	/*public Point(double... values){			//alternativer Kostruktor
		koor = values;
		d = koor.length;
	}*/
	
	public double get(int i){				//koordinaten bekommen
		return koor[i];
	}
	
	public int dim(){						//Dimension bestimmen
		return koor.length;
	}
	
}

