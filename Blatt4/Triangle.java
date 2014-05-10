public class Triangle extends Simplex {
	
	public Triangle (int d, Point... points){		//Konstruktor wird von Simplex übernommen
		super(d,points);
	}
	/*public Triangle(Point... points){				//alternativer konstruktor
		super(points);
	}*/
	
	public boolean validate(){					//Überprüfen ob 3 punkte vorhanden sind und diese die Dimension 2 haben
		if(punkte.length != 3){					//Überprüfung ob 3 punkte
			return false;
		}		
			if(punkte[0].dim() != 2){			//Überprüfung der Dimension
				return false;
			}
			if(punkte[1].dim() != 2){
				return false;
			}
			if(punkte[2].dim() != 2){
				return false;
			}
		return true;
	}
}

